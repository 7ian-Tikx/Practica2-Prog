package prog2.model;

import java.util.ArrayList;

public abstract class AccesAsfalt extends Acces{
    private double tamanyAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, ArrayList<Allotjament> llistaAllotjaments, double tamanyAsfalt){
        super(nom,accessibilitat,estat,llistaAllotjaments);

        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els setters

    public void setTamanyAsfalt(double tamanyAsfalt){
        this.tamanyAsfalt = tamanyAsfalt;
    }

    //fem els getters

    public double getTamanyAsfalt(){
        return this.tamanyAsfalt;
    }

    @Override
    public String toString(){
        return super.toString() + " , " + " tamany aslfat: " + this.tamanyAsfalt;
    }

}
