package br.unicap.nomedisciplina.atividade00;

import java.util.Random;

public class Dados {
    private static final Random random = new Random();

    public static int[] rolarDados(int quantidadeDados) {
        int[] resultados = new int[quantidadeDados];
        for (int i = 0; i < quantidadeDados; i++) {
            resultados[i] = random.nextInt(6) + 1; // Gerando números aleatórios de 1 a 6 (faces de um dado comum)
        }
        return resultados;
    }
}
