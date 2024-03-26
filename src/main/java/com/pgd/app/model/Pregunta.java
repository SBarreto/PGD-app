package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    private String id;

    private String enunciado;

    private String elemento;

    @ManyToOne @JoinColumn(name = "idformulariofurag")
    private FormularioFURAG formularioFURAG;

}
