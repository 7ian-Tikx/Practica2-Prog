package prog2.model;

/**
 * Representa un allotjament de tipus bungalow.
 */
public class Bungalow extends Casa{
    private int placesParquing;
    boolean terrassa;
    boolean tv;
    private boolean aireFred;

    // El constructor
    public Bungalow(String nom, String id,boolean estat,String iluminacio, float mida,int habitacions,int placesPersones,int placesParquing,
                    boolean terrassa,boolean tv, boolean aireFred){
       super(nom,id,7,4,estat,iluminacio,mida,habitacions,placesPersones);
       this.placesParquing = placesParquing; // Un bungallow normal nomes te 1 places de parquing
       this.terrassa = terrassa;
       this.tv = tv;
       this.aireFred = aireFred;
    }

    // Els getters
    /**
     * Operació getPlacesParquing.
     * @return valor retornat
     */
    public int getPlacesParquing(){
        return this.placesParquing;
    }

    /**
     * Operació isTerrassa.
     * @return valor retornat
     */
    public boolean isTerrassa(){
        return this.terrassa;
    }

    /**
     * Operació isTV.
     * @return valor retornat
     */
    public boolean isTV(){
        return this.tv;
    }

    /**
     * Operació isAireFred.
     * @return valor retornat
     */
    public boolean isAireFred(){
        return this.aireFred;
    }


    // Els setters
    /**
     * Operació setPlacesParquingPlaces.
     * @param placesParquing valor d'entrada
     */
    public void setPlacesParquingPlaces(int placesParquing){
        this.placesParquing = placesParquing;
    }

    /**
     * Operació setTerrassa.
     * @param terrassa valor d'entrada
     */
    public void setTerrassa(boolean terrassa){
        this.terrassa = terrassa;
    }

    /**
     * Operació setTV.
     * @param tv valor d'entrada
     */
    public void setTV(boolean tv){
        this.tv = tv;
    }

    /**
     * Operació setAireFred.
     * @param aireFred valor d'entrada
     */
    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() +
                ". Bungalow{" + "placesParquing=" + placesParquing + ", terrassa=" + terrassa +
                ", tv=" + tv + ", aireFred=" + aireFred + "}";
    }

    // El metodo funcionaCorrectament
        /**
     * Operació correcteFuncionament.
     * @return valor retornat
     */
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }
}