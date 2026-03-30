package prog2.model;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean accessibilitat, boolean estat, LlistaAllotjaments llistaAllotjaments) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat;
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els setters

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAccessibilitat(boolean accessibilitat){
        this.accessibilitat = accessibilitat;
    }

    public void setEstat(boolean estat){
        this.estat = estat;
    }

    public void setLlistaAllotjaments(LlistaAllotjaments llistaAllotjaments){
        this.llistaAllotjaments = llistaAllotjaments;
    }

    //fem els getters

    public String getNom(){
        return this.nom;
    }

    public boolean getAccessibilitat(){
        return this.accessibilitat;
    }

    public boolean getEstat(){
        return this.estat;
    }

    public LlistaAllotjaments getLlistaAllotjaments(){
        return this.llistaAllotjaments;
    }
    @Override
    public String toString(){
        String access = "";
        String estats = "";
        if(this.accessibilitat) {
            access = "Sí";
        }
        else{
                access = "No";
        }

        if(this.estat){
            estats = "Obert";
        }
        else{
            estats = "Tancat";
        }
        return ("nom: " + this.nom + " , " + "accessibilitat: " + access + " , "+ "estat : " + estats);
   }

}

