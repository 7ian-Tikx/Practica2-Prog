package prog2.model;

import java.io.Serializable;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona la col·lecció d'allotjaments del càmping.
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable{
    private ArrayList<Allotjament> llistaAllotjaments;

    /**
     * Constructor de LlistaAllotjaments.
     */
    public LlistaAllotjaments(){
        this.llistaAllotjaments = new ArrayList<>();
    }
    // Els getters i setters
    /**
     * Mètode getLlistaAllotjaments.
     * @return resultat del mètode
     */
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return this.llistaAllotjaments;
    }
    /**
     * Mètode setLlistaAllotjaments.
     * @param llistaAllotjaments paràmetre del mètode
     */
    public void setLlistaAllotjaments(ArrayList<Allotjament> llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    @Override
    /**
     * Mètode afegirAllotjament.
     * @param allotjament paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAllotjaments.add(allotjament);
    }

    @Override
    /**
     * Mètode buidar.
     */
    public void buidar() {
        this.llistaAllotjaments.clear();
    }

    @Override
    /**
     * Mètode llistarAllotjaments.
     * @param estat paràmetre del mètode
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        boolean estatBoolean;
        if ("Operatiu".equals(estat)) {
            estatBoolean = true;
        } else if ("No operatiu".equals(estat)) {
            estatBoolean = false;
        } else {
            throw new ExcepcioCamping("Estat no vàlid: " + estat);
        }

        String result = "";
        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()) {
            Allotjament tmp = it.next();
            if (tmp.isOperatiu() == estatBoolean) {
                if (!result.isEmpty()) result += "\n";
                result += tmp.toString();
            }
        }
        if (result.isEmpty()) throw new ExcepcioCamping("No existeix allotjaments amb estat " + estat);
        return result;
    }


    @Override
    /**
     * Mètode containsAllotjamentOperatiu.
     * @return resultat del mètode
     */
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()){
            Allotjament tmp = it.next();
                if (tmp.isOperatiu()){
                    return true;
                }
            }
        return false;
    }

    @Override
    /**
     * Mètode contains.
     * @param allotjament paràmetre del mètode
     * @return resultat del mètode
     */
    public boolean contains(Allotjament allotjament) {
        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()){
            Allotjament tmp = it.next();
            if (tmp == allotjament){
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * Mètode getAllotjament.
     * @param id paràmetre del mètode
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()){
            Allotjament tmp = it.next();
            if (tmp.getId().equals(id)){
                return tmp;
            }
        }
        throw new ExcepcioCamping("No existeix allotjament amb id " + id);
    }
}
