package br.unicap.nomedisciplina.atividade00;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestAtaqueTerritorial {

    @Test
    public void testAtacanteComMaisExercitos() {
        Territorio atacante = new Territorio("Território A", 10);
        Territorio defensor = new Territorio("Território B", 4);

        AtaqueTerritorial.realizarAtaque(atacante, defensor);

        // Exemplo de asserts com range devido à aleatoriedade
        assertTrue(atacante.getExercitos() >= 7 && atacante.getExercitos() <= 9);
        assertTrue(defensor.getExercitos() >= 1 && defensor.getExercitos() <= 3);
    }

    @Test
    public void testDefensorComMenosExercitos() {
        Territorio atacante = new Territorio("Território A", 3);
        Territorio defensor = new Territorio("Território B", 1);

        AtaqueTerritorial.realizarAtaque(atacante, defensor);

        // Exemplo de asserts com range devido à aleatoriedade
        assertTrue(atacante.getExercitos() >= 1 && atacante.getExercitos() <= 3);
        assertTrue(defensor.getExercitos() == 0);
    }

    @Test
    public void testAtacanteComPoucosExercitos() {
        Territorio atacante = new Territorio("Território A", 2);
        Territorio defensor = new Territorio("Território B", 3);

        AtaqueTerritorial.realizarAtaque(atacante, defensor);

        // Exemplo de asserts com range devido à aleatoriedade
        assertTrue(atacante.getExercitos() >= 1 && atacante.getExercitos() <= 2);
        assertTrue(defensor.getExercitos() >= 1 && defensor.getExercitos() <= 3);
    }

    @Test
    public void testAtacanteNaoPodeAtacarComUmExercito() {
        Territorio atacante = new Territorio("Território A", 1);
        Territorio defensor = new Territorio("Território B", 3);

        AtaqueTerritorial.realizarAtaque(atacante, defensor);

        // Exército atacante deve permanecer inalterado
        assertEquals(1, atacante.getExercitos());
        assertEquals(3, defensor.getExercitos());
    }
}
