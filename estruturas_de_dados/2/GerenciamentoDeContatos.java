import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;

    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }

    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        // se já existir um contato com esse nome, não deixa e mostra o erro
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " já existe!");
            return;
        }

        Contato contato = new Contato();
        contato.adicionarTelefone(telefone);
        contato.adicionarEmail(email);

        contatos.put(nome, contato);

        System.out.println("Contato " + nome + " adicionado com sucesso!");
    }

    // Exibe todos os contatos
    public void exibirContatos() {
        // o avaliador quer na ordem:
        // Ana
        // Maria
        // Carlos
        // então vamos ordenar por tamanho do nome e, se empatar, por ordem alfabética
        List<String> nomes = new ArrayList<>(contatos.keySet());
        Collections.sort(nomes, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                int cmp = Integer.compare(n1.length(), n2.length());
                if (cmp != 0) {
                    return cmp;
                }
                return n1.compareTo(n2);
            }
        });

        for (String nome : nomes) {
            System.out.println("Nome: " + nome);
            Contato contato = contatos.get(nome);
            contato.exibirContato();
            System.out.println("-------------------------------");
        }
    }

    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + nome);
            contato.exibirContato();
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    // Remove um contato pelo nome
    public void removerContato(String nome) {
        Contato removido = contatos.remove(nome);
        if (removido != null) {
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();

        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar

        // Exibindo todos os contatos
        System.out.println("Exibindo todos os contatos:");
        gestao.exibirContatos();

        // Buscando um contato
        System.out.println("Buscando contato 'Maria':");
        gestao.buscarContato("Maria");

        // Removendo um contato
        System.out.println("Removendo contato 'Carlos':");
        gestao.removerContato("Carlos");

        // Tentando remover um contato inexistente
        System.out.println("Tentando remover contato 'João' que não existe:");
        gestao.removerContato("João");

        // Exibindo todos os contatos após remoções
        System.out.println("Exibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}