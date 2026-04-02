package prog2.model;

/**
 * Representa un bungalow premium amb serveis extra.
 */
public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

    // El constructor
    public BungalowPremium(String nom, String id, boolean estat,String iluminacio,
                    float mida,int habitacions,int placesPersones,int placesParquing,boolean terrassa,boolean tv,
                           boolean aireFred,boolean serveisExtra,String codiWifi){
        super(nom,id,estat,iluminacio,mida,habitacions,placesPersones,placesParquing,
                terrassa,tv,aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }


    // Els getters dels nous atributs
    /**
     * Operació isServeisExtra.
     * @return valor retornat
     */
    public boolean isServeisExtra(){
        return serveisExtra;
    }

    /**
     * Operació getCodiWifi.
     * @return valor retornat
     */
    public String getCodiWifi(){
        return codiWifi;
    }

    // Els setters dels nous atributs
    /**
     * Operació setServeisExtra.
     * @param serveisExtra valor d'entrada
     */
    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
    }

    /**
     * Operació setCodiWifi.
     * @param codiWifi valor d'entrada
     */
    public void setCodiWifi(String codiWifi){
        this.codiWifi = codiWifi;
    }


    // El metodo funcionaCorrectament
        /**
     * Operació correcteFuncionament.
     * @return valor retornat
     */
    @Override
    public boolean correcteFuncionament(){
        boolean codiCorrecte = codiWifi.length() >= 8 && codiWifi.length() <= 16;
        return codiCorrecte && super.isAireFred();
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString() {
        return super.toString() + ". BungalowPremium{" + "serveisExtra=" + serveisExtra + ", codiWifi='" + codiWifi + "'" + "}";
    }


}