package com.example.loja_virtual.service;

import java.util.ArrayList;
import java.util.List;

import com.example.loja_virtual.model.Loja;
import com.example.loja_virtual.repository.LojaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {
    
    @Autowired
    private LojaRepository repository;

    public List<Loja> getUsers(){
        return repository.findAll();
    }

    public Loja getUserById(Integer usuarioid){
        return repository.findById(usuarioid).get();
    }

    public void salvar(Loja user){
        repository.save(user);
    }

    public Loja findUserByEmail(String email){
        return repository.findUserByEmail(email);
    }

    public Loja getUserByLogin(String email, String senha)
    {
        Loja user = findUserByEmail(email);
        List<Loja> lojaslist = repository.findAll();
        int cont=0;
        
        for(Loja l : lojaslist){
            if(l == user){
                cont=1;
            }
        }
        if(cont==0){
            return null;
        }

        if(!user.getSenha().equals(senha)){
            user = null;
        }
        return user;
    }

    public List<Loja> getUsersByCerveja(){
        List<Loja> lojaslist = repository.findAll();
        List<Loja> cervejalist = new ArrayList<Loja>();

        for(Loja user : lojaslist){
            
            if (user.getCerveja() != null && user.getCerveja().equals("Cerveja")) {
                cervejalist.add(user);
            }
        }

        return cervejalist;
    }

    public List<Loja> getUsersByVodka(){
        List<Loja> lojaslist = repository.findAll();
        List<Loja> vodkalist = new ArrayList<Loja>();

        for(Loja user : lojaslist){
            
            if (user.getVodka() != null && user.getVodka().equals("Vodka")) {
                vodkalist.add(user);
            }
        }

        return vodkalist;
    }

    public List<Loja> getUsersByWhiskey(){
        List<Loja> lojaslist = repository.findAll();
        List<Loja> whiskeylist = new ArrayList<Loja>();

        for(Loja user : lojaslist){
            
            if (user.getWhiskey() != null && user.getWhiskey().equals("Whiskey")) {
                whiskeylist.add(user);
            }
        }

        return whiskeylist;
    }

    public List<Loja> getUsersByVinho(){
        List<Loja> lojaslist = repository.findAll();
        List<Loja> vinholist = new ArrayList<Loja>();

        for(Loja user : lojaslist){
            
            if (user.getVinho() != null && user.getVinho().equals("Vinho")) {
                vinholist.add(user);
            }
        }

        return vinholist;
    }

    public List<Loja> getUsersByLicor(){
        List<Loja> lojaslist = repository.findAll();
        List<Loja> licorlist = new ArrayList<Loja>();

        for(Loja user : lojaslist){
            
            if (user.getLicor() != null && user.getLicor().equals("Licor")) {
                licorlist.add(user);
            }
        }

        return licorlist;
    }
}
