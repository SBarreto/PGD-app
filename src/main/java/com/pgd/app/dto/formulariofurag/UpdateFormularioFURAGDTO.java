package com.pgd.app.dto.formulariofurag;

import com.pgd.app.dto.PreguntaDTO;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record UpdateFormularioFURAGDTO(

        @NotNull
        Long id,
        @NotNull
        Date vigencia,
        @NotNull
        List<PreguntaDTO> preguntas) {
}
