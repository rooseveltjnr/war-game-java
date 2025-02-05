package br.unicap.nomedisciplina.atividade00;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConquistouAmericaDoNorteEAfrica  extends Objetivo implements IObjetivo {
    
    private Set<String> americaDoNorte = Set.of("Mexico", "California", "Nova Iorque", "Labrador",
            "Ottawa", "Vancouver", "Mackenzie", "Alasca", "Groenlandia");

    private Set <String> africa = Set.of("Argelia", "Nigeria", "Egito", "Congo", "Sudao", "Madagascar",
            "Africa do Sul");

    public ConquistouAmericaDoNorteEAfrica (Tipo tipo, Jogador jogador, String nome, String descricao, int Id) {
        super(tipo, jogador, nome, descricao, Id);
    }

    @Override
    public boolean objetivoConquistado(Jogador jogador) {
        List<String> territorios = jogador.getTerritorios().stream()
                    .map(Territorio::getNome)
                    .collect(Collectors.toList());

        return territorios.containsAll(americaDoNorte) && territorios.containsAll(africa);
    }
}