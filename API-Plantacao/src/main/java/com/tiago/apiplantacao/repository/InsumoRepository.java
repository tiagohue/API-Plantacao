package com.tiago.apiplantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.apiplantacao.model.Insumo;

import java.util.List;

public interface InsumoRepository extends JpaRepository<Insumo, Long>{

    List<Insumo> findByDescricaoContaining(String desc);
}
