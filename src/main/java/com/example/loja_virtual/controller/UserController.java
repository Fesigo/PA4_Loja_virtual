package com.example.loja_virtual.controller;

import java.util.List;

import com.example.loja_virtual.model.Usuario;
import com.example.loja_virtual.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repositorio;

    @GetMapping("/listaclientes")
    public List<Usuario> getAllClientes(){
        return repositorio.getAllUsuarios();
    }

    @PostMapping("/cadastrocliente")
    public Usuario salvaUsuario(@RequestBody Usuario usuario){
        return repositorio.saveUsuario(usuario);
    }
}
