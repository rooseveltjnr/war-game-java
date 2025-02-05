package br.unicap.nomedisciplina.atividade00;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConquistouEuropaEOceania extends Objetivo implements IObjetivo{

        private static final Set <String> europa = Set.of("Islandia", "Inglaterra", "Suecia", "Alemanha", "Espanha", 
                "Portugal", "Franca", "Italia", "Polonia", "Iugoslavia", "Moscou");

        private static final Set <String> oceania = Set.of("Borneu", "Sumatra", "Nova Guine", "Australia");
    
        public ConquistouEuropaEOceania (Tipo tipo, Jogador jogador, String nome, String descricao, int Id) {
            super(tipo, jogador, nome, descricao, Id);
        }

        @Override
        public boolean objetivoConquistado(Jogador jogador) {

            List<String> territorios = jogador.getTerritorios().stream()
            .map(Territorio::getNome)
            .collect(Collectors.toList());

            return territorios.containsAll(europa) && territorios.containsAll(oceania);
        }
 }