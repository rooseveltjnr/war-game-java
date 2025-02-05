package br.unicap.nomedisciplina.atividade00;

import java.util.*;

public class Fortificacao {

    private static final Map<String, Set<String>> continentes = new HashMap<>();
    private static final ArrayList<String> bonusContinentes = new ArrayList<>();
    private static final Map<String, Integer> bonusContinentesValores = new HashMap<>();

    static {
        Set<String> americaDoSul = new HashSet<>();
        americaDoSul.add("Venezuela");
        americaDoSul.add("Peru");
        americaDoSul.add("Argentina");
        americaDoSul.add("Brasil");
        continentes.put("América do Sul", americaDoSul);

        Set<String> americaDoNorte = new HashSet<>();
        americaDoNorte.add("Alaska");
        americaDoNorte.add("Alberta");
        americaDoNorte.add("Oeste dos EUA");
        americaDoNorte.add("Centro dos EUA");
        americaDoNorte.add("Leste dos EUA");
        americaDoNorte.add("Groelândia");
        americaDoNorte.add("Ontario");
        americaDoNorte.add("Quebec");
        continentes.put("América do Norte", americaDoNorte);

        Set<String> africa = new HashSet<>();
        africa.add("Egito");
        africa.add("Congo");
        africa.add("Africa do Sul");
        africa.add("Madagascar");
        africa.add("Norte da Africa");
        africa.add("Sudão");
        africa.add("Guiné");
        continentes.put("Africa", africa);

        Set<String> oceania = new HashSet<>();
        oceania.add("Nova Guine");
        oceania.add("Australia Ocidental");
        oceania.add("Australia Oriental");
        continentes.put("Oceania", oceania);

        Set<String> europa = new HashSet<>();
        europa.add("Escandinavia");
        europa.add("Grande Bretanha");
        europa.add("Islandia");
        europa.add("Ucrania");
        europa.add("Europa do Norte");
        europa.add("Europa Ocidental");
        europa.add("Europa do Sul");
        continentes.put("Europa", europa);

        Set<String> asia = new HashSet<>();
        asia.add("Siberia");
        asia.add("Iakutsk");
        asia.add("Camchatka");
        asia.add("Japao");
        asia.add("China");
        asia.add("Mongolia");
        asia.add("India");
        asia.add("Ira");
        asia.add("Afeganistão");
        asia.add("Cazaquistão");
        asia.add("Sibéria Ocidental");
        continentes.put("Asia", asia);

        bonusContinentesValores.put("America do Sul", 2);
        bonusContinentesValores.put("America do Norte", 5);
        bonusContinentesValores.put("Africa", 3);
        bonusContinentesValores.put("Oceania", 2);
        bonusContinentesValores.put("Europa", 5);
        bonusContinentesValores.put("Asia", 7);
    }

    public static int calcularExercitosIniciais(Jogador jogador) {
        int exercitosBase = jogador.getTerritorios().size();
        int bonusContinentes = calcularBonusContinentes(jogador);
        return exercitosBase + bonusContinentes;
    }

    private static int calcularBonusContinentes(Jogador jogador) {
        int bonus = 0;
        for (int i = 0; i < bonusContinentes.size(); i++) {
            String continente = bonusContinentes.get(i);
            if (possuiContinente(jogador, continente)) {
                bonus += bonusContinentesValores.get(continente);
                System.out.println("O bônus é de: " + bonus);
            } else {
                System.out.println("O jogador não tem esse continente");
            }
        }
        return bonus;
    }

    public static boolean possuiContinente(Jogador jogador, String continente) {
        Set<String> territoriosContinente = continentes.get(continente);
        Set<String> territoriosJogador = new HashSet<>();
        for (Territorio territorio : jogador.getTerritorios()) {
            territoriosJogador.add(territorio.getNome());
            System.out.println(territorio.getNome());
        }
        return territoriosJogador.containsAll(territoriosContinente);
    }

    public static void alocarTropas(Territorio origem, Territorio destino, int quantidade) {
        RealocarTropas.realocarTropas(origem, destino, quantidade);
    }

}