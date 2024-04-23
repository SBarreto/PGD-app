package com.pgd.app.dto.GE;

public record GetPreguntaGEDTO(
        String id,
        String enunciado,
        String evidenciaSugerida,
        String rolSugerido,
        String idPreguntaFurag) { }
