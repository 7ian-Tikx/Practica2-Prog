package prog2.model;

import java.util.ArrayList;

/**
 * Classe abstracta per als accessos asfaltats.
 */
public abstract class AccesAsfalt extends Acces{
    private double tamanyAsfalt;

    /**
     * Constructor de AccesAsfalt.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param tamanyAsfalt paràmetre del mètode
     */
    public AccesAsfalt(String nom, boolean estat, double tamanyAsfalt){
        super(nom,estat);
        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els setters

    /**
     * Mètode setTamanyAsfalt.
     * @param tamanyAsfalt paràmetre del mètode
     */
    public void setTamanyAsfalt(double tamanyAsfalt){
        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els getters

    /**
     * Mètode getTamanyAsfalt.
     * @return resultat del mètode
     */
    public double getTamanyAsfalt(){
        return this.tamanyAsfalt;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        return super.toString() + " , " + " tamany aslfat: " + this.tamanyAsfalt;
    }

}
