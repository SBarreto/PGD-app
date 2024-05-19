package com.pgd.app.service;

import com.pgd.app.client.ChatGPTClient;
import com.pgd.app.dto.PreguntaDTO;
import com.pgd.app.dto.formulariofurag.GetFormularioFURAGDTO;
import com.pgd.app.exception.EntidadNotFoundException;
import com.pgd.app.exception.FormularioNotFoundException;
import com.pgd.app.dto.formulariofurag.CreateFormularioFURAGDTO;
import com.pgd.app.exception.FormularioSinRespuestasException;
import com.pgd.app.model.*;
import com.pgd.app.repository.*;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FormularioFURAGService {

    @Value("${texto.generacion.observaciones}")
    private String prompt;

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;
    private final ConfigPlantillaFuragRepository configPlantillaFuragRepository;
    private final EntidadRepository entidadRepository;
    private final ChatGPTClient chatGPTClient;

    public FormularioFURAGService(FormularioFURAGRepository formularioFURAGRepository, PreguntaRepository preguntaRepository, RespuestaRepository respuestaRepository, ConfigPlantillaFuragRepository configPlantillaFuragRepository, EntidadRepository entidadRepository, ChatGPTClient chatGPTClient) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
        this.configPlantillaFuragRepository = configPlantillaFuragRepository;
        this.entidadRepository = entidadRepository;
        this.chatGPTClient = chatGPTClient;
    }

    public GetFormularioFURAGDTO guardarFormularioFURAG(CreateFormularioFURAGDTO formularioFURAGDTO) {

        FormularioFURAG formularioFURAG = new FormularioFURAG(formularioFURAGDTO.vigencia());
        formularioFURAG.setEntidad(entidadRepository.findById(formularioFURAGDTO.codigoEntidad())
                .orElseThrow(() -> new EntidadNotFoundException("Codigo de entidad no encontrado")));
        formularioFURAGDTO.preguntas().forEach(
                preguntaDTO -> preguntaRepository.findById(preguntaDTO.id()).ifPresentOrElse(
                        pregunta -> {
                            pregunta.setEnunciado(preguntaDTO.enunciado());
                            pregunta.setElemento(preguntaDTO.elemento());
                            pregunta.getFormulariosFURAG().add(formularioFURAG);
                            formularioFURAG.getPreguntas().add(pregunta);
                        },
                        () -> {
                            Pregunta pregunta = new Pregunta(
                                    preguntaDTO.id(),
                                    preguntaDTO.enunciado(),
                                    preguntaDTO.elemento());
                            pregunta.getFormulariosFURAG().add(formularioFURAG);
                            formularioFURAG.getPreguntas().add(pregunta);
                        }
                )
        );
        FormularioFURAG formularioFURAGToReturn = formularioFURAGRepository.save(formularioFURAG);
        return new GetFormularioFURAGDTO(
                formularioFURAGToReturn.getId(),
                formularioFURAGToReturn.getVigencia(),
                formularioFURAGToReturn.getPreguntas().stream().map(
                        pregunta -> new PreguntaDTO(
                                pregunta.getId(),
                                pregunta.getEnunciado(),
                                pregunta.getElemento()
                        )
                ).toList()
        );
    }

    public File generarArchivoFurag(String sourceFilePath, String destinationFilePath, Long formularioFURAGId) throws IOException {


        //primero: copiar el archivo plantilla y crear workbook con el nuevo
        //segundo: localizar columna preguntas y observaciones
        //para cada pregunta, traer campo respuestaGE de repositorio y poner en columna observaciones para esa pregunta

        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Create FileInputStream for source Excel file
        // Read source Excel file into a Workbook
        try (FileInputStream fis = new FileInputStream(sourceFilePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            //hoja que se diligencia con puntaje y observaciones de cada pregunta
            Sheet sheet = workbook.getSheetAt(2);
            FileOutputStream fos = new FileOutputStream(destinationFilePath);

            //Generar observaciones
            Set<Respuesta> respuestasPlantillaActual = respuestaRepository.findAllByFormularioFURAG_Id(formularioFURAGId);
            for (ConfigPlantillaFurag preguntaPlantilla : configPlantillaFuragRepository.findAll()) {
                Row row = sheet.getRow(preguntaPlantilla.getFila());
                //columna de observaciones
                Cell cellObservaciones = row.getCell(6);
                //columna de puntaje
                Cell cellPuntaje = row.getCell(5);
                respuestasPlantillaActual.forEach(
                        respuesta -> {
                            if (respuesta.getPregunta().getId().equals(preguntaPlantilla.getPreguntaId()) && respuesta.getPuntaje() != 0) {
                                cellObservaciones.setCellValue(respuesta.getTexto());
                                cellPuntaje.setCellValue(respuesta.getPuntaje());
                            }
                        }
                );
            }

            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            //Generar puntajes
            workbook.write(fos);
            //cerrar todos los flujos
            fos.close();
        }
        return destinationFile;
    }

    @Transactional
    public void generarObservacionesFormularioFURAG(Long formularioFURAGId) {

        //primero: se deben tomar las preguntas respondidas del formulario
        //segundo: para cada pregunta, se deben tomar las preguntas de gestion extendida asociadas respondidas
        //tercero: para cada pregunta de gestion extendida, se debe saber las respuestas de gestion extendida
        //cuarto: generar el campo/evidencia de obervaciones:
        //incluir que se tomaron acciones dependiendo de la respuestaGE positiva de cada pregunta de gestion extendida
        //incluir el link de las evidencias que el usuario adjuntó
        //quinto: generar el campo de puntaje:
        //puntaje va de 0 a 100, (#respuestasGEPositivas*100)/#preguntasGE
        //puntaje calculado: Tiene preguntas de gestion extendida respondidas ya sea si o no
        //puntaje = 1: Tiene preguntas de gestion extendida respondidas todas en no
        //puntaje = 0: No tiene preguntas de gestion extendida respondidas

        //Si se vuelve a generar el formulario, limpiar primero las respuestas generadas
        respuestaRepository.deleteAllByFormularioFURAG_Id(formularioFURAGId);
        FormularioFURAG formularioFURAG = formularioFURAGRepository.findById(formularioFURAGId)
                .orElseThrow(() -> new FormularioNotFoundException("Id de formulario no encontrado"));
        if (formularioFURAG.getRespuestasGE().isEmpty()) {
            throw new FormularioSinRespuestasException("Este formulario no tiene respuestas de gestion extendida asociadas a ninguna de sus preguntas, no se puede generar plantilla diligenciada");
        }
        Set<Pregunta> preguntasFURAG = formularioFURAG.getPreguntas();
        preguntasFURAG.forEach(
                pregunta -> {
                    StringBuilder stringBuilderOberservaciones = new StringBuilder(prompt + " ");
                    StringBuilder stringBuilderEvidencias = new StringBuilder("Evidencias: ");
                    AtomicInteger numPositivas = new AtomicInteger();
                    AtomicBoolean preguntaGEHasRespuestas = new AtomicBoolean(false);
                    pregunta.getPreguntasGE().forEach(
                            preguntaGE -> {
                                if (!preguntaGE.getRespuestasGE().isEmpty()) {
                                    preguntaGEHasRespuestas.set(true);
                                    //filtrar todas las respuestas de gestion extendidas para que solo queden las de este formulario
                                    preguntaGE.getRespuestasGE().stream().filter(
                                            respuestaGE -> respuestaGE.getFormularioFURAG().getId() == formularioFURAGId
                                    ).toList().forEach(
                                            respuestaGE -> {
                                                if (respuestaGE.isOpcion()) {
                                                    stringBuilderOberservaciones
                                                            .append(preguntaGE.getEnunciado())
                                                            .append("\n");
                                                    stringBuilderEvidencias
                                                            .append(respuestaGE.getEvidencia().getTexto())
                                                            .append("\n");
                                                    numPositivas.getAndIncrement();
                                                }
                                            });
                                }
                            }
                    );
                    int puntajeCalculado = 0;
                    Respuesta respuesta = new Respuesta();
                    respuesta.setFormularioFURAG(formularioFURAG);
                    respuesta.setPregunta(pregunta);

                    //Construir las observaciones con chatgpt y luego adjuntar links de evidencias si la pregunta tiene respuestas
                    if (preguntaGEHasRespuestas.get()) {
                        String respuestasYEvidencias = chatGPTClient.promptObservaciones(String.valueOf(stringBuilderOberservaciones)) +
                                "\n" +
                                stringBuilderEvidencias;
                        respuesta.setTexto(respuestasYEvidencias);
                    } else
                        respuesta.setTexto("No existen respuestas de gestion extendida para esta pregunta ni evidencias.");

                    if (preguntaGEHasRespuestas.get() && numPositivas.get() > 0) {
                        puntajeCalculado = (numPositivas.get() * 100) / pregunta.getPreguntasGE().size();
                    } else if (preguntaGEHasRespuestas.get()) {
                        puntajeCalculado = 1;
                    }

                    respuesta.setPuntaje(puntajeCalculado);
                    respuestaRepository.save(respuesta);
                });
    }

}
