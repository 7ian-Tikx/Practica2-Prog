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
     * @param tasquesManteniment llista de tasques de manteniment
     */
    public void setTasquesManteniment(ArrayList<TascaManteniment> tasquesManteniment){
        this.tasquesManteniment = tasquesManteniment;
    }

    /**
    * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
    * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
    * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
    * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
    * @param num número identificador de la tasca
    * @param tipus tipus de tasca de manteniment
    * @param allotjament allotjament associat
    * @param data data de la tasca o operació
    * @param dies dies previstos o durada en dies
    * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
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
    * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
    * @param tasca tasca de manteniment
    * @throws ExcepcioCamping
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
    * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
    * En cas que no hi hagi cap tasca llança una excepció.
    * @return String
    * @throws ExcepcioCamping
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
    * Busca la tasca amb el número rebut per paràmetre i la retorna.
    * En cas que no existeixi llança una excepció.
    * @param num número identificador de la tasca
    * @return Objecte de tipus TascaManteniment
    * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
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
