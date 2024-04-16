package com.pgd.app.controller;


import com.pgd.app.dto.FormularioFURAG.CreateFormularioFURAGDTO;
import com.pgd.app.dto.FormularioFURAG.GetFormularioFURAGDTO;
import com.pgd.app.dto.FormularioFURAG.UpdateFormularioFURAGDTO;
import com.pgd.app.dto.PreguntaDTO;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.service.FormularioFURAGService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public FormularioController(FormularioFURAGRepository formularioFURAGRepository, FormularioFURAGService formularioFURAGService) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.formularioFURAGService = formularioFURAGService;
    }

    Logger logger = LoggerFactory.getLogger(FormularioController.class);

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
                                                pregunta.getEnunciado()
                                        )
                                ).toList()));
    }

    @PostMapping("/api/formulario")
    public void createFormularioFURAG(@RequestBody CreateFormularioFURAGDTO formularioFURAGDTO) {
        formularioFURAGService.guardarFormularioFURAG(formularioFURAGDTO);
    }

    @PutMapping("/api/formulario")
    public void deleteFormularioFURAG(@RequestBody UpdateFormularioFURAGDTO updateFormularioFURAGDTO) {

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

    @DeleteMapping("/api/formulario/{id}")
    public void deleteFormularioFURAG(@PathVariable Long id) {
        formularioFURAGRepository.deleteById(id);
    }

    /*@PostMapping("api/formulario/generar/{id}")
    public ResponseEntity<Resource> generarArchivoFURAG(@PathVariable Long id) throws IOException {
        File file = formularioFURAGService.generarArchivoFurag();
        File fileExcel = formularioFURAGService.copyExcelFile(
                "C:\\datawork\\PGDI\\backend\\PGD-app\\files\\Autodiagnostico Gobierno Digital V0.2.xlsx",
                "C:\\datawork\\PGDI\\backend\\PGD-app\\files\\Autodiagnostico Gobierno Digital V0.3.xlsx");
        Resource resource = new FileSystemResource(fileExcel);

        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION, "attachmente; filename=\"" + fileExcel.getName() + "\"")
                .body(resource);

    }*/
}