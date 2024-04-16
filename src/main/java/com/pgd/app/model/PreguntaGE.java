package com.pgd.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pregunta_ge")
public class PreguntaGE {

    @Id
    private String id;

    private String enunciado;

    private String evidenciaSugerida;

    private String rolSugerido;

    @ManyToOne
    private Pregunta pregunta;


}
