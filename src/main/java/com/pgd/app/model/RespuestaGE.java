package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "respuesta_ge")
public class RespuestaGE {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "pregunta_ge_id")
    private PreguntaGE preguntaGE;

    @ManyToOne
    @JoinColumn(name = "formulario_id")
    private FormularioFURAG formularioFURAG;

    public RespuestaGE(String texto, PreguntaGE preguntaGE, FormularioFURAG formularioFURAG) {
        this.texto = texto;
        this.preguntaGE = preguntaGE;
        this.formularioFURAG = formularioFURAG;
    }
}
