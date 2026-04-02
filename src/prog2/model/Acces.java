package prog2.model;

import java.io.Serializable;

import java.util.ArrayList;

/**
 * Classe abstracta base per als accessos del càmping.
 */
public abstract class Acces implements InAcces, Serializable {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    /**
     * Constructor de Acces.
     * @param nom paràmetre del mètode
     * @param estat paràmetre del mètode
     */
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    //fem els setters

    /**
     * Mètode setNom.
     * @param nom paràmetre del mètode
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Mètode setAccessibilitat.
     * @param accessibilitat paràmetre del mètode
     */
    public void setAccessibilitat(boolean accessibilitat){
        this.accessibilitat = accessibilitat;
    }

    /**
     * Mètode setEstat.
     * @param estat paràmetre del mètode
     */
    public void setEstat(boolean estat){
        this.estat = estat;
    }

    /**
     * Mètode setLlistaAllotjaments.
     * @param llistaAllotjaments paràmetre del mètode
     */
    public void setLlistaAllotjaments(LlistaAllotjaments llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els getters

    /**
     * Mètode getNom.
     * @return resultat del mètode
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Mètode getAccessibilitat.
     * @return resultat del mètode
     */
    public boolean getAccessibilitat(){
        return this.accessibilitat;
    }

    /**
     * Mètode getEstat.
     * @return resultat del mètode
     */
    public boolean getEstat(){
        return this.estat;
    }

    /**
     * Mètode getAAllotjaments.
     * @return resultat del mètode
     */
    public LlistaAllotjaments getAAllotjaments(){
        return this.llistaAllotjaments;
    }

    @Override
    /**
     * Mètode afegirAllotjament.
     * @param allotjament paràmetre del mètode
     */
    public void afegirAllotjament(Allotjament allotjament) {
        this.llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    /**
     * Mètode tancarAcces.
     */
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    /**
     * Mètode obrirAcces.
     */
    public void obrirAcces() {
        this.estat = true;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        String access = "";
        String estats = "";
        if(this.accessibilitat) {
            access = "Sí";
        }
        else{
                access = "No";
        }

        if(this.estat){
            estats = "Obert";
        }
        else{
            estats = "Tancat";
        }
        return ("nom: " + this.nom + " , " + "accessibilitat: " + access + " , "+ "estat : " + estats);
   }


}

