package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{
    private ArrayList<Reserva> llistaReserves;

    //Fem el seu constructor
    public LlistaReserves(){
        this.llistaReserves = new ArrayList<>();
    }
    //Fem el seu getter i setter
    public ArrayList getLlistaReserves(){
        return this.llistaReserves;
    }
    public void setLlistaReserves(ArrayList<Reserva> llistaReserves){
        this.llistaReserves = llistaReserves;
    }
    //Implementam metode allotjamentDisponible
    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

    }
    //Implementam metode isEstadaMinima
    public boolean isEstadaMinima (Allotjament allotjament,LocalDate dataEntrada,LocalDate dataSortida){

    }
}