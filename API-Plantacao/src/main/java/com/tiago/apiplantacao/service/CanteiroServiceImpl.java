package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.CanteiroRequestDTO;
import com.tiago.apiplantacao.dto.response.CanteiroResponseDTO;
import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.repository.CanteiroRepository;
import com.tiago.apiplantacao.util.CanteiroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class CanteiroServiceImpl implements CanteiroService{
    private final CanteiroRepository canteiroRepository;
    private final CanteiroMapper canteiroMapper;

    @Override
    public CanteiroResponseDTO findById(Long id) {
        return canteiroMapper.toCanteiroDTO(returnCanteiro(id));
    }

    @Override
    public List<CanteiroResponseDTO> findAll() {
        return canteiroMapper.toCanteiroDTO(canteiroRepository.findAll());
    }

    @Override
    public CanteiroResponseDTO register(CanteiroRequestDTO canteiroDTO) {
        Canteiro canteiro = canteiroMapper.toCanteiro(canteiroDTO);

        return canteiroMapper.toCanteiroDTO(canteiroRepository.save(canteiro));
    }

    @Override
    public CanteiroResponseDTO update(CanteiroRequestDTO canteiroDTO, Long id) {
        Canteiro canteiro = returnCanteiro(id);

        canteiroMapper.updateCanteiro(canteiro, canteiroDTO);

        return canteiroMapper.toCanteiroDTO(canteiroRepository.save(canteiro));
    }

    @Override
    public String delete(Long id) {
        canteiroRepository.deleteById(id);
        return "Canteiro de id: " + id + " foi deletado.";
    }

    private Canteiro returnCanteiro(Long id) {
        return canteiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Canteiro não encontrado."));
    }
}
