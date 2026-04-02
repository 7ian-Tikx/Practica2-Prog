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
     * Operació getMida.
     * @return valor retornat
     */
    public float getMida(){
        return this.mida;
    }

    /**
     * Operació getNumHabitacions.
     * @return valor retornat
     */
    public int getNumHabitacions(){
        return this.habitacions;
    }

    /**
     * Operació getPlacesPersones.
     * @return valor retornat
     */
    public int getPlacesPersones(){
        return this.placesPersones;
    }

    // Els setters
    /**
     * Operació setMida.
     * @param mida mida de l'allotjament
     */
    public void setMida(float mida){
        this.mida = mida;
    }

    /**
     * Operació setHabitacions.
     * @param habitacions nombre d'habitacions
     */
    public void setHabitacions(int habitacions){
        this.habitacions = habitacions;
    }

    /**
     * Operació setPlacesPersones.
     * @param placesPersones capacitat màxima de persones
     */
    public void setPlacesPersones(int placesPersones){
        this.placesPersones = placesPersones;
    }

    // El metode correcteFuncionament en aquest subclasse tambe es abstract
    public abstract boolean correcteFuncionament();

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() +
                ", mida=" + mida + ", habitacions=" + habitacions + ", placesPersones=" + placesPersones;
    }
}