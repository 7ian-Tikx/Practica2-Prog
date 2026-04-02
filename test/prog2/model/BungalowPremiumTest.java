package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BungalowPremiumTest {
    private BungalowPremium premium;

    @BeforeEach
    void setUp() {
        premium = new BungalowPremium("Bungalow Premium Sud", "ALL4", true, "100%", 27f,
                2, 6, 1, true, true, true, true, "Wifi12345");
    }

    @Test
    void constructorIGettersCorrectes() {
        assertEquals("ALL4", premium.getId());
        assertTrue(premium.isServeisExtra());
        assertEquals("Wifi12345", premium.getCodiWifi());
        assertTrue(premium.isAireFred());
    }

    @Test
    void correcteFuncionamentDepenAireFredICodiWifi() {
        assertTrue(premium.correcteFuncionament());

        premium.setCodiWifi("123");
        assertFalse(premium.correcteFuncionament());

        premium.setCodiWifi("Wifi12345");
        premium.setAireFred(false);
        assertFalse(premium.correcteFuncionament());
    }
}
