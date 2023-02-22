/**
 * classe métier de la gestion d'infos
 * @outhour Bilal Azizi
 * @version 1.0
 * @see Taxi
 */
public class Infos {

    /**
     * nombre de passagers à bord
     */
    private int nbrePassagers;

    /**
     * véhicule de location
     */
    private Taxi vehicule;

    /**
     * constructeur par défaut
     */
    public Infos(){

    }

    /**
     * constructeur paramétré
     *
     * @param nbrePassagers nombre de passagers à bord
     * @param vehicule véhicule de location
     */
    public Infos(int nbrePassagers, Taxi vehicule) {
        this.nbrePassagers = nbrePassagers;
        this.vehicule = vehicule;
    }

    /**
     * getter nombre de passagers à bord
     *
     * @return nombre de passagers à bord
     */
    public int getNbrePassagers() {
        return nbrePassagers;
    }

    /**
     * setter nombre de passagers à bord
     *
     * @param nbrePassagers nombre de passagers à bord
     */
    public void setNbrePassagers(int nbrePassagers) {
        this.nbrePassagers = nbrePassagers;
    }

    /**
     * getter véhicule de location
     *
     * @return véhicule de location
     */
    public Taxi getVehicule() {
        return vehicule;
    }

    /**
     * getter véhicule de location
     *
     * @param vehicule véhicule de location
     */
    public void setVehicule(Taxi vehicule) {
        this.vehicule = vehicule;
    }
}
