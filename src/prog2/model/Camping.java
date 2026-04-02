package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

/**
 * Classe principal del domini del càmping Green.
 * Gestiona allotjaments, accessos, tasques de manteniment i persistència de dades.
 *
 * @author Jinjie Chen
 */
public class Camping implements InCamping,Serializable{
    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;
    private LlistaReserves llistaReserves;
    private ArrayList<Client> llistaClients;



    /**
     * Constructor de Camping.
     *
     * @param nomCamping nom del càmping
     */
    public Camping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
        this.llistaReserves = new LlistaReserves();
        this.llistaClients = new ArrayList<>();

    }

    /**
     * Actualitza el nom del càmping.
     *
     * @param nom nou nom
     */
    public void setNomCamping(String nom){
        this.nomCamping = nom;
    }
    /**
     * Retorna el nom del càmping.
     *
     * @return nom del càmping
     */
    public String getNomCamping(){
        return this.nomCamping;
    }


    /*
    // Fem el mètode buscarAllotjament
    /**
     * Mètode buscarAllotjament.
     * @param Id paràmetre del mètode
     * @return resultat del mètode
     */
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
    /**
     * Mètode buscarClient.
     * @param DNI paràmetre del mètode
     * @return resultat del mètode
     */
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

    */
    /**
     * Calcula la temporada segons una data.
     *
     * @param data data a comprovar
     * @return {@link InAllotjament.Temp#ALTA} o {@link InAllotjament.Temp#BAIXA}
     */
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

    /*
    /**
     * Mètode getNumAllotjaments.
     * @return resultat del mètode
     */
    public int getNumAllotjaments() {
        return this.allotjaments.size();
    }

    /**
     * Mètode getNumReserves.
     * @return resultat del mètode
     */
    public int getNumReserves() {
        return this.llistaReserves.getNumReserves();
    }

    /**
     * Mètode getNumClients.
     * @return resultat del mètode
     */
    public int getNumClients() {
        return this.clients.size();
    }

    /**
     * Mètode afegirClient.
     * @param nom_ paràmetre del mètode
     * @param dni_ paràmetre del mètode
     */
    public void afegirClient(String nom_, String dni_) {
        Client  client = new Client(nom_, dni_);
        this.clients.add(client);
    }

    /**
     * Mètode afegirParcela.
     * @param nom_ paràmetre del mètode
     * @param idAllotjament_ paràmetre del mètode
     * @param metres paràmetre del mètode
     * @param connexioElectrica paràmetre del mètode
     */
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.allotjaments.add(parcela);
    }

    /**
     * Mètode afegirBungalow.
     * @param nom_ paràmetre del mètode
     * @param idAllotjament_ paràmetre del mètode
     * @param mida paràmetre del mètode
     * @param habitacions paràmetre del mètode
     * @param placesPersones paràmetre del mètode
     * @param placesParquing paràmetre del mètode
     * @param terrassa paràmetre del mètode
     * @param tv paràmetre del mètode
     * @param aireFred paràmetre del mètode
     */
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.allotjaments.add(bungalow);
    }
    /**
     * Mètode afegirBungalowPremium.
     * @param nom_ paràmetre del mètode
     * @param idAllotjament_ paràmetre del mètode
     * @param mida paràmetre del mètode
     * @param habitacions paràmetre del mètode
     * @param placesPersones paràmetre del mètode
     * @param placesParquing paràmetre del mètode
     * @param terrassa paràmetre del mètode
     * @param tv paràmetre del mètode
     * @param aireFred paràmetre del mètode
     * @param serveisExtra paràmetre del mètode
     * @param codiWifi paràmetre del mètode
     */
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        BungalowPremium bungalowPremium = new BungalowPremium(nom_,idAllotjament_,mida,habitacions,placesPersones,placesParquing,terrassa,tv,aireFred,serveisExtra,codiWifi);
        this.allotjaments.add(bungalowPremium);
    }
    /**
     * Mètode afegirGlamping.
     * @param nom_ paràmetre del mètode
     * @param idAllotjament_ paràmetre del mètode
     * @param mida paràmetre del mètode
     * @param habitacions paràmetre del mètode
     * @param placesPersones paràmetre del mètode
     * @param material paràmetre del mètode
     * @param casaMascota paràmetre del mètode
     */
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_,idAllotjament_,mida,habitacions,placesPersones,material,casaMascota);
        this.allotjaments.add(glamping);
    }
    /**
     * Mètode afegirMobilHome.
     * @param nom_ paràmetre del mètode
     * @param idAllotjament_ paràmetre del mètode
     * @param mida paràmetre del mètode
     * @param habitacions paràmetre del mètode
     * @param placesPersones paràmetre del mètode
     * @param terrassaBarbacoa paràmetre del mètode
     */
    public  void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_,idAllotjament_,mida,habitacions,placesPersones,terrassaBarbacoa);
        this.allotjaments.add(mobilHome);
    }
    /**
     * Mètode afegirReserva.
     * @param id_ paràmetre del mètode
     * @param dni_ paràmetre del mètode
     * @param dataEntrada paràmetre del mètode
     * @param dataSortida paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
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

    /**
     * Mètode calculAllotjamentsOperatius.
     * @return resultat del mètode
     */
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

    /**
     * Mètode getAllotjamentEstadaMesCurta.
     * @param temp paràmetre del mètode
     * @return resultat del mètode
     */
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
    */


    // -------------------------------------------------------Els metodes nous-----------------------------------------------------------

    /**
     * Llista allotjaments filtrats per estat.
     *
     * @param estat "Operatiu" o "No operatiu"
     * @return text amb la informació dels allotjaments filtrats
     * @throws ExcepcioCamping si l'estat no és vàlid o no hi ha resultats
     */
    @Override
    /**
     * Mètode llistarAllotjaments.
     * @param estat paràmetre del mètode
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
       return this.llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista accessos filtrats per estat.
     *
     * @param infoEstat "Obert" o "Tancat"
     * @return text amb la informació dels accessos filtrats
     * @throws ExcepcioCamping si l'estat indicat no és vàlid
     */
    @Override
    /**
     * Mètode llistarAccessos.
     * @param infoEstat paràmetre del mètode
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
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

    /**
     * Llista totes les tasques de manteniment actives.
     *
     * @return text amb les tasques actives
     * @throws ExcepcioCamping si no hi ha cap tasca registrada
     */
    @Override
    /**
     * Mètode llistarTasquesManteniment.
     * @return resultat del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca de manteniment sobre un allotjament.
     *
     * @param num número identificador de la tasca
     * @param tipus tipus de tasca (Reparacio, Neteja, RevisioTecnica o Desinfeccio)
     * @param idAllotjament identificador de l'allotjament
     * @param data data de la tasca
     * @param dies dies previstos de durada
     * @throws ExcepcioCamping si les dades no són vàlides o l'allotjament no existeix
     */
    @Override
    /**
     * Mètode afegirTascaManteniment.
     * @param num paràmetre del mètode
     * @param tipus paràmetre del mètode
     * @param idAllotjament paràmetre del mètode
     * @param data paràmetre del mètode
     * @param dies paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment existent.
     *
     * @param num número de la tasca a completar
     * @throws ExcepcioCamping si la tasca no existeix
     */
    @Override
    /**
     * Mètode completarTascaManteniment.
     * @param num paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);
        llistaTasquesManteniment.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre total d'accessos sense accessibilitat amb vehicle.
     *
     * @return nombre d'accessos no accessibles
     */
    @Override
    /**
     * Mètode calculaAccessosNoAccessibles.
     * @return resultat del mètode
     */
    public int calculaAccessosNoAccessibles(){
        return llistaAccessos.calculaAccessosNoAccessibles();
    }
    /**
     * Calcula els metres totals dels accessos de tipus terra.
     *
     * @return metres totals d'accessos de terra
     */
    @Override
    /**
     * Mètode calculaMetresTerra.
     * @return resultat del mètode
     */
    public float calculaMetresTerra(){
        return llistaAccessos.calculaMetresTerra();
    }

    /**
     * Guarda l'estat del càmping en un fitxer.
     *
     * @param fitxerFI ruta del fitxer destí
     * @throws ExcepcioCamping si es produeix un error d'E/S
     */
    @Override
    /**
     * Mètode save.
     * @param fitxerFI paràmetre del mètode
     * @throws ExcepcioCamping en cas d'error
     */
    public void save(String fitxerFI) throws ExcepcioCamping{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxerFI))){
            oos.writeObject(this);

        }
        catch(IOException e){
            throw new ExcepcioCamping(e.getMessage());
        }
    }
    /**
     * Carrega un objecte {@link Camping} des d'un fitxer.
     *
     * @param fitxerOR ruta del fitxer origen
     * @return instància carregada de {@link Camping}
     * @throws ExcepcioCamping si es produeix un error de lectura o de tipus
     */
    public static Camping load(String fitxerOR) throws ExcepcioCamping{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxerOR))){
            return (Camping) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            throw new ExcepcioCamping(e.getMessage());
        }
    }


    /**
     * Inicialitza totes les dades base del càmping (allotjaments i accessos).
     */
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