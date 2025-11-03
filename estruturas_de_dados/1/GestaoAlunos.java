import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private List<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno adicionado: " + nome);
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno " + nome + " removido com sucesso!");
        } else {
            System.out.println("Aluno " + nome + " não encontrado!");
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado -> " + aluno);
                return;
            }
        }
        System.out.println("Aluno " + nome + " não encontrado!");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\nLista de alunos cadastrados:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Pedro", 19);

        gestao.listarAlunos();
        gestao.buscarAluno("Maria");
        gestao.excluirAluno("Pedro");
        gestao.excluirAluno("Carlos");
        gestao.buscarAluno("Carlos");
        gestao.listarAlunos();
    }
}
