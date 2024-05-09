package com.pgd.app.dto.Formulariofurag;


import com.pgd.app.dto.PreguntaDTO;

import java.util.Date;
import java.util.List;

public record CreateFormularioFURAGDTO(
        int codigoEntidad,
        Date vigencia,
        List<PreguntaDTO> preguntas) {
}

