package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaTasquesMantenimentTest {
    private LlistaTasquesManteniment llista;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        llista = new LlistaTasquesManteniment();
        allotjament = new Parcela("Parcela Nord", "ALL1", true, "100%", 64f, true);
    }

    @Test
    void afegirTascaTancaAllotjament() {
        llista.afegirTascaManteniment(1, "Reparacio", allotjament, "2026-03-30", 2);
        assertFalse(allotjament.isOperatiu());
        assertEquals("50%", allotjament.getIluminacio());
        assertEquals(1, llista.getTasquesManteniment().size());
    }

    @Test
    void noPermetDuesTasquesMateixAllotjament() {
        llista.afegirTascaManteniment(1, "Reparacio", allotjament, "2026-03-30", 2);
        assertThrows(ExcepcioCamping.class,
                () -> llista.afegirTascaManteniment(2, "Neteja", allotjament, "2026-03-31", 1));
    }

    @Test
    void completarTascaObreAllotjament() {
        llista.afegirTascaManteniment(1, "Reparacio", allotjament, "2026-03-30", 2);
        TascaManteniment tasca = llista.getTascaManteniment(1);

        llista.completarTascaManteniment(tasca);

        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
        assertEquals(0, llista.getTasquesManteniment().size());
    }
}
