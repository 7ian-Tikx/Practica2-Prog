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
     * Operació getMaterial.
     * @return valor retornat
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Operació isCasaMascota.
     * @return valor retornat
     */
    public boolean isCasaMascota() {
        return casaMascota;
    }

    // Els setters
    /**
     * Operació setMaterial.
     * @param material material principal de l'allotjament
     */
    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * Operació setCasaMascota.
     * @param casaMascota indica si hi ha casa per a mascota
     */
    public void setCasaMascota(boolean casaMascota){
        this.casaMascota = casaMascota;
    }

    // El metodo funcionaCorrectament
        /**
     * Operació correcteFuncionament.
     * @return valor retornat
     */
    @Override
    public boolean correcteFuncionament(){
        return casaMascota;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() +
                ". Glamping{" + "material='" + material + "'" + ", casaMascota=" + casaMascota + "}";
    }
}