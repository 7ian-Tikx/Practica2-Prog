package prog2.model;

public class TascaManteniment implements InTascaManteniment {
    private int numTasca;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;


    public TascaManteniment (int numTasca,TipusTascaManteniment tipus,Allotjament allotjament,String data,int dies){
        this.numTasca = numTasca;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }


    // Els getters
    @Override
    public int getNum() {
        return numTasca;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return this.tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    // Els setters
    public void setNum(int num_) {
        this.numTasca = num_;
    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

    @Override
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void setDies(int dies) {
        this.dies = dies;
    }

    @Override
    public String getIluminacioAllotjament() {
        return this.allotjament.getIluminacio();
    }

    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
}

