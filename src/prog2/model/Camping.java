package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList <Client> clients;
    private LlistaReserves llistaReserves;

    //Fem el constructor de Camping
    public Camping(String nom) {
        this.nom = nom;
    }

    //Fel els setters i getters
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return this.allotjaments;
    }
    public ArrayList<Client> getLlistaClients(){
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

    @Override
    public int getNumAllotjaments() {
        return this.allotjaments.size();
    }

    @Override
    public int getNumReserves() {
        return this.llistaReserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return this.clients.size();
    }
    @Override
    public void afegirClient(String nom_, String dni_) {
        Client  client = new Client(nom_, dni_);
        this.clients.add(client);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.allotjaments.add(parcela);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.allotjaments.add(bungalow);
    }
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        BungalowPremium bungalowPremium = new BungalowPremium(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing,terrassa,tv,aireFred,serveisExtra,codiWifi);
        this.allotjaments.add(bungalowPremium);
    }
    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_,idAllotjament_,mida,habitacions,placesPersones,material,casaMascota);
        this.allotjaments.add(glamping);
    }
    @Override
    public  void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_,idAllotjament_,mida,habitacions,placesPersones,terrassaBarbacoa);
        this.allotjaments.add(mobilHome);
    }
    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);

        if(allotjament == null || client == null){
            throw new ExcepcioReserva("No s'ha trobat cap allotjament/client amb aquest id/dni");
        }

        this.llistaReserves.afegirReserva(allotjament,client,dataEntrada,dataSortida);

    }

    @Override
    public  int calculAllotjamentsOperatius(){
       int comptador = 0;
       Iterator<Allotjament> iterator = this.allotjaments.iterator();

       while(iterator.hasNext()){
           Allotjament allotjament = iterator.next();

           if(allotjament.correcteFuncionament()){
               comptador++;
           }
       }
       return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        long estadaCurta = 1000000;
        Allotjament allotjamentEstadaMesCurta = null;
        Allotjament allotjamentAuxiliar = null;

        Iterator<Allotjament> iterator = this.allotjaments.iterator();

        while(iterator.hasNext()){
            allotjamentAuxiliar = iterator.next();

            if(allotjamentAuxiliar.getEstadaMinima(temp) < estadaCurta){
                allotjamentEstadaMesCurta = allotjamentAuxiliar;
                estadaCurta = allotjamentAuxiliar.getEstadaMinima(temp);
            }
        }
        return allotjamentEstadaMesCurta;

    }

}