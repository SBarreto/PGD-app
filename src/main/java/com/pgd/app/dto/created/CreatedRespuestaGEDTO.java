package com.pgd.app.dto.created;

import java.util.UUID;

public record CreatedRespuestaGEDTO (
        UUID id,
        boolean opcion,
        String preguntaGEId,
        String evidencia,
        long formularioId
) {

}
