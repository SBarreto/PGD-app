package com.pgd.app.repository;

import com.pgd.app.model.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<Entidad, Integer> {
}
