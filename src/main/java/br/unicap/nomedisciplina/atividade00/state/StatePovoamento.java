package br.unicap.nomedisciplina.atividade00.state;

import br.unicap.nomedisciplina.atividade00.Jogador;
import br.unicap.nomedisciplina.atividade00.Jogo;
import br.unicap.nomedisciplina.atividade00.Territorio;

public class StatePovoamento implements State {
    private Jogo jogo;

    public StatePovoamento(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void realizarJogada(Jogador jogador, Territorio origem, Territorio destino) {
        throw new IllegalArgumentException("Nao pode realizar jogada no estado de povoamento!");
    }

    @Override
    public void povoarTerritorio(Jogador jogador, Territorio territorio, int quantidade) {
        // Verifica se pode povoar o território
        jogo.povoarTerritorioInterno(jogador, territorio, quantidade);
    }
}
