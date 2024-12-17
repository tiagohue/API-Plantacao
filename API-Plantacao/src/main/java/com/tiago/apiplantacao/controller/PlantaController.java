package com.tiago.apiplantacao.controller;

import com.tiago.apiplantacao.dto.request.PlantaRequestDTO;
import com.tiago.apiplantacao.dto.response.PlantaResponseDTO;
import com.tiago.apiplantacao.service.PlantaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/plantas")
@RequiredArgsConstructor
public class PlantaController {

    private final PlantaService plantaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlantaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(plantaService.findById(id));
    }

    @GetMapping(value = "nome/{nome}")
    public ResponseEntity<List<PlantaResponseDTO>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(plantaService.findByNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<PlantaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(plantaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PlantaResponseDTO> register(
            @RequestBody PlantaRequestDTO plantaRequestDTO,
            UriComponentsBuilder uriBuilder) {

        PlantaResponseDTO plantaResponseDTO = plantaService.register(plantaRequestDTO);
        URI uri = uriBuilder.path("/plantas/{id}").buildAndExpand(plantaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(plantaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PlantaResponseDTO> update(@RequestBody PlantaRequestDTO plantaDTO,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok().body(plantaService.update(plantaDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(plantaService.delete(id));
    }
}
