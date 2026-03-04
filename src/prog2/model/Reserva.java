package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva{

    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private Client client;
    private Allotjament allotjament;

    //Fem el constructor de Reserva
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
    public LocalDate getDataEntrada(){
        return this.dataEntrada;
    }
    public LocalDate getDataSortida(){
        return this.dataSortida;
    }
    public Client getClient(){
        return this.client;
    }
    public Allotjament getAllotjament_(){
        return this.allotjament;
    }

    //Fem els setters de dataEntrada,dataSortida,client i allotjament
    public void setDataEntrada(LocalDate dataEntrada){
        this.dataEntrada = dataEntrada;
    }
    public void setDataSortida(LocalDate dataSortida){
        this.dataSortida = dataSortida;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public void setAllotjament_(Allotjament allotjament){
        this.allotjament = allotjament;
    }
}
