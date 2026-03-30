package prog2.model;

import prog2.vista.ExcepcioCamping;

public class VistaCamping {
    private Camping camping;

    public VistaCamping(String nomCamping){
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    public void afegirTascaManteniment(int numTasca, String tipus, String
            idAllotjament, String data, int dies) throws ExcepcioCamping{
        this.camping.afegirTascaManteniment(numTasca,tipus,idAllotjament,data,dies);
    }

    public void completarTascaManteniment(int numTasca) throws ExcepcioCamping {
        this.camping.completarTascaManteniment(numTasca);
    }

    public void gestioCamping(){
        return;
    }
}
