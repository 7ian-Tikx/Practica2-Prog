package prog2.model;

import java.util.ArrayList;

/**
 * Classe abstracta per als accessos de terra.
 */
public abstract class AccesTerra extends Acces {
    private double longitud;

    /**
     * Constructor de AccesTerra.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param longitud paràmetre del mètode
     */
    public AccesTerra(String nom, boolean estat, double longitud){
        super(nom,estat);

        this.longitud = longitud;
    }

    //fem els setters


    /**
     * Mètode setLongitud.
     * @param longitud paràmetre del mètode
     */
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    //fem els getters

    /**
     * Mètode getLongitud.
     * @return resultat del mètode
     */
    public double getLongitud(){
        return this.longitud;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        return super.toString() + " , " + "longitud " + this.longitud;
    }
}

