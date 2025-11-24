package br.feevale;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import br.feevale.model.CardapioEnergeticos;
import br.feevale.model.Carrinho;
import br.feevale.model.ProdutoEnergetico;

public class PrimaryController {

    @FXML
    private GridPane gridProdutos;

    private CardapioEnergeticos cardapio = new CardapioEnergeticos();

    @FXML
    public void initialize() {

        // Produtos pré-cadastrados
        cardapio.adicionarProduto(new ProdutoEnergetico("Red Bull", 11.90, 250, "Red Bull", 10, "Tradicional"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Green", 9.90, 473, "Monster", 15, "Energy"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Mango Loco", 12.50, 473, "Monster", 12, "Mango"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Fusion", 8.50, 250, "Ambev", 20, "Original"));

        int col = 0, row = 0;

        for (ProdutoEnergetico p : cardapio.getProdutos()) {

            Button btn = new Button(p.getNome() + " - R$ " + p.getPreco());
            btn.setPrefWidth(200);

            btn.setOnAction(e -> {
                Carrinho.adicionar(p);
                System.out.println("Adicionado: " + p.getNome());
            });

            gridProdutos.add(btn, col, row);

            col++;
            if (col == 2) {
                col = 0;
                row++;
            }
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
