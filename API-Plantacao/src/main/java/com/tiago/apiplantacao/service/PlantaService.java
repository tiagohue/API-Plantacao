package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.PlantaRequestDTO;
import com.tiago.apiplantacao.dto.response.PlantaResponseDTO;

import java.util.List;

public interface PlantaService {
    PlantaResponseDTO findById(Long id);

    List<PlantaResponseDTO> findAll();

    PlantaResponseDTO register(PlantaRequestDTO canteiroDTO);

    PlantaResponseDTO update(PlantaRequestDTO canteiroDTO, Long id);

    String delete(Long id);
}