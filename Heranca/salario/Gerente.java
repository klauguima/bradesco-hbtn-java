public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusBase = getSalarioFixo() * 0.20;
            double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            double bonusDiferenca = diferenca * 0.01;
            return bonusBase + bonusDiferenca;
        }
        return 0.0;
    }

    @Override
    public double calcularSalarioTotal(Departamento departamento) {
        return getSalarioFixo() + calcularBonus(departamento);
    }
}
