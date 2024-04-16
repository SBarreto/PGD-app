package com.pgd.app.repository;

import com.pgd.app.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, String> {
}
