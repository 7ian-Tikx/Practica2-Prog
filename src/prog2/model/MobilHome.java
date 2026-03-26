package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;

    // El constructor
    public MobilHome(String nom, String id, boolean estat,String iluminacio,String mida,int habitacions,
                     int placesPersones,boolean terrassaBarbacoa){
        super(nom,id,5,3,estat,iluminacio, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Els getters
    public boolean isCasaMascota() {
        return terrassaBarbacoa;
    }

    // Els setters
    public void setCasaMascota(boolean terrassaBarbacoa){
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // El metodo funcionaCorrectament
    @Override
    public boolean correcteFuncionament(){
        return terrassaBarbacoa;
    }

    @Override
    public String toString() {
        return super.toString() + ". MobilHome{" + "material='" + ", terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }