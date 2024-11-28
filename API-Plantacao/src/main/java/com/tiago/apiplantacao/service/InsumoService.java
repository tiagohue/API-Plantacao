package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.InsumoRequestDTO;
import com.tiago.apiplantacao.dto.response.InsumoResponseDTO;

import java.util.List;

public interface InsumoService {
    InsumoResponseDTO findById(Long id);

    List<InsumoResponseDTO> findAll();

    InsumoResponseDTO register(InsumoRequestDTO canteiroDTO);

    InsumoResponseDTO update(InsumoRequestDTO canteiroDTO, Long id);

    String delete(Long id);
}
