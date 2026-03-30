package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> llistaAccessos;

    //fem el constructor
    public LlistaAccessos(){
        this.llistaAccessos = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping{
        this.llistaAccessos.add(acc);
    }

    @Override
    public void buidar(){
        this.llistaAccessos.clear();

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping{
        String resultat = "";
        boolean trobat = false;

        Iterator<Acces> iterator = this.llistaAccessos.iterator();

        while(iterator.hasNext()){
            Acces acces = iterator.next();

            if(acces.getEstat() == estat){
                resultat += acces.toString() + "\n";
                trobat = true;
            }
        }

        if(!trobat){
            String estatS = "";
            if(estat){
                estatS = "obert";
            }
            else{
                estatS = "tancat";
            }
            throw new ExcepcioCamping("No hi ha cap accés en estat " + estatS + " actualment.");

        }

        return resultat;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping{
        Iterator<Acces> iterator = this.llistaAccessos.iterator();

        while(iterator.hasNext()){
            Acces acces = iterator.next();

            acces.setEstat(false);

            if(acces.getLlistaAllotjaments().containsAllotjamentOperatiu()){
                acces.setEstat(true);
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping{
        int comptador = 0;

        Iterator<Acces> iterator = this.llistaAccessos.iterator();

        while(iterator.hasNext()){
            Acces acces = iterator.next();

            if(!acces.isAccessibilitat()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping{
        float metres = 0;

        Iterator<Acces> iterator = this.llistaAccessos.iterator();

        while(iterator.hasNext()){
            Acces acces = iterator.next();

            if(acces instanceof AccesTerra){
                AccesTerra accesTerra = (AccesTerra) acces;
                metres += accesTerra.getLongitud();
            }
        }
    }
}

