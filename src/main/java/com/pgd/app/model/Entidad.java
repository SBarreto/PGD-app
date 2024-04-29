package com.pgd.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "entidad")
public class Entidad {

    @Id
    private int codigosigep;

    private String nombre;

    private String naturalezaJuridica;

    private String orden;

    private String sector;

    private String codigomunicipio;

    private int codigodepartamento;

    @OneToMany(mappedBy = "entidad")
    private Set<Puntaje> puntajes;

    @OneToMany(mappedBy = "entidad")
    private Set<FormularioFURAG> formulariosFURAG;

    @OneToMany(mappedBy = "entidad")
    private Set<Usuario> usuarios;
}
