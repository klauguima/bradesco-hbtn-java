package provedores;

public interface ProvedorFrete {
    Frete calcularFrete(double pesoEmGramas, double valorTotalPedido);
    TipoProvedorFrete obterTipoProvedorFrete();
}
