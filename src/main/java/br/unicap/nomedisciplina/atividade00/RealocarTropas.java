package br.unicap.nomedisciplina.atividade00;

import java.util.List;

public class RealocarTropas{

    public static void realocarTropas(Territorio origem, Territorio destino, int quantidade) {
        if (origem.getExercitos() <= quantidade) {
            System.out.println("Não há exércitos suficientes no território de origem para realocar.");
            return;
        }

        if (origem.getExercitos() - quantidade < 1) {
            System.out.println("Deve permanecer pelo menos uma tropa no território de origem.");
            return;
        }

        origem.setExercitos(origem.getExercitos() - quantidade);
        destino.setExercitos(destino.getExercitos() + quantidade);

        System.out.println("Realocados " + quantidade + " exércitos do território " + origem.getNome() + " para o território " + destino.getNome());
    }

    public static void verificarObjetivoEliminacao(Jogo jogo, Jogador atacante, Jogador defensor) {
        if (defensor.getTerritorios().isEmpty()) {
            // Remover o jogador defensor do jogo
            jogo.removerJogador(defensor);

            // Verificar se o jogador atacante alcançou seu objetivo de eliminação
            if (atacante.getObjetivo().getTipo() == Objetivo.Tipo.ELIMINACAO &&
                atacante.getObjetivo().getJogadorAlvo().equals(defensor)) {
                jogo.encerrarJogo(atacante);
            } else {
                // Verificar se outro jogador tinha o objetivo de eliminar o defensor
                for (Jogador jogador : jogo.getJogadores()) {
                    if (jogador.getObjetivo().getTipo() == Objetivo.Tipo.ELIMINACAO &&
                        jogador.getObjetivo().getJogadorAlvo().equals(defensor)) {
                        jogador.setObjetivo(jogador.getObjetivoSecundario());
                    }
                }
                // Continuar o jogo
                jogo.continuarJogo();
            }
        }
    }
}