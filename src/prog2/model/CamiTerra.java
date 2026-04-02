package prog2.model;

import java.util.ArrayList;

/**
 * Representa un camí de terra sense accés de vehicle.
 */
public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, false, longitud);
    }
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
