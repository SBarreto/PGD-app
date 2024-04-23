package com.pgd.app.controller;


import com.pgd.app.dto.puntaje.GetPuntajesEntidadDTO;
import com.pgd.app.dto.puntaje.PuntajeDTO;
import com.pgd.app.repository.PuntajeRepository;
import com.pgd.app.service.PuntajeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PuntajesController {

    private final PuntajeService puntajeService;
    private final PuntajeRepository puntajeRepository;

    public PuntajesController(PuntajeService puntajeService, PuntajeRepository puntajeRepository) {
        this.puntajeService = puntajeService;
        this.puntajeRepository = puntajeRepository;
    }

    @Operation(summary = "Tomar todos los puntajes de una entidad")
    @GetMapping("/api/puntajes/entidad/{codigosidep}")
    public ResponseEntity<GetPuntajesEntidadDTO> getPuntajesEntidad(@PathVariable int codigosidep) {
        return ResponseEntity.ok(puntajeService.getPuntajesEntidad(codigosidep));
    }

    @Operation(summary = "Tomar los puntajes de una entidad en una categoria (puede tener varias por diferentes vigencias o años)")
    @GetMapping("/api/puntajes/entidad/{codigosidep}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeEntidadCategoria(@PathVariable int codigosidep, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_CodigosigepAndAndCategoria(codigosidep, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de un municipio")
    @GetMapping("/api/puntajes/municipio/{codigomunicipio}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajesMunicipio(@PathVariable String codigomunicipio) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_Codigomunicipio(codigomunicipio)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de un municipio por categoria")
    @GetMapping("/api/puntajes/municipio/{codigomunicipio}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeMunicipioCategoria(@PathVariable String codigomunicipio, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_CodigomunicipioAndCategoria(codigomunicipio, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierta naturaleza juridica")
    @GetMapping("/api/puntajes/naturalezajuridica/{naturalezajuridica}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajesNaturalezaJuridica(@PathVariable String naturalezajuridica) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_NaturalezaJuridica(naturalezajuridica)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierta naturaleza juridica y categoria")
    @GetMapping("/api/puntajes/naturalezajuridica/{naturalezajuridica}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeNaturalezaJuridicaCategoria(@PathVariable String naturalezajuridica, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_NaturalezaJuridicaAndCategoria(naturalezajuridica, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierto orden")
    @GetMapping("/api/puntajes/orden/{orden}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajesOrden(@PathVariable String orden) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_Orden(orden)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierto orden y categoria")
    @GetMapping("/api/puntajes/orden/{orden}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeOrdenCategoria(@PathVariable String orden, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_OrdenAndCategoria(orden, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierto sector")
    @GetMapping("/api/puntajes/sector/{sector}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajesSector(@PathVariable String sector) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_Sector(sector)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de cierto sector y categoria")
    @GetMapping("/api/puntajes/sector/{sector}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeSectorCategoria(@PathVariable String sector, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_SectorAndCategoria(sector, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de un departamento")
    @GetMapping("/api/puntajes/departamento/{codigodepartamento}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajesDepartamento(@PathVariable int codigodepartamento) {
        return ResponseEntity.ok(
            puntajeRepository.findAllByEntidad_Codigodepartamento(codigodepartamento)
                    .stream().map(
                            puntaje -> new PuntajeDTO(
                                    puntaje.getEntidad().getNombre(),
                                    puntaje.getValor(),
                                    puntaje.getCategoria(),
                                    puntaje.getVigencia())).toList()
        );
    }

    @Operation(summary = "Tomar todos los puntajes de entidades de un departamento y categoria")
    @GetMapping("/api/puntajes/departamento/{codigodepartamento}/{categoria}")
    public ResponseEntity<List<PuntajeDTO>> getPuntajeDepartamentoCategoria(@PathVariable int codigodepartamento, @PathVariable String categoria) {
        return ResponseEntity.ok(
                puntajeRepository.findAllByEntidad_CodigodepartamentoAndCategoria(codigodepartamento, categoria)
                        .stream().map(
                                puntaje -> new PuntajeDTO(
                                        puntaje.getEntidad().getNombre(),
                                        puntaje.getValor(),
                                        puntaje.getCategoria(),
                                        puntaje.getVigencia())).toList()
        );
    }
}
