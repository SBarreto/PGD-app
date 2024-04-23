package com.pgd.app.model;

import jakarta.persistence.*;
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
@Table(name = "pregunta_ge")
public class PreguntaGE {

    @Id
    private String id;

    private String enunciado;

    private String evidenciaSugerida;

    private String rolSugerido;

    @ManyToOne
    private Pregunta pregunta;

    @OneToMany(mappedBy = "preguntaGE")
    private Set<RespuestaGE> respuestasGE;


    public PreguntaGE(String id, String enunciado, String evidenciaSugerida, String rolSugerido, Pregunta pregunta) {
        this.id = id;
        this.enunciado = enunciado;
        this.evidenciaSugerida = evidenciaSugerida;
        this.rolSugerido = rolSugerido;
        this.pregunta = pregunta;
    }
}
