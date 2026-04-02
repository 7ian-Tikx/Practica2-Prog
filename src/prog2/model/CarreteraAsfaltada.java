package prog2.model;

import java.util.ArrayList;

/**
 * Representa una carretera asfaltada amb accés de vehicle.
 */
public class CarreteraAsfaltada extends AccesAsfalt{

    private double pes;

    /**
     * Constructor de CarreteraAsfaltada.
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     * @param tamanyAsfalt valor d'entrada
     * @param pes valor d'entrada
     */
    public CarreteraAsfaltada(String nom, boolean estat, float tamanyAsfalt,double pes){
        super(nom, true, tamanyAsfalt);
        this.pes = pes;
    }

    // fem els setters

    /**
     * Operació setPes.
     * @param pes valor d'entrada
     */
    public void setPes(double pes){
        this.pes = pes;
    }

    // fem els

    /**
     * Operació getPes.
     * @return valor retornat
     */
    public double getPes(){
        return this.pes;
    }
        /**
     * Operació isAccessibilitat.
     * @return valor retornat
     */
    @Override
    public boolean isAccessibilitat(){
        return true;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString(){
        return super.toString() + " , " + " pes: " + this.pes;
    }
}
