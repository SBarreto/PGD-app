package com.pgd.app.repository;

import com.pgd.app.model.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface PreguntaRepository extends CrudRepository<Pregunta, String> {
}
