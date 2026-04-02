package prog2.model;

import java.util.ArrayList;

/**
 * Representa un camí de terra sense accés de vehicle.
 */
public class CamiTerra extends AccesTerra {

    /**
     * Constructor de CamiTerra.
     * @param nom nom de l'entitat
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     * @param longitud longitud del tram de terra en metres
     */
    public CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, false, longitud);
    }
    /**
    * Retorna si l'accés permet accessibilitat amb cotxe o no.
    * @return 
    */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
