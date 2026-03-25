package prog2.model;

public abstract class Casa extends Allotjament{
    private String mida;
    private int habitacions;
    private int placesPersones;

    // El constructor
    public Casa(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA,
                boolean estat,String iluminacio,String mida,int habitacions,int placesPersones){
        super(nom,id,estadaMinimaALTA,estadaMinimaBAIXA,estat,iluminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    //Els nous getters
    public String getMida(){
        return this.mida;
    }

    public int getNumHabitacions(){
        return this.habitacions;
    }

    public int getPlacesPersones(){
        return this.placesPersones;
    }

    // Els setters
    public void setMida(String mida){
        this.mida = mida;
    }

    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }

    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }

    // El metode correcteFuncionament en aquest subclasse tambe es abstract
    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return super.toString() +
                ", mida=" + mida + ", habitacions=" + habitacions + ", placesPersones=" + placesPersones;
    }
}