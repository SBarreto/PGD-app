package com.pgd.app.controller;

import com.pgd.app.dto.evidencia.EvidenciaDTO;
import com.pgd.app.service.EvidenciaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class EvidenciaController {

    private final EvidenciaService evidenciaService;

    public EvidenciaController(EvidenciaService evidenciaService) {
        this.evidenciaService = evidenciaService;
    }

    @GetMapping("/api/evidencias/formulario/{idformulario}")
    public ResponseEntity<List<EvidenciaDTO>> getAllEvidenciasFromFormulario(@PathVariable long idformulario) {
        return ResponseEntity.ok(evidenciaService.findAllFromFormulario(idformulario));
    }

    @GetMapping("/api/evidencias/respuestage/{idrespuestage}")
    public ResponseEntity<EvidenciaDTO> getEvidenciaFromRespuestaGE(@PathVariable UUID idrespuestage) {
        return ResponseEntity.ok(evidenciaService.getEvidenciaFromRespuestaGE(idrespuestage));
    }

    @Operation(summary = "Trae todas las evidencias de una pregunta FURAG de un formulario FURAG",
    description = "Basicamente, sirve para traer todas las evidencias de una pregunta FURAG respondida")
    @GetMapping("/api/evidencias/preguntageformulario/{idformulario}/{idpregunta}")
    public ResponseEntity<List<EvidenciaDTO>> getEvidenciaFrom(@PathVariable Long idformulario, @PathVariable String idpregunta) {
        return ResponseEntity.ok(evidenciaService.getEvidenciasFromPreguntaFURAGandFormulario(idformulario, idpregunta));
    }

}
