package com.pgd.app.controller;

import com.pgd.app.dto.created.CreatedRespuestaGEDTO;
import com.pgd.app.dto.ge.*;
import com.pgd.app.model.RespuestaGE;
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
    public GetPreguntaGEDTO createSinglePreguntaGE(@RequestBody CrearPreguntaGEDTO crearPreguntaGEDTO, @PathVariable String preguntafuragid) {
        return preguntasGEService.crearPreguntaGE(crearPreguntaGEDTO, preguntafuragid);
    }

    @Operation(summary = "Crear varias preguntas de Gestion Extendida para una pregunta FURAG")
    @PostMapping("/api/gestionextendida/preguntasge/{preguntafuragid}")
    public List<GetPreguntaGEDTO> createManyPreguntasGE(@RequestBody List<CrearPreguntaGEDTO> crearPreguntasGEDTO, @PathVariable String preguntafuragid) {
        return preguntasGEService.crearPreguntasGE(crearPreguntasGEDTO, preguntafuragid);
    }

    @Operation(summary = "Eliminar pregunta de gestion extendida por ID")
    @DeleteMapping("/api/gestionextendida/preguntasge/{preguntageid}")
    public void deletePreguntaGE(@PathVariable String preguntageid) {
        preguntaGERepository.deleteById(preguntageid);
    }

    public void updatePreguntaGE() {
        //por implementar
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Operation(summary = "Obtener todas las respuestas de gestion extendida para una pregunta de Gestion Extendida de un Formulario FURAG")
    @GetMapping("/api/gestionextendida/respuestasge/{preguntageid}/{formulariofuragid}")
    public List<GetRespuestaGEDTO> getRespuestasGE(@PathVariable String preguntageid, @PathVariable Long formulariofuragid) {
        return respuestaGEService.getRespuestasGEFromPreguntaGEAndFormulario(preguntageid, formulariofuragid);
    }

    @Operation(summary = "Crear o actualizar varias Respuestas y evidencias de Gestion Extendida para preguntas de un formulario FURAG",
    description = "Este endpoint se puede usar para crear y actualizar respuestas de gestion extendida junto con sus evidencias en un solo request," +
            " entonces se puede usar el boton de submit de un formulario web para guardar todo sin tener que crear request individuales para cada cosa")
    @PostMapping("/api/gestionextendida/respuestasge/responderpreguntasge")
    public List<CreatedRespuestaGEDTO> crearRespuestasGE(@RequestBody ResponderPreguntasGEDTO responderPreguntasGEDTO) {
        return respuestaGEService.crearRespuestasGEPreguntaGE(responderPreguntasGEDTO);
    }

    @Operation(summary = "Crear respuesta de Gestion Extendida para una pregunta de gestion extendida de un formulario FURAG")
    @PostMapping("/api/gestionextendida/respuestasge/{formulariofuragid}/{preguntageid}")
    public CreatedRespuestaGEDTO createRespuestaGE(@RequestBody CrearRespuestaGEDTO crearRespuestaGEDTO, @PathVariable Long formulariofuragid, @PathVariable String preguntageid) {
        return respuestaGEService.crearRespuestaGE(crearRespuestaGEDTO, formulariofuragid, preguntageid);
    }

    @Operation(summary = "Eliminar respuestaGE de Gestion Extendida por ID")
    @DeleteMapping("/api/gestionextendida/respuestasge/{id}")
    public void deleteRespuestaGE(@PathVariable UUID id) {
        respuestaGERepository.deleteById(id);
    }

    @Operation(summary = "Actualizar una respuestaGE de Gestion Extendida")
    @PutMapping("/api/gestionextendida/respuestage/{respuestageid}")
    public CreatedRespuestaGEDTO updateRespuestaGE(@RequestBody UpdateRespuestaGEDTO updateRespuestaGEDTO, @PathVariable UUID respuestageid) {

        RespuestaGE respuestaGE = respuestaGEService.updateRespuestaGE(updateRespuestaGEDTO, respuestageid);
        return new CreatedRespuestaGEDTO(
                respuestaGE.getId(),
                respuestaGE.isOpcion(),
                respuestaGE.getPreguntaGE().getId(),
                respuestaGE.getEvidencia().getTexto(),
                respuestaGE.getFormularioFURAG().getId()
        );
    }
}
