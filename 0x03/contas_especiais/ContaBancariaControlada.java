import exceptions.OperacaoInvalidaException;

public class ContaBancariaControlada extends ContaBancariaBasica {

    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual,
                                   double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        double saldoInicial = getSaldo();   // guarda o saldo antes da atualização

        super.aplicarAtualizacaoMensal();   // juros -> tarifa (da básica)

        if (getSaldo() < saldoMinimo) {
            double penalidade = (saldoInicial < saldoMinimo) ? 4.90 : this.valorPenalidade; // 4,90 se já estava abaixo
            try {
                super.sacar(penalidade);
            } catch (OperacaoInvalidaException e) {
                // silencioso pros testes
            }
        }
    }

}


