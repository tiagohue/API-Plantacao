package com.tiago.apiplantacao.entity;

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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Override
    public String toString() {
        return "Id: " + id +
        ", Nome: " + nome;
    }
}
