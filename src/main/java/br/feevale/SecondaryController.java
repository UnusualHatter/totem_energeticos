package br.feevale;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import br.feevale.model.Carrinho;
import br.feevale.model.ProdutoEnergetico;

public class SecondaryController {

    @FXML
    private ListView<String> listaCarrinho;

    @FXML
    public void initialize() {
        for (ProdutoEnergetico p : Carrinho.getItens()) {
            listaCarrinho.getItems().add(p.toString());
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
