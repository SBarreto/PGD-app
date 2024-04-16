package com.pgd.app.dto;

import java.util.UUID;

public record GetRespuestaGEDTO(
        UUID id,
        String texto,
        String preguntaGEID,
        Long formularioFuragId) {
}
