package com.pgd.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "pregunta_formulariofurag",
            joinColumns = @JoinColumn(name = "pregunta_id"),
            inverseJoinColumns = @JoinColumn(name = "formulario_id")

    )
    private Set<FormularioFURAG> formulariosFURAG;

    @OneToMany(mappedBy = "pregunta")
    private Set<Respuesta> respuestas;

    public Pregunta(String id, String enunciado, String elemento) {
        this.id = id;
        this.enunciado = enunciado;
        this.elemento = elemento;
        this.formulariosFURAG = new HashSet<>();
        this.respuestas = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pregunta pregunta)) return false;
        return Objects.equals(id, pregunta.id) && Objects.equals(enunciado, pregunta.enunciado) && Objects.equals(elemento, pregunta.elemento) && Objects.equals(formulariosFURAG, pregunta.formulariosFURAG);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enunciado, elemento, formulariosFURAG);
    }
}
