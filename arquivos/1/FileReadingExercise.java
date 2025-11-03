import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExercise {

    public static void main(String[] args) {
        String fileName = "exemplo.txt";
        lerArquivo(fileName);
    }

    public static void lerArquivo (String fileName) {
        System.out.println("Conteúdo do arquivo '" + fileName + "':\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            System.out.println("");
            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());

        }
    }
}
