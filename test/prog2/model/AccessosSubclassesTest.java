package prog2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessosSubclassesTest {

    @Test
    void camiAsfaltatICarreteraAsfaltada() {
        CamiAsfaltat cami = new CamiAsfaltat("A1", true, 200);
        CarreteraAsfaltada carretera = new CarreteraAsfaltada("A2", true, 800, 10000);

        assertFalse(cami.isAccessibilitat());
        assertEquals(200, cami.getTamanyAsfalt());

        assertTrue(carretera.isAccessibilitat());
        assertEquals(10000, carretera.getPes());
    }

    @Test
    void camiTerraICarreteraTerra() {
        CamiTerra cami = new CamiTerra("A3", true, 100);
        CarreteraTerra carretera = new CarreteraTerra("A4", true, 200, 3);

        assertFalse(cami.isAccessibilitat());
        assertEquals(100, cami.getLongitud());

        assertTrue(carretera.isAccessibilitat());
        assertEquals(200, carretera.getLongitud());
        assertEquals(3, carretera.getAmplada());
    }
}
