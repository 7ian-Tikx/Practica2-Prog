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
     * @param nom nom de l'entitat
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


    /**
     * Calcula la temporada segons una data.
     *
     * @param data data de la tasca o operació
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



    // -------------------------------------------------------Els metodes nous-----------------------------------------------------------

    /**
     * Llista allotjaments filtrats per estat.
     *
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     * @return text amb la informació dels allotjaments filtrats
     * @throws ExcepcioCamping si l'estat no és vàlid o no hi ha resultats
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
       return this.llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista accessos filtrats per estat.
     *
     * @param infoEstat text de l'estat a filtrar
     * @return text amb la informació dels accessos filtrats
     * @throws ExcepcioCamping si l'estat indicat no és vàlid
     */
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

    /**
     * Llista totes les tasques de manteniment actives.
     *
     * @return text amb les tasques actives
     * @throws ExcepcioCamping si no hi ha cap tasca registrada
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca de manteniment sobre un allotjament.
     *
     * @param num número identificador de la tasca
     * @param tipus tipus de tasca de manteniment
     * @param idAllotjament identificador de l'allotjament
     * @param data data de la tasca o operació
     * @param dies dies previstos o durada en dies
     * @throws ExcepcioCamping si les dades no són vàlides o l'allotjament no existeix
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment existent.
     *
     * @param num número identificador de la tasca
     * @throws ExcepcioCamping si la tasca no existeix
     */
    @Override
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
    public int calculaAccessosNoAccessibles(){
        return llistaAccessos.calculaAccessosNoAccessibles();
    }

    /**
     * Calcula els metres totals dels accessos de tipus terra.
     *
     * @return metres totals d'accessos de terra
     */
    @Override
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
