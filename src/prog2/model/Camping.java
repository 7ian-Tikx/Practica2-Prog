package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping,Serializable{
    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;
    private LlistaReserves llistaReserves;
    private ArrayList<Client> llistaClients;



    //Fem el constructor de Camping
    public Camping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
        this.llistaReserves = new LlistaReserves();
        this.llistaClients = new ArrayList<>();

    }

    //Fel els setters i getters
    public void setNomCamping(String nom){
        this.nomCamping = nom;
    }
    public String getNomCamping(){
        return this.nomCamping;
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

    public int getNumAllotjaments() {
        return this.allotjaments.size();
    }

    public int getNumReserves() {
        return this.llistaReserves.getNumReserves();
    }

    public int getNumClients() {
        return this.clients.size();
    }

    public void afegirClient(String nom_, String dni_) {
        Client  client = new Client(nom_, dni_);
        this.clients.add(client);
    }

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.allotjaments.add(parcela);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.allotjaments.add(bungalow);
    }
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        BungalowPremium bungalowPremium = new BungalowPremium(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing,terrassa,tv,aireFred,serveisExtra,codiWifi);
        this.allotjaments.add(bungalowPremium);
    }
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_,idAllotjament_,mida,habitacions,placesPersones,material,casaMascota);
        this.allotjaments.add(glamping);
    }
    public  void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_,idAllotjament_,mida,habitacions,placesPersones,terrassaBarbacoa);
        this.allotjaments.add(mobilHome);
    }
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioCamping {
        Allotjament allotjament = buscarAllotjament(id_);
        Client client = buscarClient(dni_);

        if (client == null) {
            throw new ExcepcioCamping("El client amb DNI " + dni_ + " no existeix");
        } else if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament amb id " + id_ + " no existeix");
        } else {
            this.llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);

        }
    }

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


    // -------------------------------------------------------Els metodes nous-----------------------------------------------------------

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
       return this.llistaAllotjaments.llistarAllotjaments(estat);
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean estat;
        if ("Obert".equalsIgnoreCase(infoEstat)) {
            estat = true;
        } else if ("Tancat".equalsIgnoreCase(infoEstat)) {
            estat = false;
        } else {
            throw new ExcepcioCamping("L'estat de l'accés ha de ser 'Obert' o 'Tancat'");
        }

        return llistaAccessos.llistarAccessos(estat);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);
        llistaTasquesManteniment.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }




    public void inicialitzaDadesCamping() {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);


    }

}