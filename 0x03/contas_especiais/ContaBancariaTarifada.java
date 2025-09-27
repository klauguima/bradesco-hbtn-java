import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {

    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        // tarifa por transação: R$ 0,10
        super.sacar(0.10);
        quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        // tarifa por transação: R$ 0,10
        super.sacar(0.10);
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
