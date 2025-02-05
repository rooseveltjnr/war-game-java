package br.unicap.nomedisciplina.atividade00;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConquistouAsiaEAmericaDoSul extends Objetivo implements IObjetivo{

    private Set <String> asia = Set.of("Oriente Medio", "Aral", "Omsk", "Dudinka", "Siberia", "Tchita",
            "Mongolia", "Vladivostok", "China", "India", "Japao", "Vietna" );
    private Set <String> americaDoSul = Set.of("Brasil", "Argentina", "Uruguai", "Colombia", "Venezuela",
            "Peru", "Bolivia", "Chile" );

    public ConquistouAsiaEAmericaDoSul (Tipo tipo, Jogador jogadorAlvo,String nome, String descricao, int Id) {
        super(tipo, jogadorAlvo, nome, descricao, Id);
    }

    @Override
    public boolean objetivoConquistado(Jogador jogador) {
        List <String> territorios = jogador.getTerritorios().stream()
        .map(Territorio::getNome)
        .collect(Collectors.toList());

        return territorios.containsAll(asia) && territorios.containsAll(americaDoSul);
    }
}
