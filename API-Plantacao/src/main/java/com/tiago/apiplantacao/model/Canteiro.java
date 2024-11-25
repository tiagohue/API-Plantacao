package com.tiago.apiplantacao.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table
@Data
public class Canteiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double area;

    @ManyToOne
    @JoinColumn(name = "fk_Responsavel_Id")
    private Responsavel responsavel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Plantada", 
        joinColumns = @JoinColumn(name = "canteiro_id"), 
        inverseJoinColumns = @JoinColumn(name = "planta_id")
    )
    Set<Planta> plantas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Aplicado", 
        joinColumns = @JoinColumn(name = "canteiro_id"), 
        inverseJoinColumns = @JoinColumn(name = "insumo_id")
    )
    Set<Insumo> insumos;

    public Canteiro(Double area, Responsavel responsavel) {
        setArea(area);
        setResponsavel(responsavel);
    }

    @Override
    public String toString() {
        return "Id: " + id +
        ", Area: " + area +
        ", Responsavel: " + responsavel +
        ", Plantas: " + plantas +
        ", Insumos: " + insumos;
    }

}