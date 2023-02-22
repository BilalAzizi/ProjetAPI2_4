public class Infos {
    private int nbrePassagers;
    private Taxi vehicule;

    /**
     * constructeur par défaut
     */
    public Infos(){

    }

    /**
     * constructeur paramétré
     *
     * @param nbrePassagers
     * @param vehicule
     */
    public Infos(int nbrePassagers, Taxi vehicule) {
        this.nbrePassagers = nbrePassagers;
        this.vehicule = vehicule;
    }

    public int getNbrePassagers() {
        return nbrePassagers;
    }

    public void setNbrePassagers(int nbrePassagers) {
        this.nbrePassagers = nbrePassagers;
    }

    public Taxi getVehicule() {
        return vehicule;
    }

    public void setVehicule(Taxi vehicule) {
        this.vehicule = vehicule;
    }
}
