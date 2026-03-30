package prog2.model;

import java.util.ArrayList;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean estat, float tamanyAsfalt){
        super(nom, false, tamanyAsfalt);

    }
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

}
