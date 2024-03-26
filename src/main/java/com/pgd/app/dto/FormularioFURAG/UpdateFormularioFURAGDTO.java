package com.pgd.app.dto.FormularioFURAG;

import com.pgd.app.dto.PreguntaDTO;

import java.util.Date;
import java.util.List;

public record UpdateFormularioFURAGDTO(

        Long id,
        Date vigencia,
        List<PreguntaDTO> preguntas) {
}
