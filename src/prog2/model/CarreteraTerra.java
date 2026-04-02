package prog2.model;

import java.util.ArrayList;

/**
 * Representa una carretera de terra amb accés de vehicle.
 */
public class CarreteraTerra extends AccesTerra{

    private double amplada;

    /**
     * Constructor de CarreteraTerra.
     * @param nom paràmetre del mètode
     * @param accessibilitat paràmetre del mètode
     * @param longitud paràmetre del mètode
     * @param amplada paràmetre del mètode
     */
    public CarreteraTerra(String nom, boolean accessibilitat, double longitud, double amplada) {
        super(nom, accessibilitat, longitud);
        this.amplada = amplada;
    }

    //fem els setters
    /**
     * Mètode setAmplada.
     * @param amplada paràmetre del mètode
     */
    public void setAmplada(double amplada){
        this.amplada = amplada;
    }

    //fem els getters

    /**
     * Mètode getAmplada.
     * @return resultat del mètode
     */
    public double getAmplada(){
        return this.amplada;
    }

    @Override
    /**
     * Mètode isAccessibilitat.
     * @return resultat del mètode
     */
    public boolean isAccessibilitat() {
        return true;
    }
    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {

        return super.toString() + " , " + "amplada: " + this.amplada;
    }
}
