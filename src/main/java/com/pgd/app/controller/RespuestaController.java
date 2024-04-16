package com.pgd.app.controller;

import com.pgd.app.dto.RespuestasFormularioDTO;
import com.pgd.app.repository.RespuestaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;

    public RespuestaController(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
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

}
