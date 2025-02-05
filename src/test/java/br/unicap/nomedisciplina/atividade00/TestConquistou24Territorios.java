package br.unicap.nomedisciplina.atividade00;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicap.nomedisciplina.atividade00.Jogador.ID;

public class TestConquistou24Territorios {

    public enum Tipo {
        ELIMINACAO, CONQUISTADE24TERRITORIOS, CONQUISTADECONTINENTE, OUTRO
    }
    private final String NOME = "Conquistar 24 territorios";
    private final String DESCRICAO = "Conquiste 24 territorios à sua escolha";
    
    private Conquistou24Territorios conquistando24Territorios;
    private Jogador jogador;
    private Territorio territorio;
    private List<Territorio> paises = new ArrayList<>();
    private String[] listaDeTerritorios = {"Mexico", "California", "Nova Iorque", "Labrador", "Ottawa", "Vancouver",
            "Mackenzie", "Alasca", "Groenlandia", "Oriente Medio", "Aral", "Omsk", "Dudinka", "Siberia",
            "Tchita", "Mongolia", "Vladivostok", "China", "India", "Japao", "Vietna", "Sumatra",
            "Nova Guine", "Australia" };
    
    @BeforeEach
    public void setUp() {
        conquistando24Territorios = new Conquistou24Territorios (Objetivo.Tipo.CONQUISTA, jogador, NOME, DESCRICAO, 1);
        jogador = new Jogador ("Jogador 1", ID.PRETO);

    }

    @Test
    public void testeJogadorSemTerritorio() {
        boolean objetivo = conquistando24Territorios.objetivoConquistado(jogador);
        assertFalse(objetivo);
    }

    @Test
    public void testJogadorComMenosQue24Territorios() {
        Arrays.stream(listaDeTerritorios)
                .limit(13)
                .forEach(pais-> {
                    territorio = new Territorio(pais, 1);
                    territorio.setProprietario(jogador);
                    paises.add(territorio);
                });

        jogador.adicionarTerritorio(paises);
        boolean objetivo = conquistando24Territorios.objetivoConquistado(jogador);
        assertFalse(objetivo);
    }

    @Test
    public void testJogadorCom24TerritoriosConquistados() {
        Arrays.stream(listaDeTerritorios)
                .forEach(pais -> {
                    territorio = new Territorio(pais, 1);
                    territorio.setProprietario(jogador);
                    paises.add(territorio);
                });

        jogador.adicionarTerritorio(paises);
        boolean objetivo = conquistando24Territorios.objetivoConquistado(jogador);
        assertTrue(objetivo);
    }
}
