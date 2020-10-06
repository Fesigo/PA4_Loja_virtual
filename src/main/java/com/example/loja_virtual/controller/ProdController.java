package com.example.loja_virtual.controller;

import com.example.loja_virtual.model.Produto;
import com.example.loja_virtual.service.ProdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdController {
    
    @Autowired
    private ProdService servico;

    @GetMapping("/produtos")
    public ModelAndView getProdutos(){
        ModelAndView mv = new ModelAndView("produtosTemplate");
        mv.addObject("produtos", servico.getProdutos());

        return mv;
    }

    @PostMapping("/salvarProduto")
    public String salvar(@ModelAttribute Produto produto){
        servico.salvar(produto);

        return "redirect:/produtos";
    }
}