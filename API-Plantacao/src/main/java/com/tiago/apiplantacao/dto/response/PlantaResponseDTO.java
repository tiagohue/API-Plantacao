package com.tiago.apiplantacao.dto.response;

import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.model.Planta;
import lombok.Getter;

import java.util.Set;

@Getter
public class PlantaResponseDTO {
    private Long id;

    private String nome;

    private Integer periodo_colheita;

    Set<Canteiro> canteiros;

    public PlantaResponseDTO(Planta planta) {
        this.id = planta.getId();
        this.nome = planta.getNome();
        this.periodo_colheita = planta.getPeriodo_colheita();
        this.canteiros = planta.getCanteiros();
    }
}
