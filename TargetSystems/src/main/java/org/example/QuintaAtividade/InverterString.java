package org.example.QuintaAtividade;
import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String input = scanner.nextLine();

        String inverted = inverter(input);
        System.out.println("String invertida: " + inverted);
    }

    public static String inverter(String str) {
        char[] caracteres = str.toCharArray();
        String resultado = "";
        for (int i = caracteres.length - 1; i >= 0; i--) {
            resultado += caracteres[i];
        }
        return resultado;
    }
}
