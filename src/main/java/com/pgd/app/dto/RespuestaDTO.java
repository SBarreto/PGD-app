package com.pgd.app.dto;

import java.util.UUID;

public record RespuestaDTO(
        UUID id,
        String texto,
        int version) { }
