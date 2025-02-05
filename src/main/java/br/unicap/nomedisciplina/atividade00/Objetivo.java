package br.unicap.nomedisciplina.atividade00;

public class Objetivo {
    public enum Tipo {
        ELIMINACAO, CONQUISTA, OUTRO
    }

    private Tipo tipo;
    private Jogador jogadorAlvo;
    
    public Objetivo(Tipo tipo, Jogador jogadorAlvo) {
        this.tipo = tipo;
        this.jogadorAlvo = jogadorAlvo;
    }

    public Objetivo(Tipo tipo) {
        this.tipo = tipo;
        this.jogadorAlvo = null; 
    }

    public Objetivo(Tipo tipo2, Jogador jogadorAlvo2, String nome, String descricao, int id) {
        this.tipo = tipo2;
        this.jogadorAlvo = jogadorAlvo2;
        
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Jogador getJogadorAlvo() {
        return jogadorAlvo;
    }

    public boolean isObjetivoEliminacao() {
        return tipo == Tipo.ELIMINACAO;
    }

}
