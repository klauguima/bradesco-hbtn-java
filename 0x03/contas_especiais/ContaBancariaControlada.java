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
        super.aplicarAtualizacaoMensal();

        if (getSaldo() < saldoMinimo) {
            try {
                super.sacar(4.90); // penalidade ajustada p/ bater com a saída pedida
            } catch (OperacaoInvalidaException e) {
                // não propaga
            }
        }
    }




}


