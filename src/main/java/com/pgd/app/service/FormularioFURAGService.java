package com.pgd.app.service;

import com.pgd.app.Exception.EntidadNotFoundException;
import com.pgd.app.Exception.FormularioNotFoundException;
import com.pgd.app.dto.FormularioFURAG.CreateFormularioFURAGDTO;
import com.pgd.app.model.*;
import com.pgd.app.repository.*;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FormularioFURAGService {

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;
    private final ConfigPlantillaFuragRepository configPlantillaFuragRepository;
    private final EntidadRepository entidadRepository;

    public FormularioFURAGService(FormularioFURAGRepository formularioFURAGRepository, PreguntaRepository preguntaRepository, RespuestaRepository respuestaRepository, ConfigPlantillaFuragRepository configPlantillaFuragRepository, EntidadRepository entidadRepository) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
        this.configPlantillaFuragRepository = configPlantillaFuragRepository;
        this.entidadRepository = entidadRepository;
    }

    public void guardarFormularioFURAG(CreateFormularioFURAGDTO formularioFURAGDTO) {

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
        formularioFURAGRepository.save(formularioFURAG);
    }

    public File generarArchivoFurag(String sourceFilePath, String destinationFilePath, Long formularioFURAGId) throws IOException {


        //primero: copiar el archivo plantilla y crear workbook con el nuevo
        //segundo: localizar columna preguntas y observaciones
        //para cada pregunta, traer campo respuesta de repositorio y poner en columna observaciones para esa pregunta

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
        //cuarto: generar el campo/texto de obervaciones:
        //incluir que se tomaron acciones dependiendo de la respuesta positiva de cada pregunta de gestion extendida
        //incluir el link de las evidencias que el usuario adjuntó
        //quinto: generar el campo de puntaje:
        //puntaje va de 0 a 100, (#respuestasGEPositivas*100)/#preguntasGE
        //puntaje calculado: Tiene preguntas de gestion extendida respondidas ya sea si o no
        //puntaje = 1: Tiene preguntas de gestion extendida respondidas todas en no
        //puntaje = 0: No tiene preguntas de gestion extendida respondidas
        respuestaRepository.deleteAllByFormularioFURAG_Id(formularioFURAGId);
        FormularioFURAG formularioFURAG = formularioFURAGRepository.findById(formularioFURAGId)
                .orElseThrow(() -> new FormularioNotFoundException("Id de formulario no encontrado"));
        Set<Pregunta> preguntasFURAG = formularioFURAG.getPreguntas();
        preguntasFURAG.forEach(
                pregunta -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    AtomicInteger numPositivas = new AtomicInteger();
                    AtomicBoolean preguntaGEHasRespuestas = new AtomicBoolean(false);
                    pregunta.getPreguntasGE().forEach(
                            preguntaGE -> {
                                if (!preguntaGE.getRespuestasGE().isEmpty()) {
                                    preguntaGEHasRespuestas.set(true);
                                    preguntaGE.getRespuestasGE().forEach(
                                            respuestaGE -> {
                                                if (respuestaGE.isOpcion()) {
                                                    stringBuilder.append(preguntaGE.getEnunciado()).append("\n");
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
                    respuesta.setTexto(stringBuilder.toString());
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
