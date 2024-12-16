package com.tiago.apiplantacao.controller;

import com.tiago.apiplantacao.dto.request.ResponsavelRequestDTO;
import com.tiago.apiplantacao.dto.response.ResponsavelResponseDTO;
import com.tiago.apiplantacao.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/responsaveis")
@RequiredArgsConstructor
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponsavelResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(responsavelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelResponseDTO>> findAll() {
        return ResponseEntity.ok().body(responsavelService.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponsavelResponseDTO> register(
            @RequestBody ResponsavelRequestDTO responsavelRequestDTO,
            UriComponentsBuilder uriBuilder) {

        ResponsavelResponseDTO responsavelResponseDTO = responsavelService.register(responsavelRequestDTO);
        URI uri = uriBuilder.path("/responsaveis/{id}").buildAndExpand(responsavelResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responsavelResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponsavelResponseDTO> update(@RequestBody ResponsavelRequestDTO responsavelDTO,
                                                       @PathVariable Long id) {
        return ResponseEntity.ok().body(responsavelService.update(responsavelDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(responsavelService.delete(id));
    }
}
