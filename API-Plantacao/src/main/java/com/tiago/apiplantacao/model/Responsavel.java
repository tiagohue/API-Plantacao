package com.tiago.apiplantacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Responsavel(String nome) {
        setNome(nome);
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome;
    }
}
