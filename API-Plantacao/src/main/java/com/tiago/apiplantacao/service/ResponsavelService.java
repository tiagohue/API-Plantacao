package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.ResponsavelRequestDTO;
import com.tiago.apiplantacao.dto.response.ResponsavelResponseDTO;

import java.util.List;

public interface ResponsavelService {
    ResponsavelResponseDTO findById(Long id);

    List<ResponsavelResponseDTO> findByNome(String nome);

    List<ResponsavelResponseDTO> findAll();

    ResponsavelResponseDTO register(ResponsavelRequestDTO canteiroDTO);

    ResponsavelResponseDTO update(ResponsavelRequestDTO canteiroDTO, Long id);

    String delete(Long id);
}
