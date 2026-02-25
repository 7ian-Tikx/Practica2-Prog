package prog2.model;

import java.time.LocalDate;

public class Reserva{

    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private Client client;
    private Allotjament allotjament;

    //Fem el constructor de Reserva
    public Reserva(LocalDate dataEntrada,LocalDate dataSortida, Client client, Allotjament allotjament){
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
        this.client = client;
        this.allotjament = allotjament;
    }
    //Fem els getter de dataEntrada,dataSortida,client i allotjament
    public LocalDate dataEntrada(){
        return this.dataEntrada;
    }
    public LocalDate dataSortida(){
        return this.dataSortida;
    }
    public Client client(){
        return this.client;
    }
    public Allotjament allotjament(){
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
    public void setAllotjament(Allotjament allotjament){
        this.allotjament = allotjament;
    }
}
