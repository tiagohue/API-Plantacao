package com.tiago.apiplantacao.controller;

import com.tiago.apiplantacao.dto.request.CanteiroRequestDTO;
import com.tiago.apiplantacao.dto.response.CanteiroResponseDTO;
import com.tiago.apiplantacao.service.CanteiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/canteiros")
@RequiredArgsConstructor
public class CanteiroController {

    private final CanteiroService canteiroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CanteiroResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(canteiroService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CanteiroResponseDTO>> findAll() {
        return ResponseEntity.ok().body(canteiroService.findAll());
    }

    @PostMapping
    public ResponseEntity<CanteiroResponseDTO> register(
            @RequestBody CanteiroRequestDTO canteiroRequestDTO,
            UriComponentsBuilder uriBuilder) {

        CanteiroResponseDTO canteiroResponseDTO = canteiroService.register(canteiroRequestDTO);
        URI uri = uriBuilder.path("/canteiros/{id}").buildAndExpand(canteiroResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(canteiroResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CanteiroResponseDTO> update(@RequestBody CanteiroRequestDTO canteiroDTO,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok().body(canteiroService.update(canteiroDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(canteiroService.delete(id));
    }
}
