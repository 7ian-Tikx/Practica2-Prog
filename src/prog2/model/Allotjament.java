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
     * @param nom nom de l'entitat
     * @param id identificador únic
     * @param estadaMinimaALTA valor d'entrada associat a l'operació
     * @param estadaMinimaBAIXA valor d'entrada associat a l'operació
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     * @param iluminacio nivell d'il·luminació de l'allotjament
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
    * Retorna el nom de l'accés
    * @return
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
     * @param temp temporada a consultar (ALTA o BAIXA)
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
     * @param nom nom de l'entitat
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * Operació setId.
     * @param id identificador únic
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Operació setEstadaMinima.
     * @param estadaMinimaALTA_ valor d'entrada associat a l'operació
     * @param estadaMinimaBAIXA_ valor d'entrada associat a l'operació
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;

    }

    /**
     * Operació setOperatiu.
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     */
    public void setOperatiu(boolean estat) {
        this.estat = estat;
    }

    /**
     * Operació setIluminacio.
     * @param iluminacio nivell d'il·luminació de l'allotjament
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
    * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
    * @param tasca tasca de manteniment
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
    * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
    */
    @Override
    public void obrirAllotjament() {
       this.estat = true;
       this.iluminacio = "100%";
    }
}
