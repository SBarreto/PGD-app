package com.pgd.app.model;

import com.pgd.app.enums.Alerta;
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
@Table(name = "evidencia")
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String texto;

    private Alerta alerta;

    @ManyToOne
    private FormularioFURAG formularioFURAG;

    @OneToOne
    private RespuestaGE respuestaGE;

    public Evidencia(String texto, FormularioFURAG formularioFURAG) {
        this.texto = texto;
        this.formularioFURAG = formularioFURAG;
    }

}
