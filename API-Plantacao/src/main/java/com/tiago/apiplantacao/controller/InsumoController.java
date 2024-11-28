package com.tiago.apiplantacao.controller;

import com.tiago.apiplantacao.dto.request.InsumoRequestDTO;
import com.tiago.apiplantacao.dto.response.InsumoResponseDTO;
import com.tiago.apiplantacao.service.InsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/insumos")
@RequiredArgsConstructor
public class InsumoController {

    private final InsumoService insumoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<InsumoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(insumoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<InsumoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(insumoService.findAll());
    }

    @PostMapping
    public ResponseEntity<InsumoResponseDTO> register(
            @RequestBody InsumoRequestDTO insumoRequestDTO,
            UriComponentsBuilder uriBuilder) {

        InsumoResponseDTO insumoResponseDTO = insumoService.register(insumoRequestDTO);
        URI uri = uriBuilder.path("/insumos/{id}").buildAndExpand(insumoResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(insumoResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InsumoResponseDTO> update(@RequestBody InsumoRequestDTO insumoDTO,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok().body(insumoService.update(insumoDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(insumoService.delete(id));
    }
}
