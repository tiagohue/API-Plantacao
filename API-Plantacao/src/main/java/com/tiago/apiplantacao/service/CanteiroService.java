package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.CanteiroRequestDTO;
import com.tiago.apiplantacao.dto.response.CanteiroResponseDTO;

import java.util.List;

public interface CanteiroService {
    CanteiroResponseDTO findById(Long id);

    List<CanteiroResponseDTO> findAll();

    CanteiroResponseDTO register(CanteiroRequestDTO canteiroDTO);

    CanteiroResponseDTO update(CanteiroRequestDTO canteiroDTO, Long id);

    String delete(Long id);
}
