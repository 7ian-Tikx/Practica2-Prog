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
     * @param nom valor d'entrada
     * @param id valor d'entrada
     * @param estadaMinimaALTA valor d'entrada
     * @param estadaMinimaBAIXA valor d'entrada
     * @param estat valor d'entrada
     * @param iluminacio valor d'entrada
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
     * Operació getNom.
     * @return valor retornat
     */
    public String getNom(){
       return this.nom;
    }

    /**
     * Operació getId.
     * @return valor retornat
     */
    public String getId(){
        return this.id;
    }

    /**
     * Operació getEstadaMinima.
     * @param temp valor d'entrada
     * @return valor retornat
     */
    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA){
            return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    }

    /**
     * Operació isOperatiu.
     * @return valor retornat
     */
    public boolean isOperatiu(){
        return estat;
    }

    /**
     * Operació getIluminacio.
     * @return valor retornat
     */
    public String getIluminacio() {
        return iluminacio;
    }

    // Els setter
    /**
     * Operació setNom.
     * @param nom valor d'entrada
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * Operació setId.
     * @param id valor d'entrada
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Operació setEstadaMinima.
     * @param estadaMinimaALTA_ valor d'entrada
     * @param estadaMinimaBAIXA_ valor d'entrada
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;

    }

    /**
     * Operació setOperatiu.
     * @param estat valor d'entrada
     */
    public void setOperatiu(boolean estat) {
        this.estat = estat;
    }

    /**
     * Operació setIluminacio.
     * @param iluminacio valor d'entrada
     */
    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    // Aquest metodo es abstract porque cadascuna de les seves subclasses tindra els seus propis crites de funcionament
    public abstract boolean correcteFuncionament();

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString(){
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }

        /**
     * Operació tancarAllotjament.
     * @param tasca valor d'entrada
     */
    @Override
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

        /**
     * Operació obrirAllotjament.
     */
    @Override
    public void obrirAllotjament() {
       this.estat = true;
       this.iluminacio = "100%";
    }
}