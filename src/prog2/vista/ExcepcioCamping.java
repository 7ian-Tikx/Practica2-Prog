package prog2.vista;

public class ExcepcioCamping extends RuntimeException {
    /**
     * Constructor de ExcepcioCamping.
     * @param message paràmetre del mètode
     */
    public ExcepcioCamping(String message) {
        super(message);
    }
}
