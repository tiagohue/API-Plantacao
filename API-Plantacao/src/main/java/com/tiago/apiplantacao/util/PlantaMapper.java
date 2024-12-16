package com.tiago.apiplantacao.util;

import com.tiago.apiplantacao.dto.request.PlantaRequestDTO;
import com.tiago.apiplantacao.dto.response.PlantaResponseDTO;
import com.tiago.apiplantacao.model.Planta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlantaMapper {
    public Planta toPlanta(PlantaRequestDTO plantaDTO) {
        return Planta.builder()
                .nome(plantaDTO.getNome())
                .periodo_colheita(plantaDTO.getPeriodo_colheita())
                .build();
    }

    public PlantaResponseDTO toPlantaDTO(Planta planta) {
        return new PlantaResponseDTO(planta);
    }

    public List<PlantaResponseDTO> toPlantaDTO(List<Planta> plantaList) {
        return plantaList.stream().map(PlantaResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePlanta(Planta planta, PlantaRequestDTO plantaDTO) {
        planta.setNome(plantaDTO.getNome());
        planta.setPeriodo_colheita(plantaDTO.getPeriodo_colheita());
    }
}
