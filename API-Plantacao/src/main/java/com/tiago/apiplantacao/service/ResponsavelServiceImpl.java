package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.ResponsavelRequestDTO;
import com.tiago.apiplantacao.dto.response.ResponsavelResponseDTO;
import com.tiago.apiplantacao.model.Responsavel;
import com.tiago.apiplantacao.repository.CanteiroRepository;
import com.tiago.apiplantacao.repository.ResponsavelRepository;
import com.tiago.apiplantacao.util.ResponsavelMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ResponsavelServiceImpl implements ResponsavelService{
    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;
    private final CanteiroRepository canteiroRepository;

    @Override
    public ResponsavelResponseDTO findById(Long id) {
        return responsavelMapper.toResponsavelDTO(returnResponsavel(id));
    }

    @Override
    public List<ResponsavelResponseDTO> findByNome(String nome) {
        List<Responsavel> responsaveis = responsavelRepository.findByNomeContaining(nome);

        return responsavelMapper.toResponsavelDTO(responsaveis);
    }

    @Override
    public List<ResponsavelResponseDTO> findAll() {
        return responsavelMapper.toResponsavelDTO(responsavelRepository.findAll());
    }

    @Override @Transactional
    public ResponsavelResponseDTO register(ResponsavelRequestDTO responsavelDTO) {
        Responsavel responsavel = responsavelMapper.toResponsavel(responsavelDTO);

        return responsavelMapper.toResponsavelDTO(responsavelRepository.save(responsavel));
    }

    @Override @Transactional
    public ResponsavelResponseDTO update(ResponsavelRequestDTO responsavelDTO, Long id) {
        Responsavel responsavel = returnResponsavel(id);

        responsavelMapper.updateResponsavel(responsavel, responsavelDTO);

        return responsavelMapper.toResponsavelDTO(responsavelRepository.save(responsavel));
    }

    @Override @Transactional
    public String delete(Long id) {
        returnResponsavel(id);

        canteiroRepository.findAll().forEach(canteiro -> {
            if (canteiro.getResponsavel().getId() == id) {
                Long id_canteiro = canteiro.getId();
                throw new RuntimeException("Responsável atrelado ao canteiro de id: "+ id_canteiro
                        +", apague ou altere o responsável do canteiro antes.");
            }
        });

        responsavelRepository.deleteById(id);
        return "Responsavel de id: " + id + " foi deletado.";
    }

    public Responsavel returnResponsavel(Long id) {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsavel não encontrado."));
    }
}
