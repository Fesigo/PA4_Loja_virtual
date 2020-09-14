package com.example.loja_virtual.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.loja_virtual.model.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private List<Usuario> usuarios;

    /* alguns objetos para teste
    @PostConstruct
    public void criarUsuarios(){
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();

        u1.setUsuarioid(1);
        u1.setNome("Felipe");
        u1.setSobrenome("Siqueira");
        u1.setEmail("felipe@gmail.com");
        u1.setSenha("abc123");

        u2.setUsuarioid(2);
        u2.setNome("Guilherme");
        u2.setSobrenome("Machado");
        u2.setEmail("Gui@gmail.com");
        u2.setSenha("def456");

        usuarios = new ArrayList<Usuario>();
        usuarios.add(u1);
        usuarios.add(u2);
    }*/

    public List<Usuario> getAllUsuarios(){
        return usuarios;
    }

    public Usuario saveUsuario(Usuario usuario)
    {
        usuario.setUsuarioid(usuarios.size() + 1);
        usuarios.add(usuario);
        return usuario;
    }
}
