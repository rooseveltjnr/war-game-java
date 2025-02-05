package br.unicap.nomedisciplina.atividade00;


public class Conquistou24Territorios extends Objetivo implements IObjetivo{

    public Conquistou24Territorios(Tipo tipo, Jogador jogadorAlvo, String nome, String descricao, int Id) {
       super(tipo, jogadorAlvo, nome, descricao, Id);
    }

    @Override
    public boolean objetivoConquistado(Jogador jogador) {
        long territorioConquistado = jogador.getTerritorios().stream()
                .filter(t -> t.getProprietario().equals(jogador))
                .count();

        return territorioConquistado == 24;
    }
}