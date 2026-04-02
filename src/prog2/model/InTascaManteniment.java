package prog2.model;

public interface InTascaManteniment {

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
