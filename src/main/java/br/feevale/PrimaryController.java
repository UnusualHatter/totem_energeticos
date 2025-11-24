package br.feevale;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import br.feevale.model.CardapioEnergeticos;
import br.feevale.model.Carrinho;
import br.feevale.model.ProdutoEnergetico;

public class PrimaryController {

    @FXML
    private GridPane gridProdutos;

    private CardapioEnergeticos cardapio = new CardapioEnergeticos();

    @FXML
    private ListView<ProdutoEnergetico> listaProdutos;

    @FXML
    public void initialize() {

        // === PRODUTOS DO CATÁLOGO (preenchidos no carregamento da tela) ===
        cardapio.adicionarProduto(new ProdutoEnergetico("Red Bull", 11.90, 250, "Red Bull", 10, "Tradicional"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Green", 9.90, 473, "Monster", 15, "Energy"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Mango Loco", 12.50, 473, "Monster", 12, "Mango"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Fusion", 8.50, 250, "Ambev", 20, "Original"));

        int col = 0;
        int row = 0;

        // === CRIA OS BOTÕES DINÂMICOS PARA CADA PRODUTO ===
        for (ProdutoEnergetico p : cardapio.getProdutos()) {
            listaProdutos.getItems().add(p);
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void adicionaCarrinho(MouseEvent click) {
        Carrinho.adicionar(listaProdutos.getSelectionModel().getSelectedItem());
    }
}
