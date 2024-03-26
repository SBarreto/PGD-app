package com.pgd.app.dto;

import com.pgd.app.model.Pregunta;

public record PreguntaDTO(
        String id,
        String enunciado,
        String elemento) {

    public PreguntaDTO(Pregunta pregunta) {
        this(pregunta.getId(), pregunta.getEnunciado(), pregunta.getElemento());
    }
}
