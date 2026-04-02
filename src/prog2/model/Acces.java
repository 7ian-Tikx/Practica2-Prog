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
     * @param nom valor d'entrada
     * @param estat valor d'entrada
     */
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    //fem els setters

    /**
     * Operació setNom.
     * @param nom valor d'entrada
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Operació setAccessibilitat.
     * @param accessibilitat valor d'entrada
     */
    public void setAccessibilitat(boolean accessibilitat){
        this.accessibilitat = accessibilitat;
    }

    /**
     * Operació setEstat.
     * @param estat valor d'entrada
     */
    public void setEstat(boolean estat){
        this.estat = estat;
    }

    /**
     * Operació setLlistaAllotjaments.
     * @param llistaAllotjaments valor d'entrada
     */
    public void setLlistaAllotjaments(LlistaAllotjaments llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els getters

    /**
     * Operació getNom.
     * @return valor retornat
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Operació getAccessibilitat.
     * @return valor retornat
     */
    public boolean getAccessibilitat(){
        return this.accessibilitat;
    }

    /**
     * Operació getEstat.
     * @return valor retornat
     */
    public boolean getEstat(){
        return this.estat;
    }

    /**
     * Operació getAAllotjaments.
     * @return valor retornat
     */
    public LlistaAllotjaments getAAllotjaments(){
        return this.llistaAllotjaments;
    }

        /**
     * Operació afegirAllotjament.
     * @param allotjament valor d'entrada
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        this.llistaAllotjaments.afegirAllotjament(allotjament);
    }

        /**
     * Operació tancarAcces.
     */
    @Override
    public void tancarAcces() {
        this.estat = false;
    }

        /**
     * Operació obrirAcces.
     */
    @Override
    public void obrirAcces() {
        this.estat = true;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
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

