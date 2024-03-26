package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


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

    @OneToMany(mappedBy = "formularioFURAG", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Pregunta> preguntas;

    public FormularioFURAG(Date vigencia) {
        this.vigencia = vigencia;
    }
}
