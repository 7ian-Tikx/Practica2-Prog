package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment{
    private ArrayList<TascaManteniment> tasquesManteniment;

    public LlistaTasquesManteniment(){
        this.tasquesManteniment = new ArrayList<>();
    }

    // Els getters i setters
    public ArrayList getTasquesManteniment(){
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
        this.tasquesManteniment.add(tasca);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (!this.tasquesManteniment.contains(tasca)) throw new ExcepcioCamping("La tasca no existeix");
        Iterator<TascaManteniment> it = this.tasquesManteniment.iterator();
        while (it.hasNext()){
            TascaManteniment tmp = it.next();
            if (tmp == tasca){
                tmp.getAllotjament().obrirAllotjament();
                tasquesManteniment.remove(tasca);
            }
        }
    }


}
