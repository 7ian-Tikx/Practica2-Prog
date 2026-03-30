package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfalt extends AccesAsfalt{

    private double pes;

    public CarreteraAsfalt(String nom, boolean estat, float tamanyAsfalt){
        super(nom, true, tamanyAsfalt);
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
