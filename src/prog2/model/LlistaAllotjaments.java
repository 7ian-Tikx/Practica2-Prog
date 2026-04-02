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
     * Operació getLlistaAllotjaments.
     * @return valor retornat
     */
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return this.llistaAllotjaments;
    }
    /**
     * Operació setLlistaAllotjaments.
     * @param llistaAllotjaments llista d'allotjaments
     */
    public void setLlistaAllotjaments(ArrayList<Allotjament> llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    /**
    * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
    * @param allotjament allotjament associat
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAllotjaments.add(allotjament);
    }

    /**
    * Buida la llista d'allotjaments.
    */
    @Override
    public void buidar() {
        this.llistaAllotjaments.clear();
    }

    /**
    * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
    * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
    * @param estat
    * @return String
    * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
    */
    @Override
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


    /**
    * Mira si la llista d'allotjaments conté algun allotjament operatiu.
    * @return boolean
    */
    @Override
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

    /**
    * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
    * @param allotjament
    * @return boolean
    */
    @Override
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

    /**
    * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
    * @param id identificador únic
    * @return  Objecte de tipus Allotjament
    * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
    */
    @Override
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
