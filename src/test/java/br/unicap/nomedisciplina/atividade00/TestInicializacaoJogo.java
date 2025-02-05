package br.unicap.nomedisciplina.atividade00;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestInicializacaoJogo {

    @Test
    public void testJogadoresPossuemUmObjetivo() {
        Objetivo objetivo1 = new Objetivo(Objetivo.Tipo.CONQUISTA);
        Objetivo objetivo2 = new Objetivo(Objetivo.Tipo.ELIMINACAO);
        List<Objetivo> objetivos = new ArrayList<>(Arrays.asList(objetivo1, objetivo2));

        Jogador jogador1 = new Jogador("Jogador 1", null, null);
        Jogador jogador2 = new Jogador("Jogador 2", null, null);
        List<Jogador> jogadores = Arrays.asList(jogador1, jogador2);

        Territorio territorio1 = new Territorio("Território 1", 0);
        Territorio territorio2 = new Territorio("Território 2", 0);
        List<Territorio> territorios = Arrays.asList(territorio1, territorio2);

        JogoInicializacao jogoInicializacao = new JogoInicializacao(jogadores, territorios, objetivos);

        assertNotNull(jogador1.getObjetivo(), "Jogador 1 deve possuir um objetivo");
        assertNotNull(jogador2.getObjetivo(), "Jogador 2 deve possuir um objetivo");

        //System.out.println("Teste de objetivos dos jogadores passou.");
    }

    @Test
    public void testDistribuicaoExercitos() {
        Objetivo objetivo1 = new Objetivo(Objetivo.Tipo.CONQUISTA);
        Objetivo objetivo2 = new Objetivo(Objetivo.Tipo.ELIMINACAO);
        List<Objetivo> objetivos = new ArrayList<>(Arrays.asList(objetivo1, objetivo2));

        Jogador jogador1 = new Jogador("Jogador 1", null, null);
        Jogador jogador2 = new Jogador("Jogador 2", null, null);
        List<Jogador> jogadores = Arrays.asList(jogador1, jogador2);

        Territorio territorio1 = new Territorio("Território 1", 0);
        Territorio territorio2 = new Territorio("Território 2", 0);
        List<Territorio> territorios = Arrays.asList(territorio1, territorio2);

        JogoInicializacao jogoInicializacao = new JogoInicializacao(jogadores, territorios, objetivos);

        for (Territorio territorio : jogoInicializacao.getTerritorios()) {
            assertTrue(territorio.getExercitos() >= 1, "Todos os territórios devem possuir pelo menos 1 exército");
        }

        //System.out.println("Teste de distribuição de exércitos passou.");
    }

    @Test
    public void testJogadoresPossuemTerritorios() {
        Objetivo objetivo1 = new Objetivo(Objetivo.Tipo.CONQUISTA);
        Objetivo objetivo2 = new Objetivo(Objetivo.Tipo.ELIMINACAO);
        List<Objetivo> objetivos = new ArrayList<>(Arrays.asList(objetivo1, objetivo2));

        Jogador jogador1 = new Jogador("Jogador 1", null, null);
        Jogador jogador2 = new Jogador("Jogador 2", null, null);
        List<Jogador> jogadores = Arrays.asList(jogador1, jogador2);

        Territorio territorio1 = new Territorio("Território 1", 0);
        Territorio territorio2 = new Territorio("Território 2", 0);
        List<Territorio> territorios = Arrays.asList(territorio1, territorio2);

        JogoInicializacao jogoInicializacao = new JogoInicializacao(jogadores, territorios, objetivos);

        assertFalse(jogador1.getTerritorios().isEmpty(), "Jogador 1 deve possuir territórios");
        assertFalse(jogador2.getTerritorios().isEmpty(), "Jogador 2 deve possuir territórios");

        //System.out.println("Teste de territórios dos jogadores passou.");
    }
}
