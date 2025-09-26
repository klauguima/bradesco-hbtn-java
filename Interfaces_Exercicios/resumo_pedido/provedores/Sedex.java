package provedores;

public class Sedex implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double pesoEmGramas, double valorTotalPedido) {
        double pesoKg = pesoEmGramas / 1000.0;
        double percentual = (pesoKg > 1.0) ? 0.10 : 0.05;
        double valor = valorTotalPedido * percentual;
        return new Frete(valor, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
