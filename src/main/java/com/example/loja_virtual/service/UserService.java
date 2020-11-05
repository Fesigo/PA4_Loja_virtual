package com.example.loja_virtual.service;

import java.util.ArrayList;
import java.util.List;

import com.example.loja_virtual.model.Usuario;
import com.example.loja_virtual.repository.UserRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepositoryInterface repository;

    public List<Usuario> getUsers(){
        return repository.findAll();
    }

    public void salvar(Usuario user){
        repository.save(user);
    }

    public Usuario findUserByEmail(String email){
        return repository.findUserByEmail(email);
    }

    public Usuario getUserByLogin(String email, String senha)
    {
        Usuario user = findUserByEmail(email);

        if(!user.getSenha().equals(senha)){
            user = null;
        }
        return user;
    }

    public List<Usuario> getUsersByCerveja(String cerveja){
        List<Usuario> lojaslist = new ArrayList<Usuario>();
        List<Usuario> cervejalist = new ArrayList<Usuario>();
        
        lojaslist = repository.findAll();

        for(Usuario user : lojaslist){
            
            if (user.getCerveja() == "Cerveja") {
                cervejalist.add(user);
            }
        }

        return cervejalist;
    }
}
