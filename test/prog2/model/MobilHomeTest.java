package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilHomeTest {
    private MobilHome mobilHome;

    @BeforeEach
    void setUp() {
        mobilHome = new MobilHome("Mobil-Home Sud", "ALL6", true, "100%", 22f,
                2, 4, true);
    }

    @Test
    void constructorIGettersCorrectes() {
        assertEquals("ALL6", mobilHome.getId());
        assertEquals(22f, mobilHome.getMida());
        assertEquals(2, mobilHome.getNumHabitacions());
        assertEquals(4, mobilHome.getPlacesPersones());
        assertTrue(mobilHome.isTerrassaBarbacoa());
    }

    @Test
    void correcteFuncionamentDepenTerrassaBarbacoa() {
        assertTrue(mobilHome.correcteFuncionament());
        mobilHome.setTerrassaBarbacoa(false);
        assertFalse(mobilHome.correcteFuncionament());
    }
}
