package com.pgd.app.dto.evidencia;

import com.pgd.app.enums.Alerta;

import java.util.UUID;

public record EvidenciaDTO (
        UUID id,
        String texto,
        Alerta alerta
) { }
