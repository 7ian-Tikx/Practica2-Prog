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
     * Operació isTerrassaBarbacoa.
     * @return valor retornat
     */
    public boolean isTerrassaBarbacoa() {
        return terrassaBarbacoa;
    }

    // Els setters
    /**
     * Operació setTerrassaBarbacoa.
     * @param terrassaBarbacoa indica si té terrassa amb barbacoa
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // El metodo funcionaCorrectament
        /**
     * Operació correcteFuncionament.
     * @return valor retornat
     */
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() + ". MobilHome{" + "material='" + ", terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}