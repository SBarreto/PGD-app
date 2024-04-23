package com.pgd.app.controller;

import com.pgd.app.service.CargueArchivosService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class CargueArchivosController {

    private final CargueArchivosService cargueArchivosService;

    @Value("${ruta.archivo.carguepreguntas}")
    private String rutaArchivo;

    public CargueArchivosController(CargueArchivosService cargueArchivosService) {
        this.cargueArchivosService = cargueArchivosService;
    }


    @PostMapping("/api/carguearchivos/preguntas/{formulariofuragid}")
    public ResponseEntity<String> cargueArchivosPreguntas(@RequestParam("file")MultipartFile file, @PathVariable Long formulariofuragid) {

        try {
            File filePreguntas = new File(rutaArchivo);
            file.transferTo(filePreguntas);
            cargueArchivosService.cargarArchivoPreguntaFormularioFURAG(formulariofuragid, filePreguntas);
            return ResponseEntity.ok("Archivo cargado exitosamente: " + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
