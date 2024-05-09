package com.pgd.app.service;

import com.pgd.app.exception.PreguntaFURAGNotFoundException;
import com.pgd.app.dto.ge.CrearPreguntaGEDTO;
import com.pgd.app.model.Pregunta;
import com.pgd.app.model.PreguntaGE;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntasGEService {

    private final PreguntaGERepository preguntaGERepository;
    private final PreguntaRepository preguntaRepository;

    public PreguntasGEService(PreguntaGERepository preguntaGERepository, PreguntaRepository preguntaRepository) {
        this.preguntaGERepository = preguntaGERepository;
        this.preguntaRepository = preguntaRepository;
    }

    public void crearPreguntaGE(CrearPreguntaGEDTO crearPreguntaGEDTO, String preguntaFuragId) {
        Pregunta pregunta = preguntaRepository.findById(preguntaFuragId).orElseThrow(
                () -> new PreguntaFURAGNotFoundException("Id de pregunta FURAG no encontrado"));
        PreguntaGE preguntaGE = new PreguntaGE(
                preguntaFuragId+"GE"+(Math.round(Math.random() * 100)),
                crearPreguntaGEDTO.enunciado(),
                crearPreguntaGEDTO.evidenciaSugerida(),
                crearPreguntaGEDTO.rolSugerido(),
                pregunta);
        preguntaGERepository.save(preguntaGE);
    }

    public void crearPreguntasGE(List<CrearPreguntaGEDTO> crearPreguntasGEDTO, String preguntaFuragId) {
        Pregunta pregunta = preguntaRepository.findById(preguntaFuragId).orElseThrow(
                () -> new PreguntaFURAGNotFoundException("Id de pregunta FURAG no encontrado"));
        List<PreguntaGE> preguntasGEToSave = new ArrayList<>();
        crearPreguntasGEDTO.forEach(
                preguntaGEDTO -> {
                    PreguntaGE preguntaGE = new PreguntaGE(
                            preguntaFuragId+"GE"+(Math.round(Math.random() * 100)),
                            preguntaGEDTO.enunciado(),
                            preguntaGEDTO.evidenciaSugerida(),
                            preguntaGEDTO.rolSugerido(),
                            pregunta
                    );
                    preguntasGEToSave.add(preguntaGE);
                }
        );
        preguntaGERepository.saveAll(preguntasGEToSave);
    }

}
