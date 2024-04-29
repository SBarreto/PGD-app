package com.pgd.app.service;

import com.pgd.app.exception.RespuestaGENotFoundException;
import com.pgd.app.dto.ge.CrearRespuestaGEDTO;
import com.pgd.app.dto.ge.ResponderPreguntasGEDTO;
import com.pgd.app.dto.ge.UpdateRespuestaGEDTO;
import com.pgd.app.model.RespuestaGE;
import com.pgd.app.repository.FormularioFURAGRepository;
import com.pgd.app.repository.PreguntaGERepository;
import com.pgd.app.repository.RespuestaGERepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                crearRespuestaGEDTO.evidencia(),
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
                            crearRespuestaGEDTO.evidencia(),
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

    public void updateRespuestaGE(UpdateRespuestaGEDTO updateRespuestaGEDTO, UUID respuestageid) {
        if (!respuestaGERepository.existsById(respuestageid))
            throw new RespuestaGENotFoundException("ID de respuesta de gestion extendida no encontrado");
        RespuestaGE respuestaGE = new RespuestaGE();
        respuestaGE.setId(respuestageid);
        respuestaGE.setOpcion(updateRespuestaGEDTO.opcion());
        respuestaGE.setEvidencia(updateRespuestaGEDTO.evidencia());
        respuestaGERepository.save(respuestaGE);
    }
}
