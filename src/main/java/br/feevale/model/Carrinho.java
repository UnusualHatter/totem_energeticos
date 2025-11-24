package br.feevale.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static List<ProdutoEnergetico> itens = new ArrayList<>();

    public static void adicionar(ProdutoEnergetico p) {
        itens.add(p);
    }

    public static List<ProdutoEnergetico> getItens() {
        return itens;
    }

    public static void limpar() {
        itens.clear();
    }
}
