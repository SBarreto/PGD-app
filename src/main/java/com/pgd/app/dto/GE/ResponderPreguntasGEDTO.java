package com.pgd.app.dto.GE;

import java.util.List;

public record ResponderPreguntasGEDTO(
        String preguntaId,
        String evidencia,
        Long formularioFURAGID,
        List<CrearRespuestaGEDTO> respuestasGEDTO
) { }
