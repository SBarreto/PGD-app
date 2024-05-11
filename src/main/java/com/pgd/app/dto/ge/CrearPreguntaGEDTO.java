package com.pgd.app.dto.ge;

import jakarta.validation.constraints.NotNull;

public record CrearPreguntaGEDTO (
        @NotNull
        String enunciado,
        @NotNull
        String evidenciaSugerida,
        @NotNull
        String rolSugerido) {
}
