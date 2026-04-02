package prog2.model;

import java.util.ArrayList;

/**
 * Representa un camí de terra sense accés de vehicle.
 */
public class CamiTerra extends AccesTerra {

    /**
     * Constructor de CamiTerra.
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     * @param longitud valor d'entrada
     */
    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, false, longitud);
    }
        /**
     * Operació isAccessibilitat.
     * @return valor retornat
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
