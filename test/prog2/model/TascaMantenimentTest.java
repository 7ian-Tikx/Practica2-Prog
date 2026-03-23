package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TascaMantenimentTest {
    private TascaManteniment tasca;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Suposant que Allotjament té un constructor bàsic
        allotjament = new Parcela("Allotjament Test", "ID001", true,  "100%", 50,  true);
        tasca = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.Reparacio, allotjament, "2024-03-25", 4);
    }

    @Test
    void testConstructor() {
        assertEquals(1, tasca.getNum());
        assertEquals(TascaManteniment.TipusTascaManteniment.Reparacio, tasca.getTipus());
        assertEquals(allotjament, tasca.getAllotjament());
        assertEquals("2024-03-25", tasca.getData());
        assertEquals(4, tasca.getDies());
    }

    static class AllotjamentTest {

        private Allotjament allotjament;

        @BeforeEach
        void setUp() {
            // Creem una instància anònima d'Allotjament per a tests

            allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);
        }

        @Test
        void comprovarConstructor() {
            assertEquals("Allotjament Test", allotjament.getNom());
            assertEquals("ID001", allotjament.getId());
            assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
            assertEquals(2, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
            assertEquals(true, allotjament.isOperatiu());
            assertEquals("100%", allotjament.getIluminacio());
        }
    }
}
