package org.example.PrimeiraAtividade;
public class Soma {
    public static void main(String[] args) {
        int indice = 13; // Define o limite da soma
        int soma = 0;    // Inicializa a soma
        int k = 0;       // Inicializa o contador

        // Loop para somar os números de 1 até o índice
        while (k < indice) {
            k++;          // Incrementa o contador
            soma += k;   // Adiciona o valor de k à soma
        }

        // Imprime o resultado da soma
        System.out.println("A soma dos números de 1 a " + indice + " é: " + soma);
    }
}
