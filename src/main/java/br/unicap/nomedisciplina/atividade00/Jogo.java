package br.unicap.nomedisciplina.atividade00;

import br.unicap.nomedisciplina.atividade00.state.*;

import java.util.List;

public class Jogo {
    private List<Jogador> jogadores;
    private Jogador jogadorAtual;
    private State estadoAtual;

    public Jogo(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.jogadorAtual = jogadores.get(0);
        this.estadoAtual = new StateAtaque(this); // Estado inicial é de ataque
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
        System.out.println("Jogador " + jogador.getNome() + " foi eliminado do jogo.");
    }

    public void encerrarJogo(Jogador jogadorVencedor) {
        System.out.println("Jogador " + jogadorVencedor.getNome() + " venceu o jogo ao completar seu objetivo!");
    }

    public void continuarJogo() {
        System.out.println("O jogo continua...");
    }

    public Jogador getJogadorPorTerritorio(Territorio territorio) {
        for (Jogador jogador : jogadores) {
            if (jogador.getTerritorios().contains(territorio)) {
                return jogador;
            }
        }
        return null;
    }

    public void mudarEstado(State novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public void mudarParaEstadoAtaque() {
        this.estadoAtual = new StateAtaque(this);
    }

    public void mudarParaEstadoPovoamento() {
        this.estadoAtual = new StatePovoamento(this);
    }

    public boolean realizarJogada(Jogador jogador, Territorio origem, Territorio destino) {
        if (!jogador.podeRealizarJogada()) {
            return false;
        }

        if (!saoTerritoriosAdjacentes(origem, destino)) {
            return false;
        }

        if (origem.getExercitos() <= 1) {
            return false;
        }

        if (destino.getExercitos() == Integer.MAX_VALUE) {
            return false;
        }

        origem.setExercitos(origem.getExercitos() - 1);
        destino.setExercitos(destino.getExercitos() + 1);

        mudarParaEstadoPovoamento();

        return true;
    }



    public void povoarTerritorio(Jogador jogador, Territorio territorio, int quantidade) {
        estadoAtual.povoarTerritorio(jogador, territorio, quantidade);
    }

    public void povoarTerritorioInterno(Jogador jogador, Territorio territorio, int quantidade) {
        if (jogador.getTerritorios().contains(territorio)) {
            if (quantidade > 0 && quantidade <= 3) {
                territorio.setExercitos(territorio.getExercitos() + quantidade);
            } else {
                throw new IllegalArgumentException("Numero invalido!");
            }
        } else {
            System.out.println("O jogador nao possui este território.");
        }
    }

    public State getEstadoAtual() {
        return estadoAtual;
    }

    private boolean saoTerritoriosAdjacentes(Territorio origem, Territorio destino) {
        return origem.getAdjacentes().contains(destino);
    }
}
