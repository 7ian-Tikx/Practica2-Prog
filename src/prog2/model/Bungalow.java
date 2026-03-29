package prog2.model;

public class Bungalow extends Casa{
    private int placesParquing;
    boolean terrassa;
    boolean tv;
    private boolean aireFred;

    // El constructor
    public Bungalow(String nom, String id,boolean estat,String iluminacio, String mida,int habitacions,int placesPersones,int placesParquing,
                    boolean terrassa,boolean tv, boolean aireFred){
       super(nom,id,7,4,estat,iluminacio,mida,habitacions,placesPersones);
       this.placesParquing = placesParquing; // Un bungallow normal nomes te 1 places de parquing
       this.terrassa = terrassa;
       this.tv = tv;
       this.aireFred = aireFred;
    }

    // Els getters
    public int getPlacesParquing(){
        return this.placesParquing;
    }

    public boolean isTerrassa(){
        return this.terrassa;
    }

    public boolean isTV(){
        return this.tv;
    }

    public boolean isAireFred(){
        return this.aireFred;
    }


    // Els setters
    public void setPlacesParquingPlaces(int placesParquing){
        this.placesParquing = placesParquing;
    }

    public void setTerrassa(boolean terrassa){
        this.terrassa = terrassa;
    }

    public void setTV(boolean tv){
        this.tv = tv;
    }

    public void setAireFred(boolean aireFred){
        this.aireFred = aireFred;
    }

    @Override
    public String toString() {
        return super.toString() +
                ". Bungalow{" + "placesParquing=" + placesParquing + ", terrassa=" + terrassa +
                ", tv=" + tv + ", aireFred=" + aireFred + "}";
    }

    // El metodo funcionaCorrectament
    @Override
    public boolean correcteFuncionament(){
        return aireFred;
    }
}