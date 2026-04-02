package prog2.model;

import java.util.ArrayList;

/**
 * Classe abstracta per als accessos asfaltats.
 */
public abstract class AccesAsfalt extends Acces{
    private double tamanyAsfalt;

    /**
     * Constructor de AccesAsfalt.
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     * @param tamanyAsfalt valor d'entrada
     */
    public AccesAsfalt(String nom, boolean estat, double tamanyAsfalt){
        super(nom,estat);
        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els setters

    /**
     * Operació setTamanyAsfalt.
     * @param tamanyAsfalt valor d'entrada
     */
    public void setTamanyAsfalt(double tamanyAsfalt){
        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els getters

    /**
     * Operació getTamanyAsfalt.
     * @return valor retornat
     */
    public double getTamanyAsfalt(){
        return this.tamanyAsfalt;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString(){
        return super.toString() + " , " + " tamany aslfat: " + this.tamanyAsfalt;
    }

}
