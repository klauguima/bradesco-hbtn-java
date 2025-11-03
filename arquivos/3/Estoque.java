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

                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException | NumberFormatException e) {

        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {

        }
    }


    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarProximoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();

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
        }

    }


    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }


    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                break;
            }
        }

    }
}