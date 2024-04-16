package com.pgd.app.repository;

import com.pgd.app.model.PreguntaGE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaGERepository  extends JpaRepository<PreguntaGE, String> {

    List<PreguntaGE> findAllByPregunta_Id(String preguntaId);
}
