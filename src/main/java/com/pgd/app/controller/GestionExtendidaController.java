package com.pgd.app.controller;

import com.pgd.app.dto.ge.CrearPreguntaGEDTO;
import com.pgd.app.dto.ge.CrearRespuestaGEDTO;
import com.pgd.app.dto.ge.GetPreguntaGEDTO;
import com.pgd.app.dto.ge.GetRespuestaGEDTO;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.RespuestaGERepository;
import com.pgd.app.service.PreguntasGEService;
import com.pgd.app.service.RespuestaGEService;
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

    @PostMapping("/api/gestionextendida/preguntasge")
    public void createPreguntaGE(@RequestBody CrearPreguntaGEDTO crearPreguntaGEDTO) {
        preguntasGEService.crearPreguntaGE(crearPreguntaGEDTO);
    }

    @DeleteMapping("/api/gestionextendida/preguntasge/{preguntageid}")
    public void deletePreguntaGE(@PathVariable String preguntageid) {
        preguntaGERepository.deleteById(preguntageid);
    }

    public void updatePreguntaGE() {}

    @GetMapping("/api/gestionextendida/respuestasge/{preguntageid}/{formulariofuragid}")
    public List<GetRespuestaGEDTO> getRespuestasGE(@PathVariable String preguntageid, @PathVariable Long formulariofuragid) {
        return respuestaGERepository.findAllByFormularioFURAG_IdAndAndPreguntaGE_Id(formulariofuragid, preguntageid)
                .stream().map(respuestaGE -> new GetRespuestaGEDTO(
                        respuestaGE.getId(),
                        respuestaGE.getTexto(),
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

    public void updateRespuestaGE() {}
}
