public class ItemPedido {
    private produtos.Produto produto;
    private int quantidade;

    public ItemPedido(produtos.Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public produtos.Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
