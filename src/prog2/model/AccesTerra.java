package prog2.model;

import java.util.ArrayList;

public abstract class AccesTerra extends Acces {
    private double longitud;

    public AccesTerra(String nom, boolean estat, double longitud){
        super(nom,estat);

        this.longitud = longitud;
    }

    //fem els setters


    public void setLongitud(double longitud){
        this.longitud = longitud;
    }

    //fem els getters

    public double getLongitud(){
        return this.longitud;
    }

    @Override
    public String toString(){
        return super.toString() + " , " + "longitud " + this.longitud;
    }
}

