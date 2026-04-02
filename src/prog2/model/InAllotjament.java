
package prog2.model;

/**
 * Interfície que defineix les operacions bàsiques per als allotjaments.
 */
public interface InAllotjament {

    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    String getNom();

    /**
     * Estableix el nom de l'allotjament.
     * @param nom nom de l'entitat
     */
    void setNom(String nom);

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    String getId();

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id identificador únic
     */
    void setId(String id);

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp temporada a consultar (ALTA o BAIXA)
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    long getEstadaMinima(Temp temp);

    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ valor d'entrada associat a l'operació
     * @param estadaMinimaBAIXA_ valor d'entrada associat a l'operació
     */
    void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_);

    /**
     * Enumeració que representa les diferents temporades possibles.
     */
    public enum Temp {
        ALTA,
        BAIXA
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     * @param tasca tasca de manteniment
     */
    public void tancarAllotjament(TascaManteniment tasca);

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    public void obrirAllotjament();
}