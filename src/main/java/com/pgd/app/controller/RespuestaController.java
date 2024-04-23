package com.pgd.app.controller;

import com.pgd.app.dto.GE.ResponderPreguntasGEDTO;
import com.pgd.app.dto.RespuestasFormularioDTO;
import com.pgd.app.repository.RespuestaRepository;
import com.pgd.app.service.RespuestaGEService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;
    private final RespuestaGEService respuestaGEService;

    public RespuestaController(RespuestaRepository respuestaRepository, RespuestaGEService respuestaGEService) {
        this.respuestaRepository = respuestaRepository;
        this.respuestaGEService = respuestaGEService;
    }

    @GetMapping("/api/respuestas/{idformulario}")
    public List<RespuestasFormularioDTO> getRespuestasFromFormulario(@PathVariable long idformulario) {
        return respuestaRepository.findAllByFormularioFURAG_Id(idformulario)
                .stream().map(
                        respuesta -> new RespuestasFormularioDTO(
                               respuesta.getId(),
                               respuesta.getTexto(),
                               respuesta.getPregunta().getId(),
                                respuesta.getVersion()
                        )).toList();
    }

    @Operation(summary = "Crear Respuestas de Gestion Extendida para preguntas de un formulario")
    @PostMapping("/api/respuestas/responderpreguntasge")
    public void crearRespuesta(@RequestBody ResponderPreguntasGEDTO responderPreguntasGEDTO) {
        respuestaGEService.crearRespuestasPreguntaGE(responderPreguntasGEDTO);
    }

}
