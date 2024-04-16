package com.pgd.app.repository;

import com.pgd.app.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface RespuestaRepository extends JpaRepository<Respuesta, UUID> {

    Set<Respuesta> findAllByFormularioFURAG_Id(Long id);
}
