package org.example.TerceiraAtividade;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Faturamento {
    public static void main(String[] args) throws IOException {
        // Carregar dados do faturamento mensal em JSON
        JSONObject jsonObject = new JSONObject(new FileReader("faturamento_mensal.json"));

        // Inicializar variáveis
        double menorFaturamento = Double.POSITIVE_INFINITY;
        double maiorFaturamento = Double.NEGATIVE_INFINITY;
        int diasAcimaMedia = 0;
        double somaFaturamento = 0;
        int diasContados = 0;

        // Iterar sobre os dias do mês
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String dia = keys.next();
            double faturamento = jsonObject.getDouble(dia);

            if (faturamento > 0) {  // Ignorar dias sem faturamento
                somaFaturamento += faturamento;
                diasContados++;

                if (faturamento < menorFaturamento) {
                    menorFaturamento = faturamento;
                }

                if (faturamento > maiorFaturamento) {
                    maiorFaturamento = faturamento;
                }
            }
        }

        // Calcular média mensal
        double mediaMensal = somaFaturamento / diasContados;

        // Contar dias com faturamento acima da média mensal
        keys = jsonObject.keys();
        while (keys.hasNext()) {
            String dia = keys.next();
            double faturamento = jsonObject.getDouble(dia);

            if (faturamento > mediaMensal) {
                diasAcimaMedia++;
            }
        }

        // Imprimir resultados
        System.out.println("Menor valor de faturamento ocorrido em um dia do mês: " + menorFaturamento);
        System.out.println("Maior valor de faturamento ocorrido em um dia do mês: " + maiorFaturamento);
        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + diasAcimaMedia);
    }
}