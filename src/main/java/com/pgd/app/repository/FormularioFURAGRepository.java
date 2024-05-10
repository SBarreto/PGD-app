package com.pgd.app.repository;

import com.pgd.app.model.FormularioFURAG;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormularioFURAGRepository extends JpaRepository<FormularioFURAG, Long> {

    List<FormularioFURAG> findAll();
    Optional<FormularioFURAG> findById(Long id);
    List<FormularioFURAG> findAllByEntidad_Codigosigep(Long codigosigep);
}
