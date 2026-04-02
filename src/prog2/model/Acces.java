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
     * @param nom nom de l'entitat
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     */
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    //fem els setters

    /**
     * Operació setNom.
     * @param nom nom de l'entitat
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Operació setAccessibilitat.
     * @param accessibilitat valor d'entrada associat a l'operació
     */
    public void setAccessibilitat(boolean accessibilitat){
        this.accessibilitat = accessibilitat;
    }

    /**
     * Operació setEstat.
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     */
    public void setEstat(boolean estat){
        this.estat = estat;
    }

    /**
     * Operació setLlistaAllotjaments.
     * @param llistaAllotjaments llista d'allotjaments
     */
    public void setLlistaAllotjaments(LlistaAllotjaments llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els getters

    /**
    * Retorna el nom de l'accés
    * @return
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
    * Retorna l'estat de l'accés (obert o tancat)
    * @return
    */
    public boolean getEstat(){
        return this.estat;
    }

    /**
    * Retorna la llista d'allotjaments associats a l'accés
    * @return
    */
    public LlistaAllotjaments getAAllotjaments(){
        return this.llistaAllotjaments;
    }

    /**
    * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
    * @param allotjament allotjament associat
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        this.llistaAllotjaments.afegirAllotjament(allotjament);
    }

    /**
    * Canvia l'estat de l'accés a tancat
    */
    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    /**
    * Canvia l'estat de l'accés a obert 
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

