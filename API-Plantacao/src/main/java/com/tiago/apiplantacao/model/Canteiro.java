package com.tiago.apiplantacao.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
public class Canteiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
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
    @JsonManagedReference
    Set<Planta> plantas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Aplicado", 
        joinColumns = @JoinColumn(name = "canteiro_id"), 
        inverseJoinColumns = @JoinColumn(name = "insumo_id")
    )
    @JsonManagedReference
    Set<Insumo> insumos;

    public Canteiro(Double area, Responsavel responsavel) {
        this.area = area;
        this.responsavel = responsavel;
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