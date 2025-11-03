import java.util.Scanner;

public class ArrayExercicio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

       System.out.println("\nConteúdo do array:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println("\nSoma de todos os números: " + soma);
        System.out.println("Maior número no array: " + maiorNumero);
        scanner.close();
    }
}