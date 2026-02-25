package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    // El constructor
    public Allotjament(String nom, String id, long estadaMinimaALTA,long estadaMinimaBAIXA){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    // Ara definim els getters i setters
    public String getNom(){
       return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA){
           return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    }

    public) void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.estadaMinimaALTA = estadaMinimaALTA_;

    }

    // Aquest metodo es abstract porque cadascuna de les seves subclasses tindra els seus propis crites de funcionament
    public abstract boolean correcteFuncionament();

    @Override
    public String toString( {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA;
    }
}