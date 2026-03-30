package prog2.model;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments, double longitud) {
        super(nom, false, estat, llistaAllotjaments, longitud);
    }
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

}
