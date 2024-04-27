package com.pgd.app.dto.ge;

public record CrearRespuestaGEDTO(
        String preguntaGEID,
        String texto,
        boolean opcion) { }
