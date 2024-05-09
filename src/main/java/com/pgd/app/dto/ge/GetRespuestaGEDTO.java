package com.pgd.app.dto.ge;

import java.util.UUID;

public record GetRespuestaGEDTO(
        UUID id,
        boolean opcion,
        String evidencia,
        String preguntaGEID,
        Long formularioFuragId) {
}
