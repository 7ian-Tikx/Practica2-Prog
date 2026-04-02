package prog2.model;

/**
 * Representa un allotjament de tipus mobil-home.
 */
public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;

    // El constructor
    public MobilHome(String nom, String id, boolean estat, String iluminacio, float mida, int habitacions,
                     int placesPersones, boolean terrassaBarbacoa) {
        super(nom, id, 5, 3, estat, iluminacio, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Els getters
    /**
     * Mètode isTerrassaBarbacoa.
     * @return resultat del mètode
     */
    public boolean isTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    // Els setters
    /**
     * Mètode setTerrassaBarbacoa.
     * @param terrassaBarbacoa paràmetre del mètode
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // El metodo funcionaCorrectament
    @Override
    /**
     * Mètode correcteFuncionament.
     * @return resultat del mètode
     */
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() + ". MobilHome{" + "material='" + ", terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}