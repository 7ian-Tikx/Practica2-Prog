package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    private ArrayList<Allotjament> allotjaments;
    private ArrayList <Client> clients;
    private String nom;

    //Fem el constructor de Camping
    public Camping(ArrayList<Allotjament> allotjaments,ArrayList <Client> clients,String nom) {

        Iterator<Allotjament> iterator = allotjaments.iterator();
        Iterator<Client> iterator1 = clients.iterator();

        this.nom = nom;
    }

    //Fem els iterators de allotjaments i clients

    public String getNom(){
        return this.nom;
    }

    //Fel els setters de allotjaments, clients i nom
    public void setAllotjaments(ArrayList<Allotjament> allotjaments){
        this.allotjaments = allotjaments;
    }
    public void setClients(ArrayList <Client> clients){
        this.clients = clients;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    // Fem el mètode buscarAllotjament
    public String buscarAllotjament(ArrayList<Allotjament> allotjaments){
            for(int i = 0; i < allotjaments.size(); i++){
                if(allotjaments.equals(nom)){
                }
            }
    }

    //Fem el mètode buscarClient
    public String buscarClient(ArrayList <Client> clients){

    }
    public static InAllotjament.Temp getTemporada(LocalDate data){

    }
}