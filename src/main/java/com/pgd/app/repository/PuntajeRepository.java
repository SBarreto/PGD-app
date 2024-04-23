package com.pgd.app.repository;

import com.pgd.app.model.Puntaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PuntajeRepository extends JpaRepository<Puntaje, UUID> {

    List<Puntaje> findAllByEntidad_Codigosigep(int codigosigep);

    List<Puntaje> findAllByEntidad_CodigosigepAndAndCategoria(int codigosigep, String categoria);

    List<Puntaje> findAllByEntidad_Codigomunicipio(String codigomunicipio);

    List<Puntaje> findAllByEntidad_CodigomunicipioAndCategoria(String codigomunicipio, String categoria);

    List<Puntaje> findAllByEntidad_NaturalezaJuridica(String naturalezaJuridica);

    List<Puntaje> findAllByEntidad_NaturalezaJuridicaAndCategoria(String naturalezaJuridica, String categoria);

    List<Puntaje> findAllByEntidad_Orden(String orden);

    List<Puntaje> findAllByEntidad_OrdenAndCategoria(String orden, String categoria);

    List<Puntaje> findAllByEntidad_Sector(String sector);

    List<Puntaje> findAllByEntidad_SectorAndCategoria(String sector, String categoria);

    List<Puntaje> findAllByEntidad_Codigodepartamento(int codigodepartamento);

    List<Puntaje> findAllByEntidad_CodigodepartamentoAndCategoria(int codigodepartamento, String categoria);
}
