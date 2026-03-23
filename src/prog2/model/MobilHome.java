package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa;

    // El constructor
    public MobilHome(String nom, String id, String mida,int habitacions,
                     int placesPersones,boolean terrassaBarbacoa){
        super(nom,id,5,3, mida, habitacions, placesPersones);
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

    /**
     *
     * @author lauraigual
     */
    public static class IniciadorCamping {

        /**
         * @param args the command line arguments
         */
            public static void main(String[] args) {
            // Definim el nom del càmping
            String nomCamping = "Green";

            // Creem un objecte de la vista i li passem el nom del càmping
            VistaCamping vistaCamping = new VistaCamping(nomCamping);

            // Inicialitzem l'execució de la vista
            vistaCamping.gestioCamping();
        }
    }
}