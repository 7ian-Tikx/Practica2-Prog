package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelaTest {
    private Parcela parcela;

    @BeforeEach
    void setUp() {
        parcela = new Parcela("Parcela Nord", "ALL1", true, "100%", 64.0f, true);
    }

    @Test
    void constructorIGettersCorrectes() {
        assertEquals("Parcela Nord", parcela.getNom());
        assertEquals("ALL1", parcela.getId());
        assertEquals(64.0, parcela.getMida());
        assertTrue(parcela.isConnexioElectrica());
        assertTrue(parcela.isOperatiu());
        assertEquals("100%", parcela.getIluminacio());
    }

    @Test
    void correcteFuncionamentDepenConnexio() {
        assertTrue(parcela.correcteFuncionament());
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.correcteFuncionament());
    }
}
