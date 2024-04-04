package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "formulariofurag")
public class FormularioFURAG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date vigencia;

    @ManyToMany(mappedBy = "formulariosFURAG", cascade = {CascadeType.PERSIST})
    private Set<Pregunta> preguntas;
    @OneToMany(mappedBy = "formularioFURAG")
    private Set<Respuesta> respuestas;

    public FormularioFURAG(Date vigencia) {
        this.vigencia = vigencia;
        this.preguntas = new HashSet<>();
        this.respuestas = new HashSet<>();
    }
}