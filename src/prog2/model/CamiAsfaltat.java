package prog2.model;

/**
 * Representa un camí asfaltat sense accés de vehicle.
 */
public class CamiAsfaltat extends AccesAsfalt {
    /**
     * Constructor de CamiAsfaltat.
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     * @param tamanyAsfalt valor d'entrada
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
