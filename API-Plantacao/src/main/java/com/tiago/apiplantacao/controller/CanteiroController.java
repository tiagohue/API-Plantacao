package com.tiago.apiplantacao.controller;

import com.tiago.apiplantacao.model.Canteiro;
import com.tiago.apiplantacao.repository.CanteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/canteiros")
public class CanteiroController {

    @Autowired
    private CanteiroRepository canteiroRepository;

    @GetMapping
    public List<Canteiro> getAllCanteiros() {
        return canteiroRepository.findAll();
    }

}
