package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean estat;
    private String iluminacio;

    // El constructor
    public Allotjament(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA,boolean estat,String iluminacio){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estat = estat;
        this.iluminacio = iluminacio;
    }

    // Ara definim els getters
    public String getNom(){
       return this.nom;
    }

    public String getId(){
        return this.id;
    }

    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA){
            return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    }

    public boolean isOperatiu(){
        return estat;
    }

    public String getIluminacio() {
        return iluminacio;
    }

    // Els setter
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setId(String id){
        this.id = id;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;

    }

    public void setOperatiu(boolean estat) {
        this.estat = estat;
    }

    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    // Aquest metodo es abstract porque cadascuna de les seves subclasses tindra els seus propis crites de funcionament
    public abstract boolean correcteFuncionament();

    @Override
    public String toString(){
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }
}