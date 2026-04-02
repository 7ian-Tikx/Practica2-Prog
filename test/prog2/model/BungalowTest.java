package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BungalowTest {
    private Bungalow bungalow;

    @BeforeEach
    void setUp() {
        bungalow = new Bungalow("Bungalow Nord", "ALL3", true, "100%", 22f,
                2, 4, 1, true, true, true);
    }

    @Test
    void constructorIGettersCorrectes() {
        assertEquals("Bungalow Nord", bungalow.getNom());
        assertEquals("ALL3", bungalow.getId());
        assertEquals(22f, bungalow.getMida());
        assertEquals(2, bungalow.getNumHabitacions());
        assertEquals(4, bungalow.getPlacesPersones());
        assertEquals(1, bungalow.getPlacesParquing());
        assertTrue(bungalow.isTerrassa());
        assertTrue(bungalow.isTV());
        assertTrue(bungalow.isAireFred());
    }

    @Test
    void correcteFuncionamentDepenAireFred() {
        assertTrue(bungalow.correcteFuncionament());
        bungalow.setAireFred(false);
        assertFalse(bungalow.correcteFuncionament());
    }
}
