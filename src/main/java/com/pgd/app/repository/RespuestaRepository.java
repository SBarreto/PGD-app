package com.pgd.app.repository;

import com.pgd.app.model.Respuesta;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RespuestaRepository extends CrudRepository<Respuesta, UUID> {

}
