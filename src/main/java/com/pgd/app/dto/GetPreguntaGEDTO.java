package com.pgd.app.dto;

public record GetPreguntaGEDTO(
        String id,
        String enunciado,
        String evidenciaSugerida,
        String rolSugerido,
        String idPreguntaFurag) { }
