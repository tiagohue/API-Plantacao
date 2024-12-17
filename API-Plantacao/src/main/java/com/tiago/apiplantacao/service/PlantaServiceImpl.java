package com.tiago.apiplantacao.service;

import com.tiago.apiplantacao.dto.request.PlantaRequestDTO;
import com.tiago.apiplantacao.dto.response.PlantaResponseDTO;
import com.tiago.apiplantacao.model.Planta;
import com.tiago.apiplantacao.repository.PlantaRepository;
import com.tiago.apiplantacao.util.PlantaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Primary
@RequiredArgsConstructor
public class PlantaServiceImpl implements PlantaService{
    private final PlantaRepository plantaRepository;
    private final PlantaMapper plantaMapper;

    @Override
    public PlantaResponseDTO findById(Long id) {
        return plantaMapper.toPlantaDTO(returnPlanta(id));
    }

    @Override
    public List<PlantaResponseDTO> findByNome(String nome) {
        List<Planta> plantas = plantaRepository.findByNomeContaining(nome);

        return plantaMapper.toPlantaDTO(plantas);
    }

    @Override
    public List<PlantaResponseDTO> findAll() {
        return plantaMapper.toPlantaDTO(plantaRepository.findAll());
    }

    @Override @Transactional
    public PlantaResponseDTO register(PlantaRequestDTO plantaDTO) {
        Planta planta = plantaMapper.toPlanta(plantaDTO);

        return plantaMapper.toPlantaDTO(plantaRepository.save(planta));
    }

    @Override @Transactional
    public PlantaResponseDTO update(PlantaRequestDTO plantaDTO, Long id) {
        Planta planta = returnPlanta(id);

        plantaMapper.updatePlanta(planta, plantaDTO);

        return plantaMapper.toPlantaDTO(plantaRepository.save(planta));
    }

    @Override @Transactional
    public String delete(Long id) {
        Planta planta = returnPlanta(id);

        planta.getCanteiros().forEach(canteiro -> {
            Set<Planta> plantaSet = canteiro.getPlantas();
            plantaSet.remove(planta);

            canteiro.setPlantas(plantaSet);
        });

        plantaRepository.deleteById(id);
        return "Planta de id: " + id + " foi deletada.";
    }

    private Planta returnPlanta(Long id) {
        return plantaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planta não encontrado."));
    }
}
