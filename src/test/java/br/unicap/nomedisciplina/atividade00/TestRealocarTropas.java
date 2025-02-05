package br.unicap.nomedisciplina.atividade00;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestRealocarTropas {
    
    private Jogo jogo;
    private Jogador atacante;
    private Jogador defensor;
    private Jogador outroJogador;
    private boolean jogoEncerrado;
    private boolean jogoContinuado;

    @BeforeEach
    public void setUp() {
        // Configuração inicial
        defensor = new Jogador("Defensor", null, null);
        atacante = new Jogador("Atacante", new Objetivo(Objetivo.Tipo.ELIMINACAO, defensor), null);
        outroJogador = new Jogador("OutroJogador", new Objetivo(Objetivo.Tipo.ELIMINACAO, defensor), new Objetivo(Objetivo.Tipo.ELIMINACAO, atacante));

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(atacante);
        jogadores.add(defensor);
        jogadores.add(outroJogador);

        jogo = new Jogo(jogadores) {
            @Override
            public void encerrarJogo(Jogador jogadorVencedor) {
                jogoEncerrado = true;
            }

            @Override
            public void continuarJogo() {
                jogoContinuado = true;
            }
        };

        jogoEncerrado = false;
        jogoContinuado = false;
    }

    @Test
    public void testRealocarTropas() {
        Territorio origem = new Territorio("Origem", 10);
        Territorio destino = new Territorio("Destino", 5);

        RealocarTropas.realocarTropas(origem, destino, 3);

        assertEquals(8, destino.getExercitos(), "O território de destino deveria ter 8 exércitos");
        assertEquals(7, origem.getExercitos(), "O território de origem deveria ter 7 exércitos");
    }

    @Test
    public void testRealocarTropasNaoSuficientes() {
        Territorio origem = new Territorio("Origem", 2);
        Territorio destino = new Territorio("Destino", 5);

        RealocarTropas.realocarTropas(origem, destino, 3);

        assertEquals(5, destino.getExercitos(), "O território de destino deveria ter 5 exércitos");
        assertEquals(2, origem.getExercitos(), "O território de origem deveria ter 2 exércitos");
    }

    @Test
    public void testRealocarTropasMantendoUmaTropa() {
        Territorio origem = new Territorio("Origem", 5);
        Territorio destino = new Territorio("Destino", 5);

        RealocarTropas.realocarTropas(origem, destino, 4);

        assertEquals(9, destino.getExercitos(), "O território de destino deveria ter 9 exércitos");
        assertEquals(1, origem.getExercitos(), "O território de origem deveria ter 1 exército");
    }
}