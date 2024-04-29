package com.pgd.app.controller;

import com.pgd.app.dto.entidad.EntidadDTO;
import com.pgd.app.repository.EntidadRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoEntidadesController {

    private final EntidadRepository entidadRepository;

    public InfoEntidadesController(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
    }

    @Operation(summary = "Retornar listado de todas las entidades publicas asociadas a mediciones de desempeño y/o con formularios FURAG")
    @GetMapping("/api/entidades")
    public ResponseEntity<List<EntidadDTO>> getAllEntidades() {

        return ResponseEntity.ok(entidadRepository.findAll().stream().map(
                        entidad -> new EntidadDTO(
                                entidad.getCodigosigep(),
                                entidad.getNombre(),
                                entidad.getNaturalezaJuridica(),
                                entidad.getOrden(),
                                entidad.getSector(),
                                entidad.getCodigomunicipio(),
                                entidad.getCodigodepartamento()
                        )
                ).toList()
        );
    }

}
