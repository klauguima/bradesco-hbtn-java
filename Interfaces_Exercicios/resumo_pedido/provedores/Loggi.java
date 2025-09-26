package provedores;

public class Loggi implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double pesoEmGramas, double valorTotalPedido) {
        double pesoKg = pesoEmGramas / 1000.0;
        double percentual = (pesoKg > 5.0) ? 0.12 : 0.04;
        double valor = valorTotalPedido * percentual;
        return new Frete(valor, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}
