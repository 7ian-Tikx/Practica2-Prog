package prog2.model;

/**
 * Representa un camí asfaltat sense accés de vehicle.
 */
public class CamiAsfaltat extends AccesAsfalt {
    public CamiAsfaltat(String nom, boolean estat, float tamanyAsfalt){
        super(nom, false, tamanyAsfalt);

    }
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

}
