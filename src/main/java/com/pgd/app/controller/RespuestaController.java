package com.pgd.app.controller;

import com.pgd.app.dto.RespuestaDTO;
import com.pgd.app.repository.RespuestaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;

    public RespuestaController(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @GetMapping("/api/respuestas")
    public List<RespuestaDTO> getAllRespuestas() {
        //return respuestaRepository.findAll();
        return null;
    }
}
