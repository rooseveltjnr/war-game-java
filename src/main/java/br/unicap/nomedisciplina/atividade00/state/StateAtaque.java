package br.unicap.nomedisciplina.atividade00.state;

import br.unicap.nomedisciplina.atividade00.Jogador;
import br.unicap.nomedisciplina.atividade00.Jogo;
import br.unicap.nomedisciplina.atividade00.Territorio;

public class StateAtaque implements State {
    private Jogo jogo;

    public StateAtaque(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void realizarJogada(Jogador jogador, Territorio origem, Territorio destino) {
        // Verifica se pode realizar a jogada
        jogo.realizarJogada(jogador, origem, destino);
    }

    @Override
    public void povoarTerritorio(Jogador jogador, Territorio territorio, int quantidade) {
        throw new IllegalArgumentException("Nao pode povoar territorio no estado de ataque!");
    }
}
