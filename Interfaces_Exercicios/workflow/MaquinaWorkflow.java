import atividades.Atividade;

public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        if (workflow == null) {
            throw new IllegalArgumentException("Workflow não pode ser nulo");
        }
        for (Atividade atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }
}
