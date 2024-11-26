package com.tiago.apiplantacao.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas", fetch = FetchType.EAGER)
    @JsonBackReference
    Set<Canteiro> canteiros;

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
