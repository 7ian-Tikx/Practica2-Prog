package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {
    public CamiAsfaltat(String nom, boolean estat, float tamanyAsfalt){
        super(nom, false, tamanyAsfalt);

    }
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

}
