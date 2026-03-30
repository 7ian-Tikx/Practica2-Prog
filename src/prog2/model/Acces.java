package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private ArrayList<Allotjament> llistaAllotjaments;

    public Acces(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> llistaAllotjaments) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els setters

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAccessibilitat(boolean accessibilitat){
        this.accessibilitat = accessibilitat;
    }

    public void setEstat(boolean estat){
        this.estat = estat;
    }

    public void setLlistaAllotjaments(ArrayList<Allotjament> llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els getters

    public String getNom(){
        return this.nom;
    }

    public boolean getAccessibilitat(){
        return this.accessibilitat;
    }

    public boolean getEstat(){
        return this.estat;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return this.llistaAllotjaments;
    }
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

