package com.pgd.app.repository;

import com.pgd.app.model.FormularioFURAG;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FormularioFURAGRepository extends CrudRepository<FormularioFURAG, Long> {

    List<FormularioFURAG> findAll();
    Optional<FormularioFURAG> findById(Long id);
}
