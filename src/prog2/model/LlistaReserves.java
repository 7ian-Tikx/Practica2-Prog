package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import prog2.vista.ExcepcioReserva;

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
        for(int i = 0; i < llistaReserves.size();i++){
            Reserva reserva = llistaReserves.get(i);

            if(reserva.getAllotjament_().getId().equals(allotjament.getId())){
                if (dataEntrada.isBefore(reserva.getDataSortida()) && dataSortida.isAfter(reserva.getDataEntrada())){
                    return false;
                }
            }
        }
        return true;
    }
    //Implementam metode isEstadaMinima
    public boolean isEstadaMinima (Allotjament allotjament,LocalDate dataEntrada,LocalDate dataSortida) {
        long diesEstada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        InAllotjament.Temp temporadaActual = Camping.getTemporada(dataEntrada);

        if (temporadaActual == InAllotjament.Temp.ALTA) {
            if (diesEstada >= allotjament.getEstadaMinima(InAllotjament.Temp.ALTA)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (diesEstada >= allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA)) {
                return true;
            } else {
                return false;
            }
        }
    }

        @Override
        public void afegirReserva(Allotjament allotjament,Client client, LocalDate dataEntrada,LocalDate dataSortida)throws ExcepcioReserva{
            if(!allotjamentDisponible(allotjament,dataEntrada,dataSortida)){
                throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() + " no està disponible en la data demanada "
                        + dataEntrada + " pel client " + client.getNom() +  " amb DNI: " + client.getDni());
            }
            if(!isEstadaMinima(allotjament,dataEntrada,dataSortida)){
                throw new ExcepcioReserva("Les dates solicitades pel client " + client.getNom() + " amb DNI: " +
                        client.getDni() + " no compleixen l'estada minima per l'allotjament amb identificador " +
                        allotjament.getId() + ".");
            }

            Reserva reserva = new Reserva(allotjament,client,dataEntrada,dataSortida);
            llistaReserves.add(reserva);
        }


    }