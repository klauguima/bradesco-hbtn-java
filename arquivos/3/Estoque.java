import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;
    private String caminhoArquivo;

    public Estoque(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.produtos = new ArrayList<>();
        carregarDoArquivo();
    }


    private void carregarDoArquivo() {
        File arquivo = new File(caminhoArquivo);


        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de estoque: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;


                String[] partes = linha.split(",");

                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int quantidade = Integer.parseInt(partes[2]);
                double preco = Double.parseDouble(partes[3]);

                Produto p = new Produto(id, nome, quantidade, preco);
                produtos.add(p);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de estoque: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro de formatação no arquivo de estoque: " + e.getMessage());
        }
    }


    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo de estoque: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarProximoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();
        System.out.println("Produto adicionado com sucesso. ID gerado: " + novoId);
    }

    private int gerarProximoId() {
        int maior = 0;
        for (Produto p : produtos) {
            if (p.getId() > maior) {
                maior = p.getId();
            }
        }
        return maior + 1;
    }

    public void excluirProduto(int id) {
        boolean removido = false;
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                removido = true;
                break;
            }
        }

        if (removido) {
            salvarNoArquivo();
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("ID | NOME | QTD | PREÇO");
        System.out.println("----------------------------------");
        for (Produto p : produtos) {
            System.out.println(
                    p.getId() + " | " +
                            p.getNome() + " | " +
                            p.getQuantidade() + " | " +
                            String.format("%.2f", p.getPreco())
            );
        }
    }


    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                System.out.println("Quantidade atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }
}
