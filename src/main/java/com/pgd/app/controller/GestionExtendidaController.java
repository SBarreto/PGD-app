package com.pgd.app.controller;

import com.pgd.app.dto.ge.*;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.RespuestaGERepository;
import com.pgd.app.service.PreguntasGEService;
import com.pgd.app.service.RespuestaGEService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GestionExtendidaController {

    private final PreguntaGERepository preguntaGERepository;
    private final PreguntasGEService preguntasGEService;
    private final RespuestaGERepository respuestaGERepository;
    private final RespuestaGEService respuestaGEService;

    public GestionExtendidaController(PreguntaGERepository preguntaGERepository, PreguntasGEService preguntasGEService, RespuestaGERepository respuestaGERepository, RespuestaGEService respuestaGEService) {
        this.preguntaGERepository = preguntaGERepository;
        this.preguntasGEService = preguntasGEService;
        this.respuestaGERepository = respuestaGERepository;
        this.respuestaGEService = respuestaGEService;
    }


    @Operation(summary = "Obtener todas las preguntas de gestion extendida de una pregunta FURAG")
    @GetMapping("/api/gestionextendida/preguntasge/{preguntaid}")
    public List<GetPreguntaGEDTO> getPreguntasGEfromPreguntaFurag(@PathVariable String preguntaid) {
       return  preguntaGERepository.findAllByPregunta_Id(preguntaid).stream().map(
               preguntaGE -> new GetPreguntaGEDTO(
                       preguntaGE.getId(),
                       preguntaGE.getEnunciado(),
                       preguntaGE.getEvidenciaSugerida(),
                       preguntaGE.getRolSugerido(),
                       preguntaGE.getPregunta().getId()
               )
       ).toList();
    }

    @Operation(summary = "Crear una pregunta de Gestion Extendida para una pregunta FURAG")
    @PostMapping("/api/gestionextendida/preguntage/{preguntafuragid}")
    public void createSinglePreguntaGE(@RequestBody CrearPreguntaGEDTO crearPreguntaGEDTO, @PathVariable String preguntafuragid) {
        preguntasGEService.crearPreguntaGE(crearPreguntaGEDTO, preguntafuragid);
    }

    @Operation(summary = "Crear varias preguntas de Gestion Extendida para una pregunta FURAG")
    @PostMapping("/api/gestionextendida/preguntasge/{preguntafuragid}")
    public void createManyPreguntasGE(@RequestBody List<CrearPreguntaGEDTO> crearPreguntasGEDTO, @PathVariable String preguntafuragid) {
        preguntasGEService.crearPreguntasGE(crearPreguntasGEDTO, preguntafuragid);
    }

    @DeleteMapping("/api/gestionextendida/preguntasge/{preguntageid}")
    public void deletePreguntaGE(@PathVariable String preguntageid) {
        preguntaGERepository.deleteById(preguntageid);
    }

    public void updatePreguntaGE() {
        //por implementar

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/api/gestionextendida/respuestasge/{preguntageid}/{formulariofuragid}")
    public List<GetRespuestaGEDTO> getRespuestasGE(@PathVariable String preguntageid, @PathVariable Long formulariofuragid) {
        return respuestaGERepository.findAllByFormularioFURAG_IdAndAndPreguntaGE_Id(formulariofuragid, preguntageid)
                .stream().map(respuestaGE -> new GetRespuestaGEDTO(
                        respuestaGE.getId(),
                        respuestaGE.getEvidencia(),
                        respuestaGE.getPreguntaGE().getId(),
                        respuestaGE.getFormularioFURAG().getId())).toList();
    }

    @PostMapping("/api/gestionextendida/respuestasge/{formulariofuragid}/{preguntageid}")
    public void createRespuestaGE(@RequestBody CrearRespuestaGEDTO crearRespuestaGEDTO, @PathVariable Long formulariofuragid, @PathVariable String preguntageid) {
        respuestaGEService.crearRespuestaGE(crearRespuestaGEDTO, formulariofuragid, preguntageid);
    }

    @DeleteMapping("/api/gestionextendida/respuestasge/{id}")
    public void deleteRespuestaGE(@PathVariable UUID id) {
        respuestaGERepository.deleteById(id);
    }

    @Operation(summary = "Actualizar una respuesta de Gestion Extendida")
    @PutMapping("/api/gestionextendida/respuestage/{respuestageid}")
    public void updateRespuestaGE(@RequestBody UpdateRespuestaGEDTO updateRespuestaGEDTO, @PathVariable UUID respuestageid) {
        respuestaGEService.updateRespuestaGE(updateRespuestaGEDTO, respuestageid);
    }
}
