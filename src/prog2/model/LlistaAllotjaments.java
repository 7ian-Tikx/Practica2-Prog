package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements  InLlistaAllotjaments{
    private ArrayList<Allotjament> llistaAllotjaments;

    public LlistaAllotjaments(){
        this.llistaAllotjaments = new ArrayList<>();
    }
    // Els getters i setters
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return this.llistaAllotjaments;
    }
    public void setTasquesManteniment(ArrayList<Allotjament> llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        this.llistaAllotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String result = "";
        boolean estatBoolean;
        estatBoolean = estat.equals("Operatiu");

        Iterator<Allotjament> it = this.llistaAllotjaments.iterator();
        while (it.hasNext()){
            Allotjament tmp = it.next();
            if (tmp.isOperatiu() == estatBoolean) result += tmp.toString();
            if (it.hasNext()) {
                result += "\n";
            }
        }
        if (result.isEmpty()) throw new ExcepcioCamping("No existeix allotjaments amb estat " + estat);
        return result;
    }


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
