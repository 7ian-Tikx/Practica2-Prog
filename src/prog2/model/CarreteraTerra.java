package prog2.model;

import java.util.ArrayList;

/**
 * Representa una carretera de terra amb accés de vehicle.
 */
public class CarreteraTerra extends AccesTerra{

    private double amplada;

    /**
     * Constructor de CarreteraTerra.
     * @param nom valor d'entrada
     * @param accessibilitat valor d'entrada
     * @param longitud valor d'entrada
     * @param amplada valor d'entrada
     */
    public CarreteraTerra(String nom, boolean accessibilitat, double longitud, double amplada) {
        super(nom, accessibilitat, longitud);
        this.amplada = amplada;
    }

    //fem els setters
    /**
     * Operació setAmplada.
     * @param amplada valor d'entrada
     */
    public void setAmplada(double amplada){
        this.amplada = amplada;
    }

    //fem els getters

    /**
     * Operació getAmplada.
     * @return valor retornat
     */
    public double getAmplada(){
        return this.amplada;
    }

        /**
     * Operació isAccessibilitat.
     * @return valor retornat
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }
        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {

        return super.toString() + " , " + "amplada: " + this.amplada;
    }
}
