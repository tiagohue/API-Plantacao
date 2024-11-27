package com.tiago.apiplantacao.dto.request;

import com.tiago.apiplantacao.model.Responsavel;
import lombok.Getter;

@Getter
public class CanteiroRequestDTO {
    private Double area;

    private Responsavel responsavel;
}
