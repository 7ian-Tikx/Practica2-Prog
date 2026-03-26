package prog2.model;

public class VistaCamping {
    private Camping camping;

    public VistaCamping(String nomCamping){
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    public void afegirTascaManteniment(int numTasca, String tipus, String
            idAllotjament, String data, int dies) throws ExcepcioCamping{
        return;
    }

    public void completarTascaManteniment(int numTasca) throws ExcepcioCamping{
        return;
    }
}
