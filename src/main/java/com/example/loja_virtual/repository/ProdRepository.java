package com.example.loja_virtual.repository;

import com.example.loja_virtual.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepository extends JpaRepository <Produto, Integer> {
    
}
