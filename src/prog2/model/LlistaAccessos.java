package prog2.model;

import java.io.Serializable;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona la col·lecció d'accessos del càmping.
 */
public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> llistaAccessos;

    //fem el constructor
    /**
     * Constructor de LlistaAccessos.
     */
    public LlistaAccessos(){
        this.llistaAccessos = new ArrayList<>();
    }

    @Override
    /**
     * Mètode afegirAcces.
     * @param acc paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping{
        this.llistaAccessos.add(acc);
    }

    @Override
    /**
     * Mètode buidar.
     */
    public void buidar(){
        this.llistaAccessos.clear();

    }

    @Override
    /**
     * Mètode llistarAccessos.
     * @param estat paràmetre del mètode
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
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
    /**
     * Mètode actualitzaEstatAccessos.
     * @throws ExcepcioCamping en cas d'error
     */
    public void actualitzaEstatAccessos() throws ExcepcioCamping{
        Iterator<Acces> iterator = this.llistaAccessos.iterator();

        while(iterator.hasNext()){
            Acces acces = iterator.next();

            acces.setEstat(false);

            if(acces.getAAllotjaments().containsAllotjamentOperatiu()){
                acces.setEstat(true);
            }
        }
    }

    @Override
    /**
     * Mètode calculaAccessosNoAccessibles.
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
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
    /**
     * Mètode calculaMetresTerra.
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
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
        return metres;
    }
}

