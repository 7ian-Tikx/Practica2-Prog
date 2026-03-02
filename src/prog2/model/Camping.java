package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList <Client> clients;
    private LlistaReserves llistaReserves;

    //Fem el constructor de Camping
    public Camping(String nom,ArrayList<Allotjament> allotjaments,ArrayList <Client> clients,LlistaReserves llistaReserves) {
        this.nom = nom;
        this.allotjaments = allotjaments;
        this.clients = clients;
        this.llistaReserves = llistaReserves;
    }

    //Fel els setters i getters
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    public ArrayList<Allotjament> getAllotjaments(){
        return this.allotjaments;
    }
    public ArrayList<Client> getClients(){
        return this.clients;
    }
    public LlistaReserves getLlistaReserves(){
        return this.llistaReserves;
    }

    // Fem el mètode buscarAllotjament
    public Allotjament buscarAllotjament(String Id){
        Iterator<Allotjament> iterator = allotjaments.iterator();

        while(iterator.hasNext()){
            Allotjament allotjament = iterator.next();

            if(allotjament.getId().equals(Id)){
                return allotjament;
            }
        }
        return null;
    }

    //Fem el mètode buscarClient
    public Client buscarClient(String DNI){
        Iterator<Client> iterator = clients.iterator();

        while(iterator.hasNext()){
            Client client = iterator.next();

            if(client.getDni().equals(DNI)){
                return client;
            }
        }
        return null;
    }
    public static InAllotjament.Temp getTemporada(LocalDate data){
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();

        if((mes == 3 && dia >= 21) || (mes == 9 && dia <= 20) || (mes > 3 && mes < 9)){
            return InAllotjament.Temp.ALTA;
        }
        else{
            return InAllotjament.Temp.BAIXA;
        }


    }
}