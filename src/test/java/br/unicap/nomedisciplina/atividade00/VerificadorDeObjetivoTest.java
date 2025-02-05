package br.unicap.nomedisciplina.atividade00;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VerificadorDeObjetivoTest {

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
        outroJogador = new Jogador("OutroJogador", new Objetivo(Objetivo.Tipo.ELIMINACAO, defensor), null);

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
    public void testAtacanteEliminaDefensorObjetivoCompleto() {
        // Esse teste o jogador atacante elimina o jogador defensor e o defensor é o seu objetivo, então deve terminar o jogo.

        // Simula que o defensor não tem mais territórios
        defensor.getTerritorios().clear();

        VerificadorDeObjetivo.verificarObjetivoEliminacao(jogo, atacante, defensor);

        assertTrue(jogoEncerrado, "O jogo deveria ter sido encerrado");
    }

    @Test
    public void testAtacanteEliminaDefensorNaoObjetivo() {
        // Esse teste o jogador atacante elimina o jogador defensor, mas não é seu objetivo. O jogo continua.

        // Configura atacante com um objetivo diferente
        atacante = new Jogador("Atacante", new Objetivo(Objetivo.Tipo.CONQUISTA), null);

        // Atualiza a lista de jogadores
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

        // Simula que o defensor não tem mais territórios
        defensor.getTerritorios().clear();

        VerificadorDeObjetivo.verificarObjetivoEliminacao(jogo, atacante, defensor);

        assertFalse(jogoEncerrado, "O jogo não deveria ter sido encerrado");
        assertTrue(jogoContinuado, "O jogo deveria ter continuado");
    }
}
