package prog2.model;

/**
 * Classe abstracta per als allotjaments de tipus casa.
 */
public abstract class Casa extends Allotjament{
    private float mida;
    private int habitacions;
    private int placesPersones;

    // El constructor
    public Casa(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA,
                boolean estat,String iluminacio,float mida,int habitacions,int placesPersones){
        super(nom,id,estadaMinimaALTA,estadaMinimaBAIXA,estat,iluminacio);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    //Els nous getters
    /**
     * Mètode getMida.
     * @return resultat del mètode
     */
    public float getMida(){
        return this.mida;
    }

    /**
     * Mètode getNumHabitacions.
     * @return resultat del mètode
     */
    public int getNumHabitacions(){
        return this.habitacions;
    }

    /**
     * Mètode getPlacesPersones.
     * @return resultat del mètode
     */
    public int getPlacesPersones(){
        return this.placesPersones;
    }

    // Els setters
    /**
     * Mètode setMida.
     * @param mida paràmetre del mètode
     */
    public void setMida(float mida){
        this.mida = mida;
    }

    /**
     * Mètode setHabitacions.
     * @param habitacions paràmetre del mètode
     */
    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }

    /**
     * Mètode setPlacesPersones.
     * @param placesPersones paràmetre del mètode
     */
    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }

    // El metode correcteFuncionament en aquest subclasse tambe es abstract
    public abstract boolean correcteFuncionament();

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() +
                ", mida=" + mida + ", habitacions=" + habitacions + ", placesPersones=" + placesPersones;
    }
}