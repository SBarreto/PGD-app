package com.pgd.app.service;

import com.pgd.app.dto.FormularioFURAG.CreateFormularioFURAGDTO;
import com.pgd.app.model.FormularioFURAG;
import com.pgd.app.model.Pregunta;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FormularioFURAGService {

    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaRepository preguntaRepository;

    public FormularioFURAGService(FormularioFURAGRepository formularioFURAGRepository, PreguntaRepository preguntaRepository) {
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaRepository = preguntaRepository;
    }

    public void guardarFormularioFURAG(CreateFormularioFURAGDTO formularioFURAGDTO) {

        FormularioFURAG formularioFURAG = new FormularioFURAG(formularioFURAGDTO.vigencia());
        formularioFURAGDTO.preguntas().forEach(
                preguntaDTO -> {
                    preguntaRepository.findById(preguntaDTO.id()).ifPresentOrElse(
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
                    );
                }
        );
        formularioFURAGRepository.save(formularioFURAG);
    }
}
