package com.example.loja_virtual.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.loja_virtual.model.Usuario;
import com.example.loja_virtual.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/users")
    public ModelAndView getUsers(){

        ModelAndView mv = new ModelAndView("cadastroproduto");
        mv.addObject("users", us.getUsers());

        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario user){
        us.salvar(user);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String login(){
        return "logins";
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

    @GetMapping("/editarLoja")
    public ModelAndView editarLoja(@RequestParam Integer usuarioid){
        
        ModelAndView mv = new ModelAndView("lojaEdit");

        Usuario user = us.getUserById(usuarioid);
        mv.addObject("user", user);

        return mv;
    }

    @GetMapping("/busca")
    public String busca(){
        return "tiposBebida";
    }

    @PostMapping("/busca")
    public ModelAndView lojas(@RequestParam (value = "bebida", required = false) String bebida){
        ModelAndView mv = new ModelAndView("lojas");
        List<Usuario> lojasbebidas = new ArrayList<Usuario>();

        mv.addObject("bebida", bebida);

        if(bebida.equals("Cerveja")){
            
            lojasbebidas = us.getUsersByCerveja();
            mv.addObject("lojasbebidas", lojasbebidas);
        }
        //lojasbebidas = us.getUsersByCerveja("Cerveja");
        //mv.addObject("lojasbebidas", lojasbebidas);
       // bebida = "Cerveja";
        else if(bebida.equals("Vodka")){
            
            lojasbebidas = us.getUsersByVodka();
            mv.addObject("lojasbebidas", lojasbebidas);
        }
        else if(bebida.equals("Whiskey")){
            
            lojasbebidas = us.getUsersByWhiskey();
            mv.addObject("lojasbebidas", lojasbebidas);
        }
        else if(bebida.equals("Vinho")){
            
            lojasbebidas = us.getUsersByVinho();
            mv.addObject("lojasbebidas", lojasbebidas);
        }
        else if(bebida.equals("Licor")){
            
            lojasbebidas = us.getUsersByLicor();
            mv.addObject("lojasbebidas", lojasbebidas);
        }
        
        return mv;
    }
}