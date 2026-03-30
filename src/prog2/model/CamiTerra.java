package prog2.model;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> llistaAllotjaments, double longitud) {
        super(nom, false, estat, llistaAllotjaments, longitud);
    }
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
