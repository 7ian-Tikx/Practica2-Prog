package prog2.model;

import java.util.ArrayList;

/**
 * Classe abstracta per als accessos de terra.
 */
public abstract class AccesTerra extends Acces {
    private double longitud;

    /**
     * Constructor de AccesTerra.
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     * @param longitud valor d'entrada
     */
    public AccesTerra(String nom, boolean estat, double longitud){
        super(nom,estat);

        this.longitud = longitud;
    }

    //fem els setters


    /**
     * Operació setLongitud.
     * @param longitud valor d'entrada
     */
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    //fem els getters

    /**
     * Operació getLongitud.
     * @return valor retornat
     */
    public double getLongitud(){
        return this.longitud;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString(){
        return super.toString() + " , " + "longitud " + this.longitud;
    }
}

