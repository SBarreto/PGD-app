package com.pgd.app.dto.ge;

public record GetPreguntaGEDTO(
        String id,
        String enunciado,
        String evidenciaSugerida,
        String rolSugerido,
        String idPreguntaFurag) { }
