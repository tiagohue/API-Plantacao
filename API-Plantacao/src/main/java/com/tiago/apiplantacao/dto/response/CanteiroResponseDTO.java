package com.tiago.apiplantacao.dto.response;

import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.model.Insumo;
import com.tiago.apiplantacao.model.Planta;
import com.tiago.apiplantacao.model.Responsavel;
import lombok.Getter;

import java.util.Set;

@Getter
public class CanteiroResponseDTO {
    private Long id;

    private Double area;

    private Responsavel responsavel;

    Set<Planta> plantas;

    Set<Insumo> insumos;

    public CanteiroResponseDTO(Canteiro canteiro) {
        this.id = canteiro.getId();
        this.area = canteiro.getArea();
        this.responsavel = canteiro.getResponsavel();
        this.plantas = canteiro.getPlantas();
        this.insumos = canteiro.getInsumos();
    }
}
