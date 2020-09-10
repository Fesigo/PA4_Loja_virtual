package com.example.loja_virtual.controller;

import java.util.List;

import com.example.loja_virtual.model.Produto;
import com.example.loja_virtual.repository.ProdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {

    @Autowired
    private ProdRepository repositorio;

    @GetMapping("/lojavirtual")
    public List<Produto> getAllProdutos(){
        return repositorio.getAllProdutos();
    }

    @GetMapping("/produto/{codigo}")
    public Produto getProduto(@PathVariable int codigo){
        return repositorio.getProdutoByCodigo(codigo);
    }

    @PostMapping("/cadastroproduto")
    public Produto salvar(@RequestBody Produto produto){
        return repositorio.save(produto);
    }
}