package com.pgd.app.dto;

import java.util.UUID;

public record CrearRespuestaDTO(
        String texto,
        String preguntaId,
        UUID formularioID
) {
}
