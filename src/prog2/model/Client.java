package prog2.model;

import java.io.Serializable;

/**
 * Representa un client del càmping.
 */
public class Client implements Serializable {
    private String nom;
    private String DNI;

    //Fem el constructor de la clase Client
    /**
     * Constructor de Client.
     * @param nom paràmetre del mètode
     * @param DNI paràmetre del mètode
     */
    public Client(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }
    //Fem els getters de Nom i DNI
    /**
     * Mètode getNom.
     * @return resultat del mètode
     */
    public String getNom(){
        return this.nom;
    }
    /**
     * Mètode getDni.
     * @return resultat del mètode
     */
    public String getDni(){
        return this.DNI;
    }
    //Fem els setters del Nom i DNI
    /**
     * Mètode setNom.
     * @param nom paràmetre del mètode
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * Mètode setDni.
     * @param DNI paràmetre del mètode
     */
    public void setDni(String DNI){
        this.DNI = DNI;
    }
    @Override
    //Fem el metode toString per imprimir les informacions
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        return this.nom + " amb DNI: " + this.DNI + ". ";
    }
}