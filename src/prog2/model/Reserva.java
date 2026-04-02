package prog2.model;

import java.io.Serializable;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

/**
 * Representa una reserva d'un allotjament per un client.
 */
public class Reserva implements Serializable{

    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private Client client;
    private Allotjament allotjament;

    //Fem el constructor de Reserva
    /**
     * Constructor de Reserva.
     * @param allotjament allotjament associat
     * @param client client associat
     * @param dataEntrada data d'entrada de la reserva
     * @param dataSortida data de sortida de la reserva
     * @throws ExcepcioReserva en cas d'error
     */
    public Reserva(Allotjament allotjament,Client client,LocalDate dataEntrada,LocalDate dataSortida) throws ExcepcioReserva{

        if(dataSortida.isBefore(dataEntrada)){
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
        this.client = client;
        this.allotjament = allotjament;
    }
    //Fem els getter de dataEntrada,dataSortida,client i allotjament
    /**
     * Operació getDataEntrada.
     * @return valor retornat
     */
    public LocalDate getDataEntrada(){
        return this.dataEntrada;
    }
    /**
     * Operació getDataSortida.
     * @return valor retornat
     */
    public LocalDate getDataSortida(){
        return this.dataSortida;
    }
    /**
     * Operació getClient.
     * @return valor retornat
     */
    public Client getClient(){
        return this.client;
    }
    /**
     * Operació getAllotjament_.
     * @return valor retornat
     */
    public Allotjament getAllotjament_(){
        return this.allotjament;
    }

    //Fem els setters de dataEntrada,dataSortida,client i allotjament
    /**
     * Operació setDataEntrada.
     * @param dataEntrada data d'entrada de la reserva
     */
    public void setDataEntrada(LocalDate dataEntrada){
        this.dataEntrada = dataEntrada;
    }
    /**
     * Operació setDataSortida.
     * @param dataSortida data de sortida de la reserva
     */
    public void setDataSortida(LocalDate dataSortida){
        this.dataSortida = dataSortida;
    }
    /**
     * Operació setClient.
     * @param client client associat
     */
    public void setClient(Client client){
        this.client = client;
    }
    /**
     * Operació setAllotjament_.
     * @param allotjament allotjament associat
     */
    public void setAllotjament_(Allotjament allotjament){
        this.allotjament = allotjament;
    }

    public static interface InTascaManteniment {

        /**
         * Retorna el número identificador de la tasca.
         * @return int
         */
        int getNum();

        /**
         * Retorna el tipus de tasca de manteniment.
         * @return TipusTascaManteniment
         */
        TascaManteniment.TipusTascaManteniment getTipus();

        /**
         * Retorna l'allotjament associat a la tasca.
         * @return Allotjament
         */
        Allotjament getAllotjament();

        /**
         * Retorna la data de registre de la tasca.
         * @return String
         */
        String getData();

        /**
         * Retorna el nombre de dies previstos per completar la tasca.
         * @return int
         */
        int getDies();

        /**
         * Assigna un nou número identificador a la tasca.
         * @param num_ número identificador de la tasca
         */
        void setNum(int num_);

        /**
         * Assigna el tipus de tasca de manteniment.
         * @param tipus_ tipus de tasca de manteniment
         */
        void setTipus(TascaManteniment.TipusTascaManteniment tipus_);

        /**
         * Assigna l'allotjament associat a la tasca.
         * @param allotjament_ allotjament associat
         */
        void setAllotjament(Allotjament allotjament_);

        /**
         * Assigna la data de registre de la tasca.
         * @param data_ data de la tasca o operació
         */
        void setData(String data_);

        /**
         * Assigna el nombre de dies previstos per completar la tasca.
         * @param dies_ dies previstos o durada en dies
         */
        void setDies(int dies_);

        /**
         * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
         * segons el tipus de tasca de manteniment.
         * @return String amb el percentatge d'il·luminació.
         */
        String getIluminacioAllotjament();

    }
}
