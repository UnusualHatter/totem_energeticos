package br.feevale;

import java.io.IOException;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import br.feevale.model.Carrinho;
import br.feevale.model.Pedido;
import br.feevale.model.ItemPedido;
import br.feevale.model.ItemCarrinho;

public class TertiaryController {

    @FXML
    private Label lblNumeroPedido;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblMetodoPagamento;

    @FXML
    private Button btnDinheiro;

    @FXML
    private Button btnCartaoCredito;

    @FXML
    private Button btnCartaoDebito;

    @FXML
    private Button btnPix;

    @FXML
    private Button btnFinalizarPedido;

    private Pedido pedidoAtual;
    private String metodoPagamentoSelecionado = "";

    @FXML
    public void initialize() {
        int numeroPedido = gerarNumeroPedido();
        lblNumeroPedido.setText(String.format("%05d", numeroPedido));

        pedidoAtual = new Pedido(numeroPedido);

        for (ItemCarrinho item : Carrinho.getItens()) {
            ItemPedido itemPedido = new ItemPedido(item.getProduto(), item.getQuantidade());
            pedidoAtual.adicionarItem(itemPedido);
        }

        double totalComDesconto = 0.0;
        for (ItemCarrinho item : Carrinho.getItens()) {
            totalComDesconto += item.getTotalComDesconto();
        }
        pedidoAtual.setTotal(totalComDesconto);
        lblValorTotal.setText("Total: R$ " + String.format("%.2f", totalComDesconto));

        btnDinheiro.setOnAction(event -> selecionarMetodoPagamento("Dinheiro", btnDinheiro));
        btnCartaoCredito.setOnAction(event -> selecionarMetodoPagamento("Cartão de Crédito", btnCartaoCredito));
        btnCartaoDebito.setOnAction(event -> selecionarMetodoPagamento("Cartão de Débito", btnCartaoDebito));
        btnPix.setOnAction(event -> selecionarMetodoPagamento("PIX", btnPix));

        btnFinalizarPedido.setOnAction(event -> {
            if (!metodoPagamentoSelecionado.isEmpty()) {
                finalizarPedido();
            } else {
                lblMetodoPagamento.setText("Método: Selecione um método!");
            }
        });
    }

    private int gerarNumeroPedido() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    private void selecionarMetodoPagamento(String metodo, Button botao) {
        btnDinheiro.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        btnCartaoCredito.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        btnCartaoDebito.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        btnPix.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");

        botao.setStyle("-fx-font-size: 16px; -fx-padding: 10px; -fx-background-color: #4CAF50; -fx-text-fill: white;");

        metodoPagamentoSelecionado = metodo;
        lblMetodoPagamento.setText("Método: " + metodo);
    }

    private void finalizarPedido() {
        // Aqui você pode adicionar lógica para salvar o pedido, processar pagamento, etc.
        System.out.println("Pedido #" + String.format("%05d", pedidoAtual.getNumero()) + " finalizado com " + metodoPagamentoSelecionado);
        System.out.println("Total: R$ " + String.format("%.2f", pedidoAtual.getTotal()));

        // Limpa o carrinho após finalizar
        Carrinho.limpar();

        // Volta para a tela principal
        try {
            App.setRoot("primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
