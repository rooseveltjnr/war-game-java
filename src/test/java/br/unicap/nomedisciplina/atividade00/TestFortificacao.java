package br.unicap.nomedisciplina.atividade00;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestFortificacao {
    @Test
    public void testPossuiContinente() {
        Jogador jogador = new Jogador("Jogador 1", null, null);
        List<Territorio> territorios = new ArrayList<>();
        territorios.add(new Territorio("Venezuela", 1));
        territorios.add(new Territorio("Peru", 1));
        territorios.add(new Territorio("Argentina", 1));
        territorios.add(new Territorio("Brasil", 1));
        jogador.getTerritorios().addAll(territorios);

        boolean possuiContinente = Fortificacao.possuiContinente(jogador, "América do Sul");

        assertTrue(possuiContinente, "O jogador deveria possuir a América do Sul.");
    }
    @Test
    public void testNaoPossuiContinente() {
        Jogador jogador = new Jogador("Jogador 1", null, null);
        List<Territorio> territorios = new ArrayList<>();
        territorios.add(new Territorio("Venezuela", 1));
        territorios.add(new Territorio("Peru", 1));
        territorios.add(new Territorio("Argentina", 1));
        territorios.add(new Territorio("Brasil", 1));
        jogador.getTerritorios().addAll(territorios);

        boolean possuiContinente = Fortificacao.possuiContinente(jogador, "América do Norte");
        assertFalse(possuiContinente, "O jogador não deveria possuir a América do Norte.");
    }

    @Test
    void testAlocarTropas() {
        Territorio origem = new Territorio("Brasil", 5);
        Territorio destino = new Territorio("Argentina", 0);

        Fortificacao.alocarTropas(origem, destino, 2);

        assertEquals(3, origem.getExercitos(), "O território de origem (Brasil) deveria ter 3 tropas.");
        assertEquals(2, destino.getExercitos(), "O território de destino (Argentina) deveria ter 2 tropas.");
    }
    @Test
    void testAlocarTropasQuantidadesDiferentes() {
        Territorio origem = new Territorio("Territorio Brasil", 5);
        Territorio destino = new Territorio("Territorio Argentina", 0);

        Fortificacao.alocarTropas(origem, destino, 1);
        assertEquals(4, origem.getExercitos(), "O território de origem (Brasil) deveria ter 4 tropas.");
        assertEquals(1, destino.getExercitos(), "O território de destino (Argentina) deveria ter 1 tropa.");

        Fortificacao.alocarTropas(origem, destino, 3);
        assertEquals(1, origem.getExercitos(), "O território de origem (Brasil) deveria ter 1 tropa.");
        assertEquals(4, destino.getExercitos(), "O território de destino (Argentina) deveria ter 4 tropas.");
    }
    @Test
    void testCalcularExercitosIniciais() {
        Jogador jogador = new Jogador("Jogador 1", Jogador.ID.BRANCO);
        List<Territorio> territorios = new ArrayList<>();
        territorios.add(new Territorio("Venezuela", 1));
        territorios.add(new Territorio("Peru", 1));
        territorios.add(new Territorio("Argentina", 1));
        territorios.add(new Territorio("Brasil", 1));
        territorios.add(new Territorio("Alaska", 1));
        territorios.add(new Territorio("Alberta", 1));
        territorios.add(new Territorio("Oeste dos EUA", 1));
        territorios.add(new Territorio("Centro dos EUA", 1));
        territorios.add(new Territorio("Leste dos EUA", 1));
        territorios.add(new Territorio("Groelândia", 1));
        territorios.add(new Territorio("Ontario", 1));
        territorios.add(new Territorio("Quebec", 1));
        jogador.adicionarTerritorio(territorios);

        int exercitosIniciais = Fortificacao.calcularExercitosIniciais(jogador);
        assertEquals(12, exercitosIniciais, "O jogador deveria receber 12 exércitos iniciais.");
    }
}