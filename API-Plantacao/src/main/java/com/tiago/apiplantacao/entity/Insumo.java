package com.tiago.apiplantacao.entity;

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
public class Insumo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;

    @ManyToMany(mappedBy = "insumos", fetch = FetchType.EAGER)
    Set<Canteiro> canteiros;

    @Override
    public String toString() {
        return "Id: " + id +
        ", Descricao: " + descricao;
    }
}
