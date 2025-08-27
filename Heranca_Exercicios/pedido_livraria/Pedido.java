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
}
