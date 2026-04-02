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
     * @param numTasca valor d'entrada
     * @param tipus valor d'entrada
     * @param allotjament valor d'entrada
     * @param data valor d'entrada
     * @param dies valor d'entrada
     */
    public TascaManteniment (int numTasca,TipusTascaManteniment tipus,Allotjament allotjament,String data,int dies){
        this.numTasca = numTasca;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }


    // Els getters
        /**
     * Operació getNum.
     * @return valor retornat
     */
    @Override
    public int getNum() {
        return numTasca;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return this.tipus;
    }

        /**
     * Operació getAllotjament.
     * @return valor retornat
     */
    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

        /**
     * Operació getData.
     * @return valor retornat
     */
    @Override
    public String getData() {
        return data;
    }

        /**
     * Operació getDies.
     * @return valor retornat
     */
    @Override
    public int getDies() {
        return dies;
    }

    // Els setters
    /**
     * Operació setNum.
     * @param num_ valor d'entrada
     */
    public void setNum(int num_) {
        this.numTasca = num_;
    }

        /**
     * Operació setTipus.
     * @param tipus_ valor d'entrada
     */
    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

        /**
     * Operació setAllotjament.
     * @param allotjament valor d'entrada
     */
    @Override
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

        /**
     * Operació setData.
     * @param data valor d'entrada
     */
    @Override
    public void setData(String data) {
        this.data = data;
    }

        /**
     * Operació setDies.
     * @param dies valor d'entrada
     */
    @Override
    public void setDies(int dies) {
        this.dies = dies;
    }

        /**
     * Operació getIluminacioAllotjament.
     * @return valor retornat
     */
    @Override
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

