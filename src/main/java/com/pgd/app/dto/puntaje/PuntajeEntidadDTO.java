package com.pgd.app.dto.puntaje;

import java.util.Date;

public record PuntajeEntidadDTO(
            double valor,
            String categoria,
            Date vigencia
    ) {}
