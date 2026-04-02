package prog2.vista;

public class ExcepcioCamping extends RuntimeException {
    /**
     * Constructor de ExcepcioCamping.
     * @param message valor d'entrada associat a l'operació
     */
    public ExcepcioCamping(String message) {
        super(message);
    }
}
