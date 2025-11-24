package br.feevale.controller;

import java.util.ArrayList;
import java.util.List;

import br.feevale.model.ProdutoEnergetico;

public class CardapioEnergeticos {

    private List<ProdutoEnergetico> produtos = new ArrayList<>();

    public CardapioEnergeticos() {
        // Produtos iniciais
        produtos.add(new ProdutoEnergetico("Red Bull Energy Drink", 9.90, 0, null, 0, null));
        produtos.add(new ProdutoEnergetico("Monster Green", 8.50, 0, null, 0, null));
        produtos.add(new ProdutoEnergetico("Monster Mango Loco", 10.00, 0, null, 0, null));
        produtos.add(new ProdutoEnergetico("Vibe Energy", 5.99, 0, null, 0, null));
        produtos.add(new ProdutoEnergetico("Full Energy", 6.49, 0, null, 0, null));
    }

    public void adicionarProduto(ProdutoEnergetico p) {
        produtos.add(p);
    }

    public List<ProdutoEnergetico> getProdutos() {
        return produtos;
    }
}
