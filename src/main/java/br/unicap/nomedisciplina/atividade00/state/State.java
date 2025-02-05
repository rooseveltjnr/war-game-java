package br.unicap.nomedisciplina.atividade00.state;

import br.unicap.nomedisciplina.atividade00.Jogador;
import br.unicap.nomedisciplina.atividade00.Territorio;

public interface State {
    void realizarJogada(Jogador jogador, Territorio origem, Territorio destino);
    void povoarTerritorio(Jogador jogador, Territorio territorio, int quantidade);
}
