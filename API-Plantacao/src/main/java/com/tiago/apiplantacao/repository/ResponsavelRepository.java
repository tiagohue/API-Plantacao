package com.tiago.apiplantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.apiplantacao.model.Responsavel;

import java.util.List;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{

    List<Responsavel> findByNomeContaining(String nome);
}
