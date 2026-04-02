package prog2.model;

import java.util.ArrayList;

/**
 * Representa una carretera asfaltada amb accés de vehicle.
 */
public class CarreteraAsfaltada extends AccesAsfalt{

    private double pes;

    /**
     * Constructor de CarreteraAsfaltada.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param tamanyAsfalt paràmetre del mètode
     * @param pes paràmetre del mètode
     */
    public CarreteraAsfaltada(String nom, boolean estat, float tamanyAsfalt,double pes){
        super(nom, true, tamanyAsfalt);
        this.pes = pes;
    }

    // fem els setters

    /**
     * Mètode setPes.
     * @param pes paràmetre del mètode
     */
    public void setPes(double pes){
        this.pes = pes;
    }

    // fem els

    /**
     * Mètode getPes.
     * @return resultat del mètode
     */
    public double getPes(){
        return this.pes;
    }
    @Override
    /**
     * Mètode isAccessibilitat.
     * @return resultat del mètode
     */
    public boolean isAccessibilitat(){
        return true;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        return super.toString() + " , " + " pes: " + this.pes;
    }
}
