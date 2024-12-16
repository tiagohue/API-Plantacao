package com.tiago.apiplantacao.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas", fetch = FetchType.EAGER)
    @JsonBackReference
    Set<Canteiro> canteiros;

    @Builder
    public Planta(String nome, Integer periodo_colheita) {
        this.nome = nome;
        this.periodo_colheita = periodo_colheita;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome +
        ", Periodo_colheita: " + periodo_colheita;
    }
}
