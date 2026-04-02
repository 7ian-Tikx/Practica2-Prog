package prog2.model;

/**
 * Representa un camí asfaltat sense accés de vehicle.
 */
public class CamiAsfaltat extends AccesAsfalt {
    /**
     * Constructor de CamiAsfaltat.
     * @param nom nom de l'entitat
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     * @param tamanyAsfalt metres quadrats d'asfalt
     */
    public CamiAsfaltat(String nom, boolean estat, float tamanyAsfalt){
        super(nom, false, tamanyAsfalt);

    }
        /**
     * Operació isAccessibilitat.
     * @return valor retornat
     */
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

}
