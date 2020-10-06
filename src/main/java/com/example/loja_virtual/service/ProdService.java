package com.example.loja_virtual.service;

import java.util.List;

import com.example.loja_virtual.model.Produto;
import com.example.loja_virtual.repository.ProdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdService {
    
    @Autowired
    private ProdRepository repository;

    public void salvar(Produto produto){
        repository.save(produto);
    }

    public List<Produto> getProdutos(){
        return repository.findAll();
    }

}
