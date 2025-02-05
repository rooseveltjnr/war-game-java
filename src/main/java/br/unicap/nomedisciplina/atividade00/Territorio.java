package br.unicap.nomedisciplina.atividade00;

import java.util.HashSet;
import java.util.Set;

public class Territorio {
    private String nome;
    private Jogador proprietario;
    private int exercitos;
    private Set<Territorio> adjacentes;
    private String continente;

    public Territorio(String nome, int exercitos) {
        this.nome = nome;
        this.exercitos = exercitos;
        this.adjacentes = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public int getExercitos() {
        return exercitos;
    }

    public void setExercitos(int exercitos) {
        this.exercitos = exercitos;
    }

    public void adicionarAdjacente(Territorio territorio) {
        adjacentes.add(territorio);
    }

    public Set<Territorio> getAdjacentes() {
        return adjacentes;
    }

    public void adicionarExercitos(int quantidade) {
        this.exercitos += quantidade;
    }

    public void removerExercitos(int quantidade) {
        this.exercitos -= quantidade;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    public String getContinente() {
        return continente;
    }
}
