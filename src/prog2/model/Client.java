package prog2.model;

public class Client {
    private String nom;
    private String DNI;

    //Fem el constructor de la clase Client
    public Client(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }
    //Fem els getters de Nom i DNI
    public String getNom(){
        return this.nom;
    }
    public String getDni(){
        return this.DNI;
    }
    //Fem els setters del Nom i DNI
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setDni(String DNI){
        this.DNI = DNI;
    }
    //Fem el metode toString per imprimir les informacions
    public String toString(String nom, String DNI){
        return nom + " amb DNI: " + DNI + ". ";
    }
}