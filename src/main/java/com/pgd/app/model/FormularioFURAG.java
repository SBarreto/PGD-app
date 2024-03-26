package com.pgd.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private Long id;

    private Date vigencia;

    @OneToMany
    private List<Pregunta> preguntas;
}
