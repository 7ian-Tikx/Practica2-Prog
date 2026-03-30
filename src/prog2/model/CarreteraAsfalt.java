package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{

    private double pes;

    public CarreteraAsfalt(String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments,float tamanyAsfalt){
        super(nom, true, estat, llistaAllotjaments, tamanyAsfalt);
        this.pes = pes;
    }

    // fem els setters

    public void setPes(double pes){
        this.pes = pes;
    }

    // fem els

    public double getPes(){
        return this.pes;
    }
    @Override
    public boolean isAccessibilitat(){
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + " , " + " pes: " + this.pes;
    }
}
