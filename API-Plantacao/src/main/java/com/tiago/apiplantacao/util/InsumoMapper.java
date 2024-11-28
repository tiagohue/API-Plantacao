package com.tiago.apiplantacao.util;

import com.tiago.apiplantacao.dto.request.InsumoRequestDTO;
import com.tiago.apiplantacao.dto.response.InsumoResponseDTO;
import com.tiago.apiplantacao.model.Insumo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InsumoMapper {
    public Insumo toInsumo(InsumoRequestDTO insumoDTO) {
        return Insumo.builder()
                .descricao(insumoDTO.getDescricao())
                .build();
    }

    public InsumoResponseDTO toInsumoDTO(Insumo insumo) {
        return new InsumoResponseDTO(insumo);
    }

    public List<InsumoResponseDTO> toInsumoDTO(List<Insumo> insumoList) {
        return insumoList.stream().map(InsumoResponseDTO::new).collect(Collectors.toList());
    }

    public void updateInsumo(Insumo insumo, InsumoRequestDTO insumoDTO) {
        insumo.setDescricao(insumoDTO.getDescricao());
    }
}
