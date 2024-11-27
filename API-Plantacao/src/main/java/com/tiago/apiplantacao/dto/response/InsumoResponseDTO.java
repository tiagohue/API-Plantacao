package com.tiago.apiplantacao.dto.response;

import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.model.Insumo;
import lombok.Getter;

import java.util.Set;

@Getter
public class InsumoResponseDTO {
    private Long id;

    private String descricao;

    Set<Canteiro> canteiros;

    public InsumoResponseDTO(Insumo insumo) {
        this.id = insumo.getId();
        this.descricao = insumo.getDescricao();
        this.canteiros = insumo.getCanteiros();
    }
}
