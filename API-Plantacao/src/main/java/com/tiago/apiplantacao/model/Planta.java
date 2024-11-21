package com.tiago.apiplantacao.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer periodo_colheita;

    @ManyToMany(mappedBy = "plantas", fetch = FetchType.EAGER)
    Set<Canteiro> canteiros;

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome +
        ", Periodo_colheita: " + periodo_colheita;
    }
}
