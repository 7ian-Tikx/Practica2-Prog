package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra{

    private double amplada;

    public CarreteraTerra(String nom, boolean accessibilitat, boolean estat, LListaAllotjaments llistaAllotjaments, double longitud) {
        super(nom, accessibilitat, estat, llistaAllotjaments, longitud);
        this.amplada = amplada;
    }

    //fem els setters
    public void setAmplada(double amplada){
        this.amplada = amplada;
    }

    //fem els getters

    public double getAmplada(){
        return this.amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }
    @Override
    public String toString() {

        return super.toString() + " , " + "amplada: " + this.amplada;
    }
}
