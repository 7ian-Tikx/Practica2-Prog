package prog2.model;

/**
 * Representa un camí asfaltat sense accés de vehicle.
 */
public class CamiAsfaltat extends AccesAsfalt {
    /**
     * Constructor de CamiAsfaltat.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param tamanyAsfalt paràmetre del mètode
     */
    public CamiAsfaltat(String nom, boolean estat, float tamanyAsfalt){
        super(nom, false, tamanyAsfalt);

    }
    @Override
    /**
     * Mètode isAccessibilitat.
     * @return resultat del mètode
     */
    public boolean isAccessibilitat(){
        return false;
    }

}
