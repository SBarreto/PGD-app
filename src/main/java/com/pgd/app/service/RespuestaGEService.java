package com.pgd.app.service;

import com.pgd.app.dto.created.CreatedRespuestaGEDTO;
import com.pgd.app.dto.ge.GetRespuestaGEDTO;
import com.pgd.app.exception.EvidenciaNotFoundException;
import com.pgd.app.exception.FormularioNotFoundException;
import com.pgd.app.exception.PreguntaGENotFoundException;
import com.pgd.app.exception.RespuestaGENotFoundException;
import com.pgd.app.dto.ge.CrearRespuestaGEDTO;
import com.pgd.app.dto.ge.ResponderPreguntasGEDTO;
import com.pgd.app.dto.ge.UpdateRespuestaGEDTO;
import com.pgd.app.model.Evidencia;
import com.pgd.app.model.RespuestaGE;
import com.pgd.app.repository.EvidenciaRepository;
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
    private final EvidenciaRepository evidenciaRepository;


    public RespuestaGEService(RespuestaGERepository respuestaGERepository, FormularioFURAGRepository formularioFURAGRepository, PreguntaGERepository preguntaGERepository, EvidenciaRepository evidenciaRepository) {
        this.respuestaGERepository = respuestaGERepository;
        this.formularioFURAGRepository = formularioFURAGRepository;
        this.preguntaGERepository = preguntaGERepository;
        this.evidenciaRepository = evidenciaRepository;
    }

    public CreatedRespuestaGEDTO crearRespuestaGE(CrearRespuestaGEDTO crearRespuestaGEDTO, Long formularioFURAGId, String preguntaGEId) {

        Evidencia evidencia = new Evidencia(
                crearRespuestaGEDTO.evidencia(),
                formularioFURAGRepository.getReferenceById(formularioFURAGId)
        );
        RespuestaGE respuestaGE = new RespuestaGE(
                crearRespuestaGEDTO.opcion(),
                preguntaGERepository.getReferenceById(preguntaGEId),
                formularioFURAGRepository.getReferenceById(formularioFURAGId)
        );
        evidencia.setRespuestaGE(respuestaGE);
        respuestaGE.setEvidencia(evidencia);
        RespuestaGE respuestaGEToReturn = respuestaGERepository.save(respuestaGE);
        return new CreatedRespuestaGEDTO(
                respuestaGEToReturn.getId(),
                respuestaGEToReturn.isOpcion(),
                respuestaGEToReturn.getPreguntaGE().getId(),
                respuestaGEToReturn.getEvidencia().getTexto(),
                respuestaGEToReturn.getFormularioFURAG().getId()
        );
    }

    public List<CreatedRespuestaGEDTO> crearRespuestasGEPreguntaGE(ResponderPreguntasGEDTO responderPreguntasGEDTO) {
        if (!formularioFURAGRepository.existsById(responderPreguntasGEDTO.formularioFURAGID()))
            throw new FormularioNotFoundException("Formulario FURAG con ID " + responderPreguntasGEDTO.formularioFURAGID() + " no fue encontrado");
        List<RespuestaGE> respuestasGEToSave = new ArrayList<>();
        responderPreguntasGEDTO.respuestasGEDTO().forEach(
                crearRespuestaGEDTO -> {
                    if (!preguntaGERepository.existsById(crearRespuestaGEDTO.preguntaGEID())) {
                        throw new PreguntaGENotFoundException("El id de pregunta de gestion extendida " + crearRespuestaGEDTO.preguntaGEID() + " no fue encontrado");
                    }
                    Evidencia evidencia;
                    RespuestaGE respuestaGE;

                    if (respuestaGERepository.existsByFormularioFURAG_IdAndAndPreguntaGE_Id(responderPreguntasGEDTO.formularioFURAGID(), crearRespuestaGEDTO.preguntaGEID())) {
                        respuestaGE = respuestaGERepository.findByFormularioFURAG_IdAndAndPreguntaGE_Id(responderPreguntasGEDTO.formularioFURAGID(), crearRespuestaGEDTO.preguntaGEID());
                        respuestaGE.setOpcion(crearRespuestaGEDTO.opcion());
                    } else {
                        respuestaGE = new RespuestaGE(
                                crearRespuestaGEDTO.opcion(),
                                preguntaGERepository.getReferenceById(crearRespuestaGEDTO.preguntaGEID()),
                                formularioFURAGRepository.getReferenceById(responderPreguntasGEDTO.formularioFURAGID()));

                    }

                    if (evidenciaRepository.existsByRespuestaGE_Id(respuestaGE.getId())) {
                        evidencia = evidenciaRepository.findByRespuestaGE_Id(respuestaGE.getId());
                        evidencia.setTexto(crearRespuestaGEDTO.evidencia());
                    } else {
                        evidencia = new Evidencia(
                                crearRespuestaGEDTO.evidencia(),
                                formularioFURAGRepository.getReferenceById(responderPreguntasGEDTO.formularioFURAGID()));
                    }
                    evidencia.setRespuestaGE(respuestaGE);
                    respuestaGE.setEvidencia(evidencia);
                    respuestasGEToSave.add(respuestaGE);
                }
        );
        return respuestaGERepository.saveAll(respuestasGEToSave).stream().map(
                respuestaGE -> new CreatedRespuestaGEDTO(
                        respuestaGE.getId(),
                        respuestaGE.isOpcion(),
                        respuestaGE.getPreguntaGE().getId(),
                        respuestaGE.getEvidencia().getTexto(),
                        respuestaGE.getFormularioFURAG().getId()
                )
        ).toList();
    }

    public RespuestaGE updateRespuestaGE(UpdateRespuestaGEDTO updateRespuestaGEDTO, UUID respuestageid) {
        RespuestaGE respuestaGEToUpdate = respuestaGERepository.findById(respuestageid).orElseThrow(
                () -> new RespuestaGENotFoundException("ID de respuestaGE no encontrado")
        );
        Evidencia evidenciaToUpdate = evidenciaRepository.findById(respuestaGEToUpdate.getEvidencia().getId()).orElseThrow(
                () -> new EvidenciaNotFoundException("Evidencia " + "\"" + updateRespuestaGEDTO + "\"" + " no encontrada")
        );
        evidenciaToUpdate.setTexto(updateRespuestaGEDTO.evidencia());
        respuestaGEToUpdate.setOpcion(updateRespuestaGEDTO.opcion());
        evidenciaToUpdate.setRespuestaGE(respuestaGEToUpdate);
        respuestaGEToUpdate.setEvidencia(evidenciaToUpdate);
        return respuestaGERepository.save(respuestaGEToUpdate);
    }

    public List<GetRespuestaGEDTO> getRespuestasGEFromPreguntaGEAndFormulario(String respuestaGEId, Long formularioFURAGId) {
        return respuestaGERepository.findAllByFormularioFURAG_IdAndAndPreguntaGE_Id(formularioFURAGId, respuestaGEId)
                .stream().map(respuestaGE -> new GetRespuestaGEDTO(
                        respuestaGE.getId(),
                        respuestaGE.isOpcion(),
                        respuestaGE.getEvidencia().getTexto(),
                        respuestaGE.getPreguntaGE().getId(),
                        respuestaGE.getFormularioFURAG().getId())).toList();
    }
}
