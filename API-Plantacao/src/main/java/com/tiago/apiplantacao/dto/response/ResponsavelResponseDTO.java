package com.tiago.apiplantacao.dto.response;

import com.tiago.apiplantacao.model.Responsavel;
import lombok.Getter;

import java.util.Set;

@Getter
public class ResponsavelResponseDTO {
    private Long id;

    private String nome;

    public ResponsavelResponseDTO(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
    }
}
