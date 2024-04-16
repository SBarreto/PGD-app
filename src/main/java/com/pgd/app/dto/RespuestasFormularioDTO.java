package com.pgd.app.dto;

import java.util.UUID;

public record RespuestasFormularioDTO(
        UUID id,
        String texto,
        String preguntaId,
        int version) { }
