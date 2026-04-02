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
     * Mètode isServeisExtra.
     * @return resultat del mètode
     */
    public boolean isServeisExtra(){
        return serveisExtra;
    }

    /**
     * Mètode getCodiWifi.
     * @return resultat del mètode
     */
    public String getCodiWifi(){
        return codiWifi;
    }

    // Els setters dels nous atributs
    /**
     * Mètode setServeisExtra.
     * @param serveisExtra paràmetre del mètode
     */
    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
    }

    /**
     * Mètode setCodiWifi.
     * @param codiWifi paràmetre del mètode
     */
    public void setCodiWifi(String codiWifi){
        this.codiWifi = codiWifi;
    }


    // El metodo funcionaCorrectament
    @Override
    /**
     * Mètode correcteFuncionament.
     * @return resultat del mètode
     */
    public boolean correcteFuncionament(){
        boolean codiCorrecte = codiWifi.length() >= 8 && codiWifi.length() <= 16;
        return codiCorrecte && super.isAireFred();
    }

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString() {
        return super.toString() + ". BungalowPremium{" + "serveisExtra=" + serveisExtra + ", codiWifi='" + codiWifi + "'" + "}";
    }


}