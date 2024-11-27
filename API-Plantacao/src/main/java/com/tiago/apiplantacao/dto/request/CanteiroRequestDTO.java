package com.tiago.apiplantacao.dto.request;

import com.tiago.apiplantacao.model.Insumo;
import com.tiago.apiplantacao.model.Planta;
import com.tiago.apiplantacao.model.Responsavel;
import lombok.Getter;

import java.util.Set;

@Getter
public class CanteiroRequestDTO {
    private Double area;

    private Responsavel responsavel;
}
