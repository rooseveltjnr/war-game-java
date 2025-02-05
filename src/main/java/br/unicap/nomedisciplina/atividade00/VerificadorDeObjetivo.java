package br.unicap.nomedisciplina.atividade00;

public class VerificadorDeObjetivo {

    public static void verificarObjetivoEliminacao(Jogo jogo, Jogador atacante, Jogador defensor) {
        if (defensor.getTerritorios().isEmpty()) {
            jogo.removerJogador(defensor);

            // Verifica se o jogador ATQ alcançou seu objetivo de eliminação
            if (atacante.getObjetivo().getTipo() == Objetivo.Tipo.ELIMINACAO &&
                atacante.getObjetivo().getJogadorAlvo().equals(defensor)) {
                jogo.encerrarJogo(atacante);
            } else {
                // Verifica se outro o jogador eliminado era de outro de player
                for (Jogador jogador : jogo.getJogadores()) {
                    if (jogador.getObjetivo().getTipo() == Objetivo.Tipo.ELIMINACAO &&
                        jogador.getObjetivo().getJogadorAlvo().equals(defensor)) {
                        jogador.setObjetivo(jogador.getObjetivoSecundario());
                    }
                }
                jogo.continuarJogo();
            }
        }
    }
}
