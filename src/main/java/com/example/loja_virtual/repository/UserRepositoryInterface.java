package com.example.loja_virtual.repository;

import com.example.loja_virtual.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository <Usuario, Integer> {

	Usuario findUserByEmail(String email);
}
