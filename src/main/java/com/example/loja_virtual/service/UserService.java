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

    public Usuario getUserById(Integer usuarioid){
        return repository.findById(usuarioid).get();
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

    public List<Usuario> getUsersByCerveja(){
        List<Usuario> lojaslist = repository.findAll();
        List<Usuario> cervejalist = new ArrayList<Usuario>();

        for(Usuario user : lojaslist){
            
            if (user.getCerveja() != null && user.getCerveja().equals("Cerveja")) {
                cervejalist.add(user);
            }
        }

        return cervejalist;
    }

    public List<Usuario> getUsersByVodka(){
        List<Usuario> lojaslist = repository.findAll();
        List<Usuario> vodkalist = new ArrayList<Usuario>();

        for(Usuario user : lojaslist){
            
            if (user.getVodka() != null && user.getVodka().equals("Vodka")) {
                vodkalist.add(user);
            }
        }

        return vodkalist;
    }

    public List<Usuario> getUsersByWhiskey(){
        List<Usuario> lojaslist = repository.findAll();
        List<Usuario> whiskeylist = new ArrayList<Usuario>();

        for(Usuario user : lojaslist){
            
            if (user.getWhiskey() != null && user.getWhiskey().equals("Whiskey")) {
                whiskeylist.add(user);
            }
        }

        return whiskeylist;
    }

    public List<Usuario> getUsersByVinho(){
        List<Usuario> lojaslist = repository.findAll();
        List<Usuario> vinholist = new ArrayList<Usuario>();

        for(Usuario user : lojaslist){
            
            if (user.getVinho() != null && user.getVinho().equals("Vinho")) {
                vinholist.add(user);
            }
        }

        return vinholist;
    }

    public List<Usuario> getUsersByLicor(){
        List<Usuario> lojaslist = repository.findAll();
        List<Usuario> licorlist = new ArrayList<Usuario>();

        for(Usuario user : lojaslist){
            
            if (user.getLicor() != null && user.getLicor().equals("Licor")) {
                licorlist.add(user);
            }
        }

        return licorlist;
    }
}
