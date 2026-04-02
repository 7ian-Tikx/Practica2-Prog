package prog2.model;

import java.io.Serializable;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable{
    private ArrayList<TascaManteniment> tasquesManteniment;

    public LlistaTasquesManteniment(){
        this.tasquesManteniment = new ArrayList<>();
    }

    // Els getters i setters
    public ArrayList<TascaManteniment> getTasquesManteniment(){
        return this.tasquesManteniment;
    }
    public void setTasquesManteniment(ArrayList<TascaManteniment> tasquesManteniment){
        this.tasquesManteniment = tasquesManteniment;
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        TascaManteniment.TipusTascaManteniment tipusTasca;
        try {
            tipusTasca = TascaManteniment.TipusTascaManteniment.valueOf(tipus.trim());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ExcepcioCamping("El tipus de tasca no existeix: " + tipus);
        }

        Iterator<TascaManteniment> it = this.tasquesManteniment.iterator();
        while (it.hasNext()){
            TascaManteniment tmp = it.next();
            if (tmp.getAllotjament() == allotjament){
                throw new ExcepcioCamping("L'allotjament + "+ allotjament.getNom()+ " ja te una tasca assignada");
            }
        }
        TascaManteniment tasca = new TascaManteniment(num,tipusTasca,allotjament,data,dies);
        allotjament.tancarAllotjament(tasca);
        this.tasquesManteniment.add(tasca);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        Iterator<TascaManteniment> it = this.tasquesManteniment.iterator();
        while (it.hasNext()){
            TascaManteniment tmp = it.next();
            if (tmp == tasca){
                tmp.getAllotjament().obrirAllotjament();
                it.remove();
                return;
            }
        }
        throw new ExcepcioCamping("La tasca no existeix");
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        String result = "";
        if (this.tasquesManteniment.isEmpty()) throw new ExcepcioCamping("NO hi ha cap tasca registrada");
        Iterator<TascaManteniment> it = this.tasquesManteniment.iterator();
        while (it.hasNext()){
            TascaManteniment tmp = it.next();
            result += "Num tasca: " + tmp.getNum()
                    + ", tipus: " + tmp.getTipus()
                    + ", allotjament: " + tmp.getAllotjament().getNom()
                    + ", data: " + tmp.getData()
                    + ", dies: " + tmp.getDies();
            if (it.hasNext()) {
                result += "\n";
            }
        }
        return result;
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        Iterator<TascaManteniment> it = this.tasquesManteniment.iterator();
        while (it.hasNext()){
            TascaManteniment tmp = it.next();
            if (tmp.getNum() == num){
                return tmp;
            }
        }
        throw new ExcepcioCamping("La tasca no existeix");
    }
}
