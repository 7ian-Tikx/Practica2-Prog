package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LlistaAccessosTest {
    private LlistaAccessos llista;
    private Acces a1;
    private Acces a2;

    @BeforeEach
    void setUp() {
        llista = new LlistaAccessos();

        a1 = new CamiAsfaltat("A1", true, 200);
        a2 = new CarreteraTerra("A2", true, 400, 4);

        Allotjament allOperatiu = new Parcela("Parcela Nord", "ALL1", true, "100%", 64f, true);
        Allotjament allNoOperatiu = new Parcela("Parcela Sud", "ALL2", false, "0%", 64f, true);

        a1.afegirAllotjament(allOperatiu);
        a2.afegirAllotjament(allNoOperatiu);

        llista.afegirAcces(a1);
        llista.afegirAcces(a2);
    }

    @Test
    void calculaAccessosNoAccessiblesICalculaMetresTerra() {
        assertEquals(1, llista.calculaAccessosNoAccessibles());
        assertEquals(400f, llista.calculaMetresTerra());
    }

    @Test
    void actualitzaEstatAccessos() {
        llista.actualitzaEstatAccessos();
        assertTrue(a1.getEstat());
        assertFalse(a2.getEstat());
    }

    @Test
    void llistarAccessosPerEstat() {
        llista.actualitzaEstatAccessos();
        String oberts = llista.llistarAccessos(true);
        assertTrue(oberts.contains("A1"));

        String tancats = llista.llistarAccessos(false);
        assertTrue(tancats.contains("A2"));
    }
}
