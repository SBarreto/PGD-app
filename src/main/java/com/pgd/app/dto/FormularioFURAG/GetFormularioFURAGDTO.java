package com.pgd.app.dto.FormularioFURAG;

import com.pgd.app.dto.PreguntaDTO;

import java.util.Date;
import java.util.List;

public record GetFormularioFURAGDTO (
        Long id,
        Date vigencia,
        List<PreguntaDTO> preguntas
) {
}
