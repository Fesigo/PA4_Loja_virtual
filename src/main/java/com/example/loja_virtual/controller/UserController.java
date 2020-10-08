package com.example.loja_virtual.controller;

import com.example.loja_virtual.model.Usuario;
import com.example.loja_virtual.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/users")
    public ModelAndView getUsers(){

        ModelAndView mv = new ModelAndView("usersTemplate");
        mv.addObject("users", us.getUsers());

        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario user){
        us.salvar(user);
        return "redirect:/users";
    }

    /*@RequestMapping("/cadastroUsuario")
    public String form(){
        return "cadastroUsuario";
    }*/

    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    
    @PostMapping("/login")
    public ModelAndView loginform(@ModelAttribute Usuario user){
        ModelAndView mv = new ModelAndView();
        user = us.getUserByLogin(user.getEmail(), user.getSenha());

        if(user == null){
            mv.setViewName("erro");
        }
        else{
            mv.setViewName("userView");
        }


        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/busca")
    public String busca(){
        return "tiposBebida";
    }
}
