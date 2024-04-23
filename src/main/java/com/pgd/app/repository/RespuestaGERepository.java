package com.pgd.app.repository;

import com.pgd.app.model.RespuestaGE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RespuestaGERepository  extends JpaRepository<RespuestaGE, UUID> {

    List<RespuestaGE> findAllByFormularioFURAG_IdAndAndPreguntaGE_Id(Long formularioFURAG_Id, String preguntaGEId);

    boolean existsByFormularioFURAG_IdAndAndPreguntaGE_Id(Long formularioFURAG_Id, String preguntaGEId);

    RespuestaGE findByFormularioFURAG_IdAndAndPreguntaGE_Id(Long formularioFURAG_Id, String preguntaGEId);


}
