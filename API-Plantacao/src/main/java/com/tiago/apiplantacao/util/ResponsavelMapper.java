package com.tiago.apiplantacao.util;

import com.tiago.apiplantacao.dto.request.ResponsavelRequestDTO;
import com.tiago.apiplantacao.dto.response.ResponsavelResponseDTO;
import com.tiago.apiplantacao.model.Responsavel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponsavelMapper {
    public Responsavel toResponsavel(ResponsavelRequestDTO responsavelDTO) {
        return Responsavel.builder()
                .nome(responsavelDTO.getNome())
                .build();
    }

    public ResponsavelResponseDTO toResponsavelDTO(Responsavel responsavel) {
        return new ResponsavelResponseDTO(responsavel);
    }

    public List<ResponsavelResponseDTO> toResponsavelDTO(List<Responsavel> responsavelList) {
        return responsavelList.stream().map(ResponsavelResponseDTO::new).collect(Collectors.toList());
    }

    public void updateResponsavel(Responsavel responsavel, ResponsavelRequestDTO responsavelDTO) {
        responsavel.setNome(responsavelDTO.getNome());
    }
}
