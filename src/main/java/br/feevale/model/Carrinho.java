package br.feevale.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static List<ItemCarrinho> itens = new ArrayList<>();

    public static void adicionar(ProdutoEnergetico p) {
        // Verifica se o produto já está no carrinho
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getNome().equals(p.getNome())) {
                item.incrementar();
                return;
            }
        }
        // Se não encontrar, adiciona novo item com quantidade 1
        itens.add(new ItemCarrinho(p, 1));
    }

    public static List<ItemCarrinho> getItens() {
        return itens;
    }

    public static void removerItem(ItemCarrinho item) {
        itens.remove(item);
    }

    public static void limpar() {
        itens.clear();
    }
}
