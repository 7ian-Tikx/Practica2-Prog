package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta base per a tots els tipus d'allotjament del càmping.
 */
public abstract class Allotjament implements InAllotjament, Serializable{
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean estat;
    private String iluminacio;

    // El constructor
    /**
     * Constructor de Allotjament.
     * @param nom paràmetre del mètode
     * @param id paràmetre del mètode
     * @param estadaMinimaALTA paràmetre del mètode
     * @param estadaMinimaBAIXA paràmetre del mètode
     * @param estat paràmetre del mètode
     * @param iluminacio paràmetre del mètode
     */
    public Allotjament(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA,boolean estat,String iluminacio){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estat = estat;
        this.iluminacio = iluminacio;
    }

    // Ara definim els getters
    /**
     * Mètode getNom.
     * @return resultat del mètode
     */
    public String getNom(){
       return this.nom;
    }

    /**
     * Mètode getId.
     * @return resultat del mètode
     */
    public String getId(){
        return this.id;
    }

    /**
     * Mètode getEstadaMinima.
     * @param temp paràmetre del mètode
     * @return resultat del mètode
     */
    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA){
            return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    }

    /**
     * Mètode isOperatiu.
     * @return resultat del mètode
     */
    public boolean isOperatiu(){
        return estat;
    }

    /**
     * Mètode getIluminacio.
     * @return resultat del mètode
     */
    public String getIluminacio() {
        return iluminacio;
    }

    // Els setter
    /**
     * Mètode setNom.
     * @param nom paràmetre del mètode
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * Mètode setId.
     * @param id paràmetre del mètode
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Mètode setEstadaMinima.
     * @param estadaMinimaALTA_ paràmetre del mètode
     * @param estadaMinimaBAIXA_ paràmetre del mètode
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;

    }

    /**
     * Mètode setOperatiu.
     * @param estat paràmetre del mètode
     */
    public void setOperatiu(boolean estat) {
        this.estat = estat;
    }

    /**
     * Mètode setIluminacio.
     * @param iluminacio paràmetre del mètode
     */
    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    // Aquest metodo es abstract porque cadascuna de les seves subclasses tindra els seus propis crites de funcionament
    public abstract boolean correcteFuncionament();

    @Override
    /**
     * Mètode toString.
     * @return resultat del mètode
     */
    public String toString(){
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }

    @Override
    /**
     * Mètode tancarAllotjament.
     * @param tasca paràmetre del mètode
     */
    public void tancarAllotjament(TascaManteniment tasca) {
        this.estat = false;
        TascaManteniment.TipusTascaManteniment tascaManteniment = tasca.getTipus();
        if (tascaManteniment == TascaManteniment.TipusTascaManteniment.Reparacio){
           this.iluminacio = "50%";
        }else if (tascaManteniment == TascaManteniment.TipusTascaManteniment.Neteja){
            this.iluminacio = "100%";
        }else if (tascaManteniment == TascaManteniment.TipusTascaManteniment.RevisioTecnica){
            this.iluminacio = "50%";
        }else{
            this.iluminacio = "0%";
        }
    }

    @Override
    /**
     * Mètode obrirAllotjament.
     */
    public void obrirAllotjament() {
       this.estat = true;
       this.iluminacio = "100%";
    }
}