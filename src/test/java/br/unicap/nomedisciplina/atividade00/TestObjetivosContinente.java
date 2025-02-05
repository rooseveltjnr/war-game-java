package br.unicap.nomedisciplina.atividade00;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicap.nomedisciplina.atividade00.Jogador.ID;
import br.unicap.nomedisciplina.atividade00.Objetivo.Tipo;

public class TestObjetivosContinente {

    private final String ASIA_E_AMERICA_DO_SUL = "Conquistar Asia e America do Sul";
    private final String DESCRICAO_ASIA_E_AMERICA_DO_SUL = "Conquiste totalmente o continente da Asia e America do Sul";

    private final String EUROPA_E_OCEANIA = "Conquistar Europa e Oceania";
    private final String DESCRICAO_EUROPA_E_OCEANIA = "Conquiste totalmente o continente da Europe e Oceania";

    private final String AMERICA_DO_NORTE_E_AFRICA = "Conquistar América do Norte e Africa";
    private final String DESCRICAO_AMERICA_DO_NORTE_E_AFRICA = "Conquiste totalmente o continente da America do Norte e Africa";

    private ConquistouAsiaEAmericaDoSul asiaEAmericaDoSul;
    private ConquistouEuropaEOceania europaeOceania;
    private ConquistouAmericaDoNorteEAfrica americaDoNorteEAfrica;

    private Territorio territorio;
    private List<Territorio> países = new ArrayList<>();
    private Jogador jogador;

    private String[] paisesAsiaeAmericaDoSul = {"Oriente Medio", "Aral", "Omsk", "Dudinka", "Siberia", "Tchita",
            "Mongolia", "Vladivostok", "California", "Nova Iorque", "Labrador", "Ottawa", "Vancouver",
            "China", "India", "Japao", "Vietna", "Brasil", "Argentina", "Uruguai", "Colombia",
            "Venezuela", "Peru", "Bolivia", "Chile", "Mexico", "California",};
    private String[] asia = {"Oriente Medio", "Aral", "Omsk", "Dudinka", "Siberia", "Tchita",
            "Mongolia", "Vladivostok", "China", "India", "Japao", "Vietna" };
    private String[] AmericaDoSul = {"Brasil", "Argentina", "Uruguai", "Colombia", "Venezuela",
            "Peru", "Bolivia", "Chile" };

    private String[] paisesEuropaeOceania = {"Islandia", "Inglaterra", "Suecia", "Alemanha", "Espanha", "Portugal", "Franca", "Italia", "Polonia", "Iugoslavia", "Moscou",
            "Borneu", "Sumatra", "Nova Guine", "Australia"};

    private String[] paisesAmericaDoNorteEAfrica = {"Mexico", "California", "Nova Iorque","Labrador", "Ottawa", "Vancouver", "Mackenzie", "Alasca", "Groenlandia", 
            "Argelia", "Nigeria", "Egito", "Congo", "Sudao", "Madagascar", "Africa do Sul"};

    @BeforeEach
    public void setUp() {
        asiaEAmericaDoSul = new ConquistouAsiaEAmericaDoSul(Tipo.CONQUISTA, jogador, ASIA_E_AMERICA_DO_SUL, DESCRICAO_ASIA_E_AMERICA_DO_SUL, 0);
        europaeOceania = new ConquistouEuropaEOceania(Tipo.CONQUISTA, jogador, EUROPA_E_OCEANIA, DESCRICAO_EUROPA_E_OCEANIA, 1);
        americaDoNorteEAfrica = new ConquistouAmericaDoNorteEAfrica (Tipo.CONQUISTA, jogador, AMERICA_DO_NORTE_E_AFRICA, DESCRICAO_AMERICA_DO_NORTE_E_AFRICA, 2);
        jogador = new Jogador("jogador 1", ID.PRETO);
    }

    private void setPaises(String[] paises) {
        this.países.clear();
        Arrays.stream(paises).forEach(nomePais -> {
            Territorio territorio = new Territorio(nomePais, 1);
            territorio.setProprietario(jogador);
            this.países.add(territorio);
        });
    }


    // Asia e America do Sul //
    @Test
    public void testeDominandoOContinenteAsiatico() {
        setPaises(asia);
        jogador.adicionarTerritorio(países);
        boolean objetivo = asiaEAmericaDoSul.objetivoConquistado(jogador);
        assertFalse(objetivo);
    }

    @Test
    public void testeDominandoAmericaDoSul() {
        setPaises(AmericaDoSul);
        jogador.adicionarTerritorio(países);
        boolean objetivo = asiaEAmericaDoSul.objetivoConquistado(jogador);
        assertFalse(objetivo);
    }


    @Test
    public void testeDominandoAlgunsTerritoriosNaAsiaEAmericaDoSul() {
        Arrays.stream(paisesAsiaeAmericaDoSul)
                .limit(13)
                .forEach(país -> {
                    territorio = new Territorio(país, 1);
                    territorio.setProprietario(jogador);
                    países.add(territorio);
                });
        jogador.adicionarTerritorio(países);
        boolean objetivo = asiaEAmericaDoSul.objetivoConquistado(jogador);
        assertFalse(objetivo);
    }

    @Test
    public void testeDominandoAsiaEAmericaDoSul() {
        setPaises(paisesAsiaeAmericaDoSul);
        jogador.adicionarTerritorio(países);
        jogador.adicionarContinenteConquistado(países);
        boolean objetivo = asiaEAmericaDoSul.objetivoConquistado(jogador);
        assertTrue(objetivo);
    }

    // Europa e Oceania //
    @Test
    public void testeDominandoEuropaEOceania() {
        setPaises(paisesEuropaeOceania);
        jogador.adicionarTerritorio(países);
        jogador.adicionarContinenteConquistado(países);
        boolean objetivo = europaeOceania.objetivoConquistado(jogador);
        assertTrue(objetivo);
    }

    // America do Norte e Africa //
    @Test
    public void testeDominandoAmericaDoNorteEAfrica() {
        setPaises(paisesAmericaDoNorteEAfrica);
        jogador.adicionarTerritorio(países);
        jogador.adicionarContinenteConquistado(países);
        boolean objetivo = americaDoNorteEAfrica.objetivoConquistado(jogador);
        assertTrue(objetivo);
    }
    
}