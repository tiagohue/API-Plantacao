package com.tiago.apiplantacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
