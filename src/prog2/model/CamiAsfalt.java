package prog2.model;

import java.util.ArrayList;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments, float tamanyAsfalt){
        super(nom, false, estat, llistaAllotjaments, tamanyAsfalt);

    }
    @Override
    public boolean isAccessibilitat(){
        return false;
    }

}
