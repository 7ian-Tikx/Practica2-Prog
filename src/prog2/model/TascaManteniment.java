package prog2.model;

import java.io.Serializable;

/**
 * Representa una tasca de manteniment associada a un allotjament.
 */
public class TascaManteniment implements InTascaManteniment, Serializable {
    private int numTasca;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;


    /**
     * Constructor de TascaManteniment.
     * @param numTasca paràmetre del mètode
     * @param tipus paràmetre del mètode
     * @param allotjament paràmetre del mètode
     * @param data paràmetre del mètode
     * @param dies paràmetre del mètode
     */
    public TascaManteniment (int numTasca,TipusTascaManteniment tipus,Allotjament allotjament,String data,int dies){
        this.numTasca = numTasca;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }


    // Els getters
    @Override
    /**
     * Mètode getNum.
     * @return resultat del mètode
     */
    public int getNum() {
        return numTasca;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return this.tipus;
    }

    @Override
    /**
     * Mètode getAllotjament.
     * @return resultat del mètode
     */
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    /**
     * Mètode getData.
     * @return resultat del mètode
     */
    public String getData() {
        return data;
    }

    @Override
    /**
     * Mètode getDies.
     * @return resultat del mètode
     */
    public int getDies() {
        return dies;
    }

    // Els setters
    /**
     * Mètode setNum.
     * @param num_ paràmetre del mètode
     */
    public void setNum(int num_) {
        this.numTasca = num_;
    }

    @Override
    /**
     * Mètode setTipus.
     * @param tipus_ paràmetre del mètode
     */
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

    @Override
    /**
     * Mètode setAllotjament.
     * @param allotjament paràmetre del mètode
     */
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    @Override
    /**
     * Mètode setData.
     * @param data paràmetre del mètode
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    /**
     * Mètode setDies.
     * @param dies paràmetre del mètode
     */
    public void setDies(int dies) {
        this.dies = dies;
    }

    @Override
    /**
     * Mètode getIluminacioAllotjament.
     * @return resultat del mètode
     */
    public String getIluminacioAllotjament() {
        if (this.tipus == TipusTascaManteniment.Reparacio) {
            return "50%";
        } else if (this.tipus == TipusTascaManteniment.Neteja) {
            return "100%";
        } else if (this.tipus == TipusTascaManteniment.RevisioTecnica) {
            return "50%";
        } else{
            return "0%";
        }
    }


    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
}

