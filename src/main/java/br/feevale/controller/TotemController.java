package br.feevale.controller;

import br.feevale.model.CardapioEnergeticos;
import br.feevale.model.ProdutoEnergetico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class TotemController {

    public static ProdutoEnergetico[] carrinho;

    @FXML
    private ListView<List<ProdutoEnergetico>> listaProdutos;

    @FXML
    private Button btnAdicionar, btnPagamento;

    private CardapioEnergeticos cardapio = new CardapioEnergeticos();

    @FXML
    public void initialize() {

        // Adicionar produtos
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Mango Loco", 12.50, 473, "Monster", 10, "Mango"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Red Bull Tradicional", 10.00, 250, "Red Bull", 15, "Tradicional"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Vibe Citrus", 6.99, 269, "Vibe", 20, "Citrus"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Fusion Maçã Verde", 8.99, 250, "Fusion", 8, "Maçã Verde"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Monster Ultra", 13.50, 473, "Monster", 10, "Ultra"));
        cardapio.adicionarProduto(new ProdutoEnergetico("Red Bull Tropical", 11.00, 250, "Red Bull", 14, "Tropical"));

        // Agrupar produtos em pares
        List<List<ProdutoEnergetico>> linhas = new ArrayList<>();
        List<ProdutoEnergetico> temp = new ArrayList<>();

        for (ProdutoEnergetico p : cardapio.getProdutos()) {
            temp.add(p);
            if (temp.size() == 2) {
                linhas.add(new ArrayList<>(temp));
                temp.clear();
            }
        }

        if (!temp.isEmpty()) {
            linhas.add(new ArrayList<>(temp));
        }

        listaProdutos.getItems().addAll(linhas);

        // Renderizador customizado
        listaProdutos.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(List<ProdutoEnergetico> linha, boolean empty) {
                super.updateItem(linha, empty);

                if (empty || linha == null) {
                    setGraphic(null);
                    return;
                }

                HBox hbox = new HBox(20);

                for (ProdutoEnergetico p : linha) {
                    VBox card = new VBox(5);
                    card.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10;");

                    Button btn = new Button(p.getNome());
                    btn.setPrefWidth(150);

                    btn.setOnAction(e -> {
                        System.out.println("Adicionado: " + p.getNome());
                        // aqui você adiciona ao pedido
                    });

                    card.getChildren().addAll(btn);
                    hbox.getChildren().add(card);
                }

                setGraphic(hbox);
            }
        });
    }
}
