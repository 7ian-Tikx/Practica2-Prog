package prog2.model;

/**
 * Representa un allotjament de tipus glamping.
 */
public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    // El constructor
    public Glamping(String nom, String id, boolean estat,String iluminacio,float mida,int habitacions,int placesPersones,
                    String material,boolean casaMascota){
        super(nom,id,3,3, estat,iluminacio,mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    // Els getters
    /**
     * Mètode getMaterial.
     * @return resultat del mètode
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Mètode isCasaMascota.
     * @return resultat del mètode
     */
    public boolean isCasaMascota() {
        return casaMascota;
    }

    // Els setters
    /**
     * Mètode setMaterial.
     * @param material paràmetre del mètode
     */
    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * Mètode setCasaMascota.
     * @param casaMascota paràmetre del mètode
     */
    public void setCasaMascota(boolean casaMascota){
        this.casaMascota = casaMascota;
    }

    // El metodo funcionaCorrectament
    @Override
    /**
     * Mètode correcteFuncionament.
     * @return resultat del mètode
     */
    public boolean correcteFuncionament(){
        return casaMascota;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() +
                ". Glamping{" + "material='" + material + "'" + ", casaMascota=" + casaMascota + "}";
    }
}