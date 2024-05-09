package com.pgd.app.repository;

import com.pgd.app.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EvidenciaRepository extends JpaRepository<Evidencia, UUID> {
    List<Evidencia> findAllByFormularioFURAG_Id(Long formularioFURAGId);
    Evidencia findByRespuestaGE_Id(UUID respuestaGEId);
    List<Evidencia> findAlByRespuestaGE_PreguntaGE_Pregunta_IdAndFormularioFURAG_Id(String preguntaId, Long formularioFURAGId);
    boolean existsByRespuestaGE_Id(UUID respuestaGEId);
}
