package prog2.model;

import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String DNI;

    //Fem el constructor de la clase Client
    public Client(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }
    //Fem els getters de Nom i DNI
    public String getNom(){
        return this.nom;
    }
    public String getDni(){
        return this.DNI;
    }
    //Fem els setters del Nom i DNI
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setDni(String DNI){
        this.DNI = DNI;
    }
    @Override
    //Fem el metode toString per imprimir les informacions
    public String toString(){
        return this.nom + " amb DNI: " + this.DNI + ". ";
    }
}