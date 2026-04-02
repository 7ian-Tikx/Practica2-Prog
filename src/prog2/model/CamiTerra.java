package prog2.model;

import java.util.ArrayList;

/**
 * Representa un camí de terra sense accés de vehicle.
 */
public class CamiTerra extends AccesTerra {

    /**
     * Constructor de CamiTerra.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param longitud paràmetre del mètode
     */
    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, false, longitud);
    }
    @Override
    /**
     * Mètode isAccessibilitat.
     * @return resultat del mètode
     */
    public boolean isAccessibilitat() {
        return false;
    }

}
