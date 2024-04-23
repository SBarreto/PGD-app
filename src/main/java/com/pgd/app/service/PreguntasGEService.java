package com.pgd.app.service;

import com.pgd.app.dto.GE.CrearPreguntaGEDTO;
import com.pgd.app.model.Pregunta;
import com.pgd.app.model.PreguntaGE;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

@Service
public class PreguntasGEService {

    private final PreguntaGERepository preguntaGERepository;
    private final PreguntaRepository preguntaRepository;

    public PreguntasGEService(PreguntaGERepository preguntaGERepository, PreguntaRepository preguntaRepository) {
        this.preguntaGERepository = preguntaGERepository;
        this.preguntaRepository = preguntaRepository;
    }

    public void crearPreguntaGE(CrearPreguntaGEDTO crearPreguntaGEDTO) {
        Pregunta pregunta = preguntaRepository.findById(crearPreguntaGEDTO.preguntaFuragId()).orElse(null);
        PreguntaGE preguntaGE = new PreguntaGE(
                crearPreguntaGEDTO.preguntaFuragId()+"GE"+(String.valueOf(Math.round(Math.random()*100))),
                crearPreguntaGEDTO.enunciado(),
                crearPreguntaGEDTO.evidenciaSugerida(),
                crearPreguntaGEDTO.rolSugerido(),
                pregunta);
        preguntaGERepository.save(preguntaGE);
    }

}
