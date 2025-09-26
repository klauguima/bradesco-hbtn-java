import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import atividades.Atividade;

public class Workflow {
    private final List<Atividade> atividades = new ArrayList<>();

    public void registrarAtividade(Atividade atividade) {
        if (atividade == null) {
            throw new IllegalArgumentException("Atividade não pode ser nula");
        }
        atividades.add(atividade);
    }

    public List<Atividade> getAtividades() {
        return Collections.unmodifiableList(atividades);
    }
}
