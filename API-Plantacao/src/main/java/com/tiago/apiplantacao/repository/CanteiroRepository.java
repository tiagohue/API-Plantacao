package com.tiago.apiplantacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.apiplantacao.entity.Canteiro;

public interface CanteiroRepository extends JpaRepository<Canteiro, Integer>{
    
}
