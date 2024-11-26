package com.tiago.apiplantacao.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Getter
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Builder
    public Responsavel(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome;
    }
}
