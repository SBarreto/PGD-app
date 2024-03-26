package com.pgd.app.controller;


import com.pgd.app.dto.FormularioFURAG.CreateFormularioFURAGDTO;
import com.pgd.app.dto.FormularioFURAG.GetFormularioFURAGDTO;
import com.pgd.app.dto.FormularioFURAG.UpdateFormularioFURAGDTO;
import com.pgd.app.dto.PreguntaDTO;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FormularioController {

    private final FormularioFURAGRepository formularioFURAGRepository;

    public FormularioController(FormularioFURAGRepository formularioFURAGRepository) {
        this.formularioFURAGRepository = formularioFURAGRepository;
    }

    Logger logger = LoggerFactory.getLogger(FormularioController.class);

    @GetMapping("/api/formularios")
    public List<GetFormularioFURAGDTO> getAllFormularios()
    {

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
    public Optional<GetFormularioFURAGDTO> getFormularioById(@PathVariable Long id)
    {

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

        FormularioFURAG formularioFURAG = new FormularioFURAG(
                formularioFURAGDTO.vigencia());
        formularioFURAG.setPreguntas(formularioFURAGDTO.preguntas().stream().map(
                preguntaDTO -> new Pregunta(preguntaDTO.id(), preguntaDTO.enunciado(), preguntaDTO.elemento(), formularioFURAG)
        ).toList());
        formularioFURAGRepository.save(formularioFURAG);
    }

    @PutMapping("/api/formulario")
    public void editFormularioFURAG(@RequestBody UpdateFormularioFURAGDTO updateFormularioFURAGDTO) {

        FormularioFURAG formularioFURAG = new FormularioFURAG();
        formularioFURAG.setId(updateFormularioFURAGDTO.id());
        formularioFURAG.setVigencia(updateFormularioFURAGDTO.vigencia());
        formularioFURAG.setPreguntas(
                updateFormularioFURAGDTO.preguntas().stream().map(
                preguntaDTO -> new Pregunta(preguntaDTO.id(), preguntaDTO.enunciado(), preguntaDTO.elemento(), formularioFURAG)
        ).toList());
        formularioFURAGRepository.save(formularioFURAG);
    }

    @DeleteMapping("/api/formulario/{id}")
    public void editFormularioFURAG(@PathVariable Long id) {
        formularioFURAGRepository.deleteById(id);
    }
}