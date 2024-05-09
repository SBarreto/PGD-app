package com.pgd.app.service;

import com.pgd.app.dto.evidencia.EvidenciaDTO;
import com.pgd.app.model.Evidencia;
import com.pgd.app.repository.EvidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EvidenciaService {

    private final EvidenciaRepository evidenciaRepository;

    public EvidenciaService(EvidenciaRepository evidenciaRepository) {
        this.evidenciaRepository = evidenciaRepository;
    }

    public List<EvidenciaDTO> findAllFromFormulario(Long formularioFURAGId) {
        return evidenciaRepository.findAllByFormularioFURAG_Id(formularioFURAGId).stream().map(
                evidencia -> new EvidenciaDTO(
                        evidencia.getId(),
                        evidencia.getTexto(),
                        evidencia.getAlerta()
                )).toList();

    }
    public EvidenciaDTO getEvidenciaFromRespuestaGE(UUID respuestaGEId) {
        Evidencia evidencia = evidenciaRepository.findByRespuestaGE_Id(respuestaGEId);
        return new EvidenciaDTO(
                evidencia.getId(),
                evidencia.getTexto(),
                evidencia.getAlerta());
    }

    public List<EvidenciaDTO> getEvidenciasFromPreguntaFURAGandFormulario(Long formularioFURAGId, String preguntaId) {
        return evidenciaRepository.findAlByRespuestaGE_PreguntaGE_Pregunta_IdAndFormularioFURAG_Id(preguntaId, formularioFURAGId)
                .stream().map(
                        evidencia -> new EvidenciaDTO(
                                evidencia.getId(),
                                evidencia.getTexto(),
                                evidencia.getAlerta()
                        )
                ).toList();
    }

}
