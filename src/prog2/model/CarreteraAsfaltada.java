package prog2.model;

import java.util.ArrayList;

/**
 * Representa una carretera asfaltada amb accés de vehicle.
 */
public class CarreteraAsfaltada extends AccesAsfalt{

    private double pes;

    /**
     * Constructor de CarreteraAsfaltada.
     * @param nom nom de l'entitat
     * @param estat estat actual (obert/tancat o operatiu/no operatiu segons el context)
     * @param tamanyAsfalt metres quadrats d'asfalt
     * @param pes pes màxim admès per la carretera
     */
    public CarreteraAsfaltada(String nom, boolean estat, float tamanyAsfalt,double pes){
        super(nom, estat, tamanyAsfalt);
        this.pes = pes;
    }

    // fem els setters

    /**
     * Operació setPes.
     * @param pes pes màxim admès per la carretera
     */
    public void setPes(double pes){
        this.pes = pes;
    }

    // fem els

    /**
     * Operació getPes.
     * @return valor retornat
     */
    public double getPes(){
        return this.pes;
    }
    /**
    * Retorna si l'accés permet accessibilitat amb cotxe o no.
    * @return 
    */
    @Override
    public boolean isAccessibilitat(){
        return true;
    }

        /**
     * Operació toString.
     * @return valor retornat
     */
    @Override
    public String toString(){
        return super.toString() + " , " + " pes: " + this.pes;
    }
}
