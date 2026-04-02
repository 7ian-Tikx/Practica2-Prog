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

    /**
    * Afegeix un accés rebut per paràmetre a la llista d'accessos.
    * @param acc accés a afegir
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping{
        this.llistaAccessos.add(acc);
    }

    /**
    * Buida la llista d'allotjaments.
    */
    @Override
    public void buidar(){
        this.llistaAccessos.clear();

    }

    /**
    * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
    * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció. 
    * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
    * @return String
    * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
    * 
    */
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

    /**
    * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
    @Override
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

    /**
    * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
    * @return int
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
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

    /**
    * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
    * @return float amb els metres totals.
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
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
        return metres;
    }
}

