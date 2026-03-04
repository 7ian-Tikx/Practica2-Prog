package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;

    // El constructor
    public Glamping(String nom, String id, String mida,int habitacions,int placesPersones,
                    String material,boolean casaMascota){
        super(nom,id,3,3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    // Els getters
    public String getMaterial() {
        return material;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }

    // Els setters
    public void setMaterial(String material){
        this.material = material;
    }

    public void setCasaMascota(boolean casaMascota){
        this.casaMascota = casaMascota;
    }

    // El metodo funcionaCorrectament
    @Override
    public boolean correcteFuncionament(){
        return casaMascota;
    }

    @Override
    public String toString() {
        return super.toString() +
                ". Glamping{" + "material='" + material + "'" + ", casaMascota=" + casaMascota + "}";
    }
}