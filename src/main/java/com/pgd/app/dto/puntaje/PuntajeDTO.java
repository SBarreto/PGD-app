package com.pgd.app.dto.puntaje;

import java.util.Date;

public record PuntajeDTO(
        String nombreEntidad,
        double valor,
        String categoria,
        Date vigencia) {}
