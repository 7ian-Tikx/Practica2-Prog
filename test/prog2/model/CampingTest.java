package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping("Green");
        camping.inicialitzaDadesCamping();
    }

    @Test
    void llistatsBasicsFuncionen() {
        String operatius = camping.llistarAllotjaments("Operatiu");
        assertTrue(operatius.contains("ALL1"));

        String oberts = camping.llistarAccessos("Obert");
        assertTrue(oberts.contains("A1"));
    }

    @Test
    void afegirICompletarTasca() {
        camping.afegirTascaManteniment(100, "Reparacio", "ALL3", "2026-04-01", 2);
        String tasques = camping.llistarTasquesManteniment();
        assertTrue(tasques.contains("Num tasca: 100"));

        camping.completarTascaManteniment(100);
        assertThrows(ExcepcioCamping.class, () -> camping.completarTascaManteniment(100));
    }

    @Test
    void saveILoad() throws Exception {
        Path tmp = Files.createTempFile("camping", ".dat");
        try {
            camping.save(tmp.toString());
            Camping recuperat = Camping.load(tmp.toString());
            assertEquals("Green", recuperat.getNomCamping());
            assertNotNull(recuperat.llistarAllotjaments("Operatiu"));
        } finally {
            Files.deleteIfExists(tmp);
        }
    }
}
