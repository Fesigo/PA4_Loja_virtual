package com.example.loja_virtual.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.loja_virtual.model.Loja;
import com.example.loja_virtual.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LojaController {

    @Autowired
    private LojaService us;

    @GetMapping("/users")
    public ModelAndView getUsers(){

        ModelAndView mv = new ModelAndView("cadastroloja");
        mv.addObject("users", us.getUsers());

        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Loja user){
        us.salvar(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @PostMapping("/login")
    public ModelAndView loginform(@ModelAttribute Loja user){
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

        Loja user = us.getUserById(usuarioid);
        mv.addObject("user", user);

        return mv;
    }

    @GetMapping("/busca")
    public String busca(){
        return "tiposBebida";
    }

    @PostMapping("/busca")
    public ModelAndView lojas(@RequestParam (value = "bebida", required = false) String bebida){
        ModelAndView mv = new ModelAndView("lojabebidas");
        List<Loja> lojasbebidas = new ArrayList<Loja>();

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