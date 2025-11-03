import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String caminhoArquivo = "funcionarios.csv";
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Lê o cabeçalho
            String cabecalho = br.readLine();
            if (cabecalho != null) {
                String[] colunas = cabecalho.split(",");
                System.out.println("Funcionário: " + colunas[0]);
                System.out.println("Idade: " + colunas[1]);
                System.out.println("Departamento: " + colunas[2]);
                System.out.println("Salarial: " + colunas[3]);
                System.out.println("------------------------");
            }

            // Lê as linhas seguintes
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue; // ignora linhas em branco
                String[] dados = linha.split(",");
                System.out.println("Funcionário: " + dados[0]);
                System.out.println("Idade: " + dados[1]);
                System.out.println("Departamento: " + dados[2]);
                System.out.println("Salarial: " + dados[3]);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}