package br.unicap.nomedisciplina.atividade00;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogoInicializacao {
    private List<Jogador> jogadores;
    private List<Territorio> territorios;
    private List<Objetivo> objetivos;

    public JogoInicializacao(List<Jogador> jogadores, List<Territorio> territorios, List<Objetivo> objetivos) {
        this.jogadores = new ArrayList<>(jogadores);
        this.territorios = new ArrayList<>(territorios);
        this.objetivos = new ArrayList<>(objetivos);
        inicializarJogo();
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    private void inicializarJogo() {
        distribuirObjetivos();
        distribuirTerritorios();
    }

    private void distribuirObjetivos() {
        Collections.shuffle(objetivos);
        for (Jogador jogador : jogadores) {
            if (!objetivos.isEmpty()) {
                jogador.setObjetivo(objetivos.remove(0));
            }
        }
    }

    private void distribuirTerritorios() {
        Collections.shuffle(territorios);
        int numJogadores = jogadores.size();
        for (int i = 0; i < territorios.size(); i++) {
            Territorio territorio = territorios.get(i);
            Jogador jogador = jogadores.get(i % numJogadores);
            jogador.adicionarTerritorio(territorio);
            territorio.setExercitos(1); // Cada território começa com 1 exército
        }
    }
}
