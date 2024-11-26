package com.tiago.apiplantacao.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "insumos", fetch = FetchType.EAGER)
    @JsonBackReference
    Set<Canteiro> canteiros;

    @Builder
    public Insumo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Descricao: " + descricao;
    }
}
