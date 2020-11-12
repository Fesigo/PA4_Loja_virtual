package com.example.loja_virtual.repository;

import com.example.loja_virtual.model.Loja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository <Loja, Integer> {

	Loja findUserByEmail(String email);
}
