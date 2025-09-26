package provedores;

public class Frete {
    private final double valor;
    private final TipoProvedorFrete tipoProvedorFrete;

    public Frete(double valor, TipoProvedorFrete tipoProvedorFrete) {
        this.valor = valor;
        this.tipoProvedorFrete = tipoProvedorFrete;
    }

    public double getValor() {
        return valor;
    }

    public TipoProvedorFrete getTipoProvedorFrete() {
        return tipoProvedorFrete;
    }
}
