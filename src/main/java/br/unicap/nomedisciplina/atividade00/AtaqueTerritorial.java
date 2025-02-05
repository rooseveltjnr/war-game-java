package br.unicap.nomedisciplina.atividade00;

import java.util.Arrays;

public class AtaqueTerritorial {
    private static final int MAX_EXERCITOS_ATAQUE = 3;
    private static final int MAX_EXERCITOS_DEFESA = 3;

    public static void realizarAtaque(Territorio atacante, Territorio defensor) {
        if (atacante.getExercitos() < 2) {
            System.out.println("O território atacante não tem exércitos suficientes para atacar.");
            return;
        }

        int exercitosAtaque = Math.min(atacante.getExercitos() - 1, MAX_EXERCITOS_ATAQUE);
        int exercitosDefesa = Math.min(defensor.getExercitos(), MAX_EXERCITOS_DEFESA);

        int[] dadosAtaque = Dados.rolarDados(exercitosAtaque);
        int[] dadosDefesa = Dados.rolarDados(exercitosDefesa);

        Arrays.sort(dadosAtaque);
        Arrays.sort(dadosDefesa);

        // Reverter a ordem dos arrays para comparar os maiores valores primeiro
        reverseArray(dadosAtaque);
        reverseArray(dadosDefesa);

        int vitoriasAtaque = 0;
        int vitoriasDefesa = 0;

        for (int i = 0; i < Math.min(exercitosAtaque, exercitosDefesa); i++) {
            if (dadosAtaque[i] > dadosDefesa[i]) {
                vitoriasAtaque++;
            } else {
                vitoriasDefesa++;
            }
        }

        System.out.println("Resultados do ataque:");
        System.out.println("Atacante: " + Arrays.toString(dadosAtaque));
        System.out.println("Defensor: " + Arrays.toString(dadosDefesa));

        if (vitoriasAtaque > 0) {
            defensor.setExercitos(defensor.getExercitos() - vitoriasAtaque);
        }
        if (vitoriasDefesa > 0) {
            atacante.setExercitos(atacante.getExercitos() - vitoriasDefesa);
        }

        System.out.println("Exércitos restantes no território atacante (" + atacante.getNome() + "): " + atacante.getExercitos());
        System.out.println("Exércitos restantes no território defensor (" + defensor.getNome() + "): " + defensor.getExercitos());
    }
        

    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
