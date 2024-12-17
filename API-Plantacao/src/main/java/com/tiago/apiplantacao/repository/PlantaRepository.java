package com.tiago.apiplantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.apiplantacao.model.Planta;

import java.util.List;

public interface PlantaRepository extends JpaRepository<Planta, Long>{

    List<Planta> findByNomeContaining(String nome);
}
