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
     * Mètode getPlacesParquing.
     * @return resultat del mètode
     */
    public int getPlacesParquing(){
        return this.placesParquing;
    }

    /**
     * Mètode isTerrassa.
     * @return resultat del mètode
     */
    public boolean isTerrassa(){
        return this.terrassa;
    }

    /**
     * Mètode isTV.
     * @return resultat del mètode
     */
    public boolean isTV(){
        return this.tv;
    }

    /**
     * Mètode isAireFred.
     * @return resultat del mètode
     */
    public boolean isAireFred(){
        return this.aireFred;
    }


    // Els setters
    /**
     * Mètode setPlacesParquingPlaces.
     * @param placesParquing paràmetre del mètode
     */
    public void setPlacesParquingPlaces(int placesParquing){
        this.placesParquing = placesParquing;
    }

    /**
     * Mètode setTerrassa.
     * @param terrassa paràmetre del mètode
     */
    public void setTerrassa(boolean terrassa){
        this.terrassa = terrassa;
    }

    /**
     * Mètode setTV.
     * @param tv paràmetre del mètode
     */
    public void setTV(boolean tv){
        this.tv = tv;
    }

    /**
     * Mètode setAireFred.
     * @param aireFred paràmetre del mètode
     */
    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() +
                ". Bungalow{" + "placesParquing=" + placesParquing + ", terrassa=" + terrassa +
                ", tv=" + tv + ", aireFred=" + aireFred + "}";
    }

    // El metodo funcionaCorrectament
    @Override
    /**
     * Mètode correcteFuncionament.
     * @return resultat del mètode
     */
    public boolean correcteFuncionament(){
        return aireFred;
    }
}