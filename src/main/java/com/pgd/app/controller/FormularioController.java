package com.pgd.app.controller;

import com.pgd.app.dto.formulariofurag.CreateFormularioFURAGDTO;
import com.pgd.app.dto.formulariofurag.GetFormularioFURAGDTO;
import com.pgd.app.dto.formulariofurag.UpdateFormularioFURAGDTO;
import com.pgd.app.dto.PreguntaDTO;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.service.FormularioFURAGService;
import com.pgd.app.service.PuntajeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FormularioController {

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final FormularioFURAGService formularioFURAGService;
    private final PuntajeService puntajeService;

    @Value("${ruta.archivo.plantilla}")
    private String rutaArchivoPlantilla;

    @Value("${ruta.archivo.formulariogenerado}")
    private String rutaArchivoGenerado;

    public FormularioController(FormularioFURAGRepository formularioFURAGRepository, FormularioFURAGService formularioFURAGService, PuntajeService puntajeService) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.formularioFURAGService = formularioFURAGService;
        this.puntajeService = puntajeService;
    }


    @Operation(summary = "Tomar todos los formularios, este endpoint es mas de prueba, no va a haber caso de uso real para traer todos los formularios guardados")
    @GetMapping("/api/formularios")
    public List<GetFormularioFURAGDTO> getAllFormularios() {

        return formularioFURAGRepository.findAll().stream().map(
                formularioFURAG -> new GetFormularioFURAGDTO(
                        formularioFURAG.getId(),
                        formularioFURAG.getVigencia(),
                        formularioFURAG.getPreguntas().stream().map(
                                pregunta -> new PreguntaDTO(
                                        pregunta.getId(),
                                        pregunta.getEnunciado(),
                                        pregunta.getElemento()
                                )
                        ).toList()
                )
        ).toList();

    }

    @Operation(summary = "Tomar un formulario FURAG y todas sus preguntas asociadas")
    @GetMapping("/api/formulario/{id}")
    public Optional<GetFormularioFURAGDTO> getFormularioById(@PathVariable Long id) {

        return formularioFURAGRepository.findById(id).map(
                formularioFURAG ->
                        new GetFormularioFURAGDTO(
                                formularioFURAG.getId(),
                                formularioFURAG.getVigencia(),
                                formularioFURAG.getPreguntas().stream().map(
                                        pregunta -> new PreguntaDTO(
                                                pregunta.getId(),
                                                pregunta.getEnunciado(),
                                                pregunta.getElemento()
                                        )
                                ).toList()));
    }

    @Operation(summary = "Crear un nuevo formulario FURAG, puede venir con preguntas")
    @PostMapping("/api/formulario")
    public GetFormularioFURAGDTO createFormularioFURAG(@RequestBody CreateFormularioFURAGDTO formularioFURAGDTO) {
        return formularioFURAGService.guardarFormularioFURAG(formularioFURAGDTO);
    }

    @Operation(summary = "Editar un formulario FURAG o sus preguntas")
    @PutMapping("/api/formulario")
    public void editFormularioFURAG(@RequestBody UpdateFormularioFURAGDTO updateFormularioFURAGDTO) {

        FormularioFURAG formularioFURAG = new FormularioFURAG();
        formularioFURAG.setId(updateFormularioFURAGDTO.id());
        formularioFURAG.setVigencia(updateFormularioFURAGDTO.vigencia());
        formularioFURAG.setPreguntas(
                updateFormularioFURAGDTO.preguntas().stream().map(
                                preguntaDTO -> new Pregunta(
                                        preguntaDTO.id(),
                                        preguntaDTO.enunciado(),
                                        preguntaDTO.elemento()))
                        .collect(Collectors.toSet()));
        formularioFURAGRepository.save(formularioFURAG);
    }

    @Operation(summary = "Borrar un formulario FURAG")
    @DeleteMapping("/api/formulario/{id}")
    public void deleteFormularioFURAG(@PathVariable Long id) {
        formularioFURAGRepository.deleteById(id);
    }

    @Operation(summary = "Generar el archivo excel de un formulario FURAG a partir de las preguntas de gestion extendida respondidas" +
            "se calculan puntajes y se genea campo de observaciones")
    @PostMapping("api/formulario/generar/{id}")
    public ResponseEntity<Resource> generarArchivoFURAG(@PathVariable Long id) throws IOException {
        formularioFURAGService.generarObservacionesFormularioFURAG(id);
        File fileExcel = formularioFURAGService.generarArchivoFurag(
                rutaArchivoPlantilla,
                rutaArchivoGenerado,
                id);
        puntajeService.calcularPuntajes(id);
        Resource resource = new FileSystemResource(fileExcel);

        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION, "attachmente; filename=\"" + fileExcel.getName() + "\"")
                .body(resource);
    }

}