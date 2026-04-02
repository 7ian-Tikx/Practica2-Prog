package prog2.model;

import java.io.Serializable;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona les tasques de manteniment actives del càmping.
 */
public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable{
    private ArrayList<TascaManteniment> tasquesManteniment;

    /**
     * Constructor de LlistaTasquesManteniment.
     */
    public LlistaTasquesManteniment(){
        this.tasquesManteniment = new ArrayList<>();
    }

    // Els getters i setters
    /**
     * Operació getTasquesManteniment.
     * @return valor retornat
     */
    public ArrayList<TascaManteniment> getTasquesManteniment(){
        return this.tasquesManteniment;
    }
    /**
     * Operació setTasquesManteniment.
     * @param tasquesManteniment valor d'entrada
     */
    public void setTasquesManteniment(ArrayList<TascaManteniment> tasquesManteniment){
        this.tasquesManteniment = tasquesManteniment;
    }

        /**
     * Operació afegirTascaManteniment.
     * @param num valor d'entrada
     * @param tipus valor d'entrada
     * @param allotjament valor d'entrada
     * @param data valor d'entrada
     * @param dies valor d'entrada
     * @throws ExcepcioCamping en cas d'error
     */
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

        /**
     * Operació completarTascaManteniment.
     * @param tasca valor d'entrada
     * @throws ExcepcioCamping en cas d'error
     */
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

        /**
     * Operació llistarTasquesManteniment.
     * @return valor retornat
     * @throws ExcepcioCamping en cas d'error
     */
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

        /**
     * Operació getTascaManteniment.
     * @param num valor d'entrada
     * @return valor retornat
     * @throws ExcepcioCamping en cas d'error
     */
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
