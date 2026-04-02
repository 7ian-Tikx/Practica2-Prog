package prog2.model;

/**
 * Representa un allotjament de tipus parcel·la.
 */
public class Parcela extends Allotjament {
    private boolean conexioElectrica;  // Si te o no un punt de connexio
    private float mida;

    // El constructor
    /**
     * Constructor de Parcela.
     * @param nom paràmetre del mètode
     * @param id paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param iluminacio paràmetre del mètode
     * @param mida paràmetre del mètode
     * @param conexioElectrica paràmetre del mètode
     */
    public Parcela(String nom, String id, boolean estat, String iluminacio, float mida, boolean conexioElectrica) {
        super(nom, id, 4, 2, estat, iluminacio);
        this.conexioElectrica = conexioElectrica;
        this.mida = mida;
    }

    // Els getters i setters dels nous atributs
    /**
     * Mètode isConnexioElectrica.
     * @return resultat del mètode
     */
    public boolean isConnexioElectrica() {
        return this.conexioElectrica;
    }

    /**
     * Mètode getMida.
     * @return resultat del mètode
     */
    public double getMida() {
        return this.mida;
    }

    /**
     * Mètode setConnexioElectrica.
     * @param conexioElectrica_ paràmetre del mètode
     */
    public void setConnexioElectrica(boolean conexioElectrica_) {
        this.conexioElectrica = conexioElectrica_;
    }

    /**
     * Mètode setMida.
     * @param mida_ paràmetre del mètode
     */
    public void setMida(float mida_) {
        this.mida = mida_;
    }

    @Override
    /**
     * Mètode correcteFuncionament.
     * @return resultat del mètode
     */
    public boolean correcteFuncionament() {
        return conexioElectrica;
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() + "Parcela{mida=" + this.mida + ", connexioElectrica=" + this.conexioElectrica + "}";
    }

}