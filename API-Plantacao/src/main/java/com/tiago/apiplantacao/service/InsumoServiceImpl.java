package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.InsumoRequestDTO;
import com.tiago.apiplantacao.dto.response.InsumoResponseDTO;
import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.model.Insumo;
import com.tiago.apiplantacao.repository.CanteiroRepository;
import com.tiago.apiplantacao.repository.InsumoRepository;
import com.tiago.apiplantacao.util.InsumoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Primary
@RequiredArgsConstructor
public class InsumoServiceImpl implements InsumoService{
    private final InsumoRepository insumoRepository;
    private final InsumoMapper insumoMapper;
    private final CanteiroRepository canteiroRepository;

    @Override
    public InsumoResponseDTO findById(Long id) {
        return insumoMapper.toInsumoDTO(returnInsumo(id));
    }

    @Override
    public List<InsumoResponseDTO> findByDesc(String desc) {
        List<Insumo> insumos = insumoRepository.findByDescricaoContaining(desc);

        return insumoMapper.toInsumoDTO(insumos);
    }

    @Override
    public List<InsumoResponseDTO> findAll() {
        return insumoMapper.toInsumoDTO(insumoRepository.findAll());
    }

    @Override
    public InsumoResponseDTO register(InsumoRequestDTO insumoDTO) {
        Insumo insumo = insumoMapper.toInsumo(insumoDTO);

        return insumoMapper.toInsumoDTO(insumoRepository.save(insumo));
    }

    @Override
    public InsumoResponseDTO update(InsumoRequestDTO insumoDTO, Long id) {
        Insumo insumo = returnInsumo(id);

        insumoMapper.updateInsumo(insumo, insumoDTO);

        return insumoMapper.toInsumoDTO(insumoRepository.save(insumo));
    }

    @Override @Transactional
    public String delete(Long id) {
        Insumo insumo = returnInsumo(id);

        insumo.getCanteiros().forEach(canteiro -> {
            Set<Insumo> insumoSet = canteiro.getInsumos();
            insumoSet.remove(insumo);

            canteiro.setInsumos(insumoSet);
        });

        insumoRepository.deleteById(id);
        return "Insumo de id: " + id + " foi deletado.";
    }

    private Insumo returnInsumo(Long id) {
        return insumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo não encontrado."));
    }
}
