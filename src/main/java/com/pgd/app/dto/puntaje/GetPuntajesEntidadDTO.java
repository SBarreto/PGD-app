package com.pgd.app.dto.puntaje;

import java.util.List;

public record GetPuntajesEntidadDTO(
        String nombreEntidad,
        int codigosigep,
        List<PuntajeEntidadDTO> puntajes) {

}


