package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "puntaje")
public class Puntaje {

    @Id
    @GeneratedValue
    private UUID id;

    private double valor;

    private String categoria;

    private Date vigencia;

    @ManyToOne
    @JoinColumn(name = "entidad_id")
    private Entidad entidad;
}
