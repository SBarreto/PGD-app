package com.pgd.app.dto.ge;

public record CrearPreguntaGEDTO (
        String enunciado,
        String evidenciaSugerida,
        String rolSugerido,
        String preguntaFuragId
) {
}
