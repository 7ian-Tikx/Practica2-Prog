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
     * @param nom valor d'entrada
     * @param id valor d'entrada
     * @param estat valor d'entrada
     * @param iluminacio valor d'entrada
     * @param mida valor d'entrada
     * @param conexioElectrica valor d'entrada
     */
    public Parcela(String nom, String id, boolean estat, String iluminacio, float mida, boolean conexioElectrica) {
        super(nom, id, 4, 2, estat, iluminacio);
        this.conexioElectrica = conexioElectrica;
        this.mida = mida;
    }

    // Els getters i setters dels nous atributs
    /**
     * Operació isConnexioElectrica.
     * @return valor retornat
     */
    public boolean isConnexioElectrica() {
        return this.conexioElectrica;
    }

    /**
     * Operació getMida.
     * @return valor retornat
     */
    public double getMida() {
        return this.mida;
    }

    /**
     * Operació setConnexioElectrica.
     * @param conexioElectrica_ valor d'entrada
     */
    public void setConnexioElectrica(boolean conexioElectrica_) {
        this.conexioElectrica = conexioElectrica_;
    }

    /**
     * Operació setMida.
     * @param mida_ valor d'entrada
     */
    public void setMida(float mida_) {
        this.mida = mida_;
    }

        /**
     * Operació correcteFuncionament.
     * @return valor retornat
     */
    @Override
    public boolean correcteFuncionament() {
        return conexioElectrica;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() + "Parcela{mida=" + this.mida + ", connexioElectrica=" + this.conexioElectrica + "}";
    }

}