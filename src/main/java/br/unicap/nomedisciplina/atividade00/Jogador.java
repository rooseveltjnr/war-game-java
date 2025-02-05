package br.unicap.nomedisciplina.atividade00;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Jogador {
    private String nome;
    private Objetivo objetivoPrimario;
    private Objetivo objetivoSecundario;
    private List<Territorio> territorios;
    private Set<String> continentesConquistados;

    public enum ID {
        AZUL("Azul"),
        AMARELO("Amarelo"),
        PRETO("Preto"),
        VERDE("Verde"),
        VERMELHO("Vermelho"),
        BRANCO("Branco");
    
        private final String nome;
    
        ID(String nome) {
            this.nome = nome;
        }
    
        public String getNomeDaCor() {
            return nome;
        }
    }

    public Jogador(String nome, Objetivo objetivoPrimario, Objetivo objetivoSecundario) {
        this.nome = nome;
        this.objetivoPrimario = objetivoPrimario;
        this.objetivoSecundario = objetivoSecundario;
        this.territorios = new ArrayList<>();
        this.continentesConquistados = new HashSet<>();
    }
    private ID id;

    public Jogador(String nome, ID id) {
        this.nome = nome;
        this.id = id;
        this.territorios = new ArrayList<>();
        this.continentesConquistados = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Objetivo getObjetivo() {
        return objetivoPrimario;
    }

    public Objetivo getObjetivoSecundario() {
        return objetivoSecundario;
    }

    public void setObjetivo(Objetivo novoObjetivo) {
        this.objetivoPrimario = novoObjetivo;
    }

    public Set<String> getContinentesConquistados() {
        return continentesConquistados;
    }
    
    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void adicionarTerritorio(Territorio paises) {
        this.territorios.add(paises);
    }

    public void removerTerritorio(Territorio territorio) {
        this.territorios.remove(territorio);
    }

    public boolean podeRealizarJogada() {
        // verifica se o jogador pode realizar a jogada
        for (Territorio territorio : territorios) {
            if (territorio.getExercitos() > 1) {
                return true;
            }
        }
        return false;
    }
    public void adicionarContinenteConquistado(String continente) {
        if (continente != null && !continente.isEmpty()) {
        this.continentesConquistados.add(continente);
        }
    }

    public void adicionarTerritorio(List<Territorio> paises) {
        this.territorios.addAll(paises);
    }

    public void adicionarContinenteConquistado(List<Territorio> países) {
            for (Territorio territorio : países) {
                String continente = territorio.getContinente();
                if (continente != null && !continente.isEmpty()) {
                    continentesConquistados.add(continente);
            }
        }
    }
}
