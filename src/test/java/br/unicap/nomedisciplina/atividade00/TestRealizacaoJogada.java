package br.unicap.nomedisciplina.atividade00;

import br.unicap.nomedisciplina.atividade00.state.StateAtaque;
import br.unicap.nomedisciplina.atividade00.state.StatePovoamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestRealizacaoJogada {

    private Jogo jogo;
    private Jogador jogador;
    private Territorio territorioOrigem;
    private Territorio territorioDestino;
    private Territorio territorioNaoAdjacente;

    @BeforeEach
    public void setUp() {
        jogador = mock(Jogador.class);
        territorioOrigem = mock(Territorio.class);
        territorioDestino = mock(Territorio.class);
        territorioNaoAdjacente = mock(Territorio.class);
        jogo = new Jogo(Collections.singletonList(jogador));
    }

    @Test
    public void testMudarParaEstadoAtaque() {
        jogo.mudarParaEstadoAtaque();
        assertTrue(jogo.getEstadoAtual() instanceof StateAtaque);
    }

    @Test
    public void testMudarParaEstadoPovoamento() {
        jogo.mudarParaEstadoPovoamento();
        assertTrue(jogo.getEstadoAtual() instanceof StatePovoamento);
    }

    @Test
    public void testRealizacaoDeUmaJogada() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioDestino));
        when(territorioOrigem.getExercitos()).thenReturn(5);
        when(territorioDestino.getExercitos()).thenReturn(2);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.singleton(territorioDestino));

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertTrue(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, times(1)).setExercitos(4);
        verify(territorioDestino, times(1)).setExercitos(3);
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalha() {
        when(jogador.podeRealizarJogada()).thenReturn(false);

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalhaPorTerritoriosNaoAdjacentes() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioNaoAdjacente));
        when(territorioOrigem.getExercitos()).thenReturn(5);
        when(territorioNaoAdjacente.getExercitos()).thenReturn(2);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.emptySet());

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioNaoAdjacente);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, never()).setExercitos(anyInt());
        verify(territorioNaoAdjacente, never()).setExercitos(anyInt());
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalhaPorExercitoInsuficiente() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioDestino));
        when(territorioOrigem.getExercitos()).thenReturn(1);
        when(territorioDestino.getExercitos()).thenReturn(2);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.singleton(territorioDestino));

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, never()).setExercitos(anyInt());
        verify(territorioDestino, never()).setExercitos(anyInt());
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalhaPorFaltaDeTerritorios() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Collections.singletonList(territorioOrigem));
        when(territorioOrigem.getExercitos()).thenReturn(5);

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, never()).setExercitos(anyInt());
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalhaPorDestinoMaximoExercitos() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioDestino));
        when(territorioOrigem.getExercitos()).thenReturn(54); // Certifique-se que é mais do que 1
        when(territorioDestino.getExercitos()).thenReturn(Integer.MAX_VALUE);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.singleton(territorioDestino));

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, never()).setExercitos(anyInt());
        verify(territorioDestino, never()).setExercitos(anyInt());
    }

    @Test
    public void testRealizacaoDeUmaJogadaFalhaPorExercitoIgualUm() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioDestino));
        when(territorioOrigem.getExercitos()).thenReturn(1);
        when(territorioDestino.getExercitos()).thenReturn(2);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.singleton(territorioDestino));

        boolean resultado = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);

        assertFalse(resultado);
        verify(jogador, times(1)).podeRealizarJogada();
        verify(territorioOrigem, never()).setExercitos(anyInt());
        verify(territorioDestino, never()).setExercitos(anyInt());
    }

    @Test
    public void testRealizacaoDeUmaJogadaSucessoSeguidoDePovoamento() {
        when(jogador.podeRealizarJogada()).thenReturn(true);
        when(jogador.getTerritorios()).thenReturn(Arrays.asList(territorioOrigem, territorioDestino));
        when(territorioOrigem.getExercitos()).thenReturn(5);
        when(territorioDestino.getExercitos()).thenReturn(2);
        when(territorioOrigem.getAdjacentes()).thenReturn(Collections.singleton(territorioDestino));

        boolean resultadoJogada = jogo.realizarJogada(jogador, territorioOrigem, territorioDestino);
        assertTrue(resultadoJogada);

        assertTrue(jogo.getEstadoAtual() instanceof StatePovoamento);

        jogo.mudarParaEstadoPovoamento();
        when(jogador.getTerritorios()).thenReturn(Collections.singletonList(territorioDestino));
        when(territorioDestino.getExercitos()).thenReturn(3);

        jogo.povoarTerritorio(jogador, territorioDestino, 2);

        verify(territorioDestino, times(1)).setExercitos(5);
    }

    @Test
    public void testPovoamentoDeTerritorio() {
        jogo.mudarParaEstadoPovoamento();

        when(jogador.getTerritorios()).thenReturn(Collections.singletonList(territorioOrigem));
        when(territorioOrigem.getExercitos()).thenReturn(5);

        jogo.povoarTerritorio(jogador, territorioOrigem, 3);

        verify(territorioOrigem, times(1)).setExercitos(8);
    }

    @Test
    public void testPovoamentoDeTerritorioFalha() {
        jogo.mudarParaEstadoPovoamento();

        Territorio territorioNaoPossuido = mock(Territorio.class);
        when(jogador.getTerritorios()).thenReturn(Collections.singletonList(territorioOrigem));

        jogo.povoarTerritorio(jogador, territorioNaoPossuido, 3);

        verify(territorioNaoPossuido, never()).setExercitos(anyInt());
    }
}
