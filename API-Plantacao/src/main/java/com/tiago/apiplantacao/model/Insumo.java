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
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToMany(mappedBy = "insumos", fetch = FetchType.EAGER)
    @JsonBackReference
    Set<Canteiro> canteiros;

    public Insumo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Descricao: " + descricao;
    }
}
