package prog2.model;

public class Parcela extends Allotjament{
    private boolean conexioElectrica;  // Si te o no un punt de connexio
    private float mida;

    // El constructor
    public Parcela(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA,
                   boolean conexioElectrica, float mida){
        super(nom,id,2,4);
        this.conexioElectrica = conexioElectrica;
        this.mida = mida;
    }

    // Els getters i setters dels nous atributs
    public boolean isConnexioElectrica(){
        return this.conexioElectrica;
    }

    public double getMida(){
        return this.mida;
    }

    public void setConnexioElectrica(boolean conexioElectrica_){
        this.conexioElectrica = conexioElectrica_;
    }

    public void setMida(float mida_){
        this.mida = mida_;
    }

    @Override
    public boolean correcteFuncionament(){
        return conexioElectrica;
    }

    @Override
    public String toString(){
       return super.toString() + "Parcela{mida=" + this.mida + ", connexioElectrica=" + this.conexioElectrica + "}";
    }

}