package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlampingTest {
    private Glamping glamping;

    @BeforeEach
    void setUp() {
        glamping = new Glamping("Glamping Nord", "ALL5", true, "100%", 20f,
                1, 2, "Tela", true);
    }

    @Test
    void constructorIGettersCorrectes() {
        assertEquals("ALL5", glamping.getId());
        assertEquals("Tela", glamping.getMaterial());
        assertTrue(glamping.isCasaMascota());
        assertEquals(20f, glamping.getMida());
    }

    @Test
    void correcteFuncionamentDepenCasaMascota() {
        assertTrue(glamping.correcteFuncionament());
        glamping.setCasaMascota(false);
        assertFalse(glamping.correcteFuncionament());
    }
}
