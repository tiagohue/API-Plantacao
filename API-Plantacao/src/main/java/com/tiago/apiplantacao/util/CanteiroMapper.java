package com.tiago.apiplantacao.util;

import com.tiago.apiplantacao.dto.request.CanteiroRequestDTO;
import com.tiago.apiplantacao.dto.response.CanteiroResponseDTO;
import com.tiago.apiplantacao.model.Canteiro;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CanteiroMapper {
    public Canteiro toCanteiro(CanteiroRequestDTO canteiroDTO) {
        return Canteiro.builder()
                .area(canteiroDTO.getArea())
                .responsavel(canteiroDTO.getResponsavel())
                .build();
    }

    public CanteiroResponseDTO toCanteiroDTO(Canteiro canteiro) {
        return new CanteiroResponseDTO(canteiro);
    }

    public List<CanteiroResponseDTO> toCanteiroDTO(List<Canteiro> canteiroList) {
        return canteiroList.stream().map(CanteiroResponseDTO::new).collect(Collectors.toList());
    }

    public void updateCanteiro(Canteiro canteiro, CanteiroRequestDTO canteiroDTO) {
        canteiro.setArea(canteiroDTO.getArea());
        canteiro.setResponsavel(canteiroDTO.getResponsavel());
    }
}
