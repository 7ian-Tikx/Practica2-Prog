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
     * @param nom nom de l'entitat
     * @param DNI valor d'entrada associat a l'operació
     */
    public Client(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }
    //Fem els getters de Nom i DNI
    /**
    * Retorna el nom de l'accés
    * @return
    */
    public String getNom(){
        return this.nom;
    }
    /**
     * Operació getDni.
     * @return valor retornat
     */
    public String getDni(){
        return this.DNI;
    }
    //Fem els setters del Nom i DNI
    /**
     * Operació setNom.
     * @param nom nom de l'entitat
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * Operació setDni.
     * @param DNI valor d'entrada associat a l'operació
     */
    public void setDni(String DNI){
        this.DNI = DNI;
    }
    @Override
    //Fem el metode toString per imprimir les informacions
    /**
     * Operació toString.
     * @return valor retornat
     */
    public String toString(){
        return this.nom + " amb DNI: " + this.DNI + ". ";
    }
}
