package com.pgd.app.service;

import com.pgd.app.dto.GE.CrearRespuestaGEDTO;
import com.pgd.app.dto.GE.ResponderPreguntasGEDTO;
import com.pgd.app.model.RespuestaGE;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.RespuestaGERepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void crearRespuestaGE(CrearRespuestaGEDTO crearRespuestaGEDTO, Long formularioFURAGId, String preguntaGEId) {

        RespuestaGE respuestaGE = new RespuestaGE(
                crearRespuestaGEDTO.texto(),
                crearRespuestaGEDTO.opcion(),
                preguntaGERepository.getReferenceById(preguntaGEId),
                formularioFURAGRepository.getReferenceById(formularioFURAGId)
        );

        respuestaGERepository.save(respuestaGE);
    }

    public void crearRespuestasPreguntaGE(ResponderPreguntasGEDTO responderPreguntasGEDTO) {
        List<RespuestaGE> respuestasGEToSave = new ArrayList<>();
        responderPreguntasGEDTO.respuestasGEDTO().forEach(
                crearRespuestaGEDTO -> {
                    RespuestaGE respuestaGE = new RespuestaGE(
                            crearRespuestaGEDTO.texto(),
                            crearRespuestaGEDTO.opcion(),
                            preguntaGERepository.getReferenceById(crearRespuestaGEDTO.preguntaGEID()),
                            formularioFURAGRepository.getReferenceById(responderPreguntasGEDTO.formularioFURAGID())
                    );
                    if (respuestaGERepository.existsByFormularioFURAG_IdAndAndPreguntaGE_Id(responderPreguntasGEDTO.formularioFURAGID(), crearRespuestaGEDTO.preguntaGEID())) {
                        respuestaGE.setId(respuestaGERepository.findByFormularioFURAG_IdAndAndPreguntaGE_Id(responderPreguntasGEDTO.formularioFURAGID(), crearRespuestaGEDTO.preguntaGEID()).getId());
                    }
                    respuestasGEToSave.add(respuestaGE);
                }
        );
        respuestaGERepository.saveAll(respuestasGEToSave);
    }
}
