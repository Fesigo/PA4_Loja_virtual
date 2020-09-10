package com.example.loja_virtual.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.loja_virtual.model.Produto;

import org.springframework.stereotype.Component;

@Component
public class ProdRepository {
    
    private List<Produto> produtos;

    /* alguns objetos para teste
    @PostConstruct
    public void criarProdutos(){
        Produto p1 = new Produto();
        Produto p2 = new Produto();

        p1.setCodigo(1);
        p1.setNome("Vinho");
        p1.setDescricao("bem bão");
        p1.setMarca("chateau");
        p1.setEstoque(5);
        p1.setValidade("15-08-2030");
        p1.setOrigem("Italia");
        p1.setPreco(3000.00);

        p2.setCodigo(2);
        p2.setNome("Whiskey");
        p2.setDescricao("esse é brabo");
        p2.setMarca("Jack Daniels");
        p2.setEstoque(3);
        p2.setValidade("11-12-1950");
        p2.setOrigem("Escócia");
        p2.setPreco(200.00);

        produtos = new ArrayList<Produto>();
        produtos.add(p1);
        produtos.add(p2);
    }*/

    public List<Produto> getAllProdutos(){
        return produtos;
    }

    public Produto getProdutoByCodigo(int codigo){
        for(Produto aux : produtos){
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }

    public Produto save(Produto produto)
    {
        produto.setCodigo(produtos.size() + 1);
        produtos.add(produto);
        return produto;
    }
}
