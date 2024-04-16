package com.pgd.app.service;

import com.pgd.app.dto.CrearRespuestaGEDTO;
import com.pgd.app.model.RespuestaGE;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.RespuestaGERepository;
import org.springframework.stereotype.Service;

@Service
public class RespuestaGEService {

    private final RespuestaGERepository respuestaGERepository;
    private final FormularioFURAGRepository formularioFURAGRepository;
    private final PreguntaGERepository preguntaGERepository;


    public RespuestaGEService(RespuestaGERepository respuestaGERepository, FormularioFURAGRepository formularioFURAGRepository, PreguntaGERepository preguntaGERepository) {
        this.respuestaGERepository = respuestaGERepository;
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaGERepository = preguntaGERepository;
    }

    public void crearRespuestaGE(CrearRespuestaGEDTO crearRespuestaGEDTO) {

        RespuestaGE respuestaGE = new RespuestaGE(
                crearRespuestaGEDTO.texto(),
                preguntaGERepository.getReferenceById(crearRespuestaGEDTO.preguntaGEID()),
                formularioFURAGRepository.getReferenceById(crearRespuestaGEDTO.formularioFURAGID())
        );

        respuestaGERepository.save(respuestaGE);
    }
}
