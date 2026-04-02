package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAllotjamentsTest {
    private LlistaAllotjaments llista;
    private Parcela all1;
    private Parcela all2;

    @BeforeEach
    void setUp() {
        llista = new LlistaAllotjaments();
        all1 = new Parcela("Parcela Nord", "ALL1", true, "100%", 64f, true);
        all2 = new Parcela("Parcela Sud", "ALL2", false, "0%", 64f, true);
        llista.afegirAllotjament(all1);
        llista.afegirAllotjament(all2);
    }

    @Test
    void llistarAllotjamentsPerEstat() {
        String operatius = llista.llistarAllotjaments("Operatiu");
        assertTrue(operatius.contains("ALL1"));
        assertFalse(operatius.contains("ALL2"));

        String noOperatius = llista.llistarAllotjaments("No operatiu");
        assertTrue(noOperatius.contains("ALL2"));
    }

    @Test
    void getAllotjamentPerId() {
        assertEquals(all1, llista.getAllotjament("ALL1"));
        assertThrows(ExcepcioCamping.class, () -> llista.getAllotjament("NO_EXISTEIX"));
    }

    @Test
    void containsAllotjamentOperatiuIBuidar() {
        assertTrue(llista.containsAllotjamentOperatiu());
        llista.buidar();
        assertFalse(llista.containsAllotjamentOperatiu());
        assertThrows(ExcepcioCamping.class, () -> llista.llistarAllotjaments("Operatiu"));
    }
}
