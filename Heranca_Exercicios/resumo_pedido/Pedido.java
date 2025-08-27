import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            double preco = item.getProduto().obterPrecoLiquido();
            totalProdutos += preco * item.getQuantidade();
        }
        double desconto = totalProdutos * (percentualDesconto / 100.0);
        return totalProdutos - desconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            produtos.Produto p = item.getProduto();
            double preco = p.obterPrecoLiquido();
            double totalItem = preco * item.getQuantidade();
            String tipo = (p instanceof produtos.Livro) ? "Livro" : "Dvd";

            System.out.printf(
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, p.getTitulo(), preco, item.getQuantidade(), totalItem
            );

            totalProdutos += totalItem;
        }

        System.out.println("----------------------------");
        double desconto = totalProdutos * (percentualDesconto / 100.0);
        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalProdutos - desconto);
        System.out.println("----------------------------");
    }
}
