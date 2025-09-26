package provedores;

public class JadLog implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double pesoEmGramas, double valorTotalPedido) {
        double pesoKg = pesoEmGramas / 1000.0;
        double percentual = (pesoKg > 2.0) ? 0.07 : 0.045;
        double valor = valorTotalPedido * percentual;
        return new Frete(valor, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}
