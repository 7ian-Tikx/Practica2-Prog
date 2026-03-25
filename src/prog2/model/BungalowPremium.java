package prog2.model;

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

    // El constructor
    public BungalowPremium(String nom, String id, boolean estat,String iluminacio,
                    String mida,int habitacions,int placesPersones,int placesParquing,boolean terrassa,boolean tv,
                           boolean aireFred,boolean serveisExtra,String codiWifi){
        super(nom,id,estat,iluminacio,mida,habitacions,placesPersones,placesParquing,
                terrassa,tv,aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }


    // Els getters dels nous atributs
    public boolean isServeisExtra(){
        return serveisExtra;
    }

    public String getCodiWifi(){
        return codiWifi;
    }

    // Els setters dels nous atributs
    public void setServeisExtra(boolean serveisExtra){
        this.serveisExtra = serveisExtra;
    }

    public void setCodiWifi(String codiWifi){
        this.codiWifi = codiWifi;
    }


    // El metodo funcionaCorrectament
    @Override
    public boolean correcteFuncionament(){
        boolean codiCorrecte = codiWifi.length() >= 8 && codiWifi.length() <= 16;
        return codiCorrecte && super.isAireFred();
    }

    @Override
    public String toString() {
        return super.toString() + ". BungalowPremium{" + "serveisExtra=" + serveisExtra + ", codiWifi='" + codiWifi + "'" + "}";
    }


}