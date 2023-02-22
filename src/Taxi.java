import java.util.Objects;

public class Taxi {
    /**
     * identifiant unique du taxi
     */
    private int id;
    /**
     * immatriculation unique du taxi
     */
    private String immatriculation;
    /**
     * nombre de passagers maximum d'un taxi
     */
    private int nbreMaxPassagers;
    /**
     * prix au km
     */
    private double prixKm;

    /**
     * constructeur par défaut
     */
    public Taxi(){

    }

    /**
     * constructeur paramétré
     *
     * @param id identifiant unique du taxi, affecté par la base de données
     * @param immatriculation immatriculation unique du taxi
     * @param nbreMaxPassagers nombre maximum de passagers dans un taxi
     * @param prixKm prix au kilomètre
     */
    public Taxi(int id, String immatriculation, int nbreMaxPassagers, double prixKm) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nbreMaxPassagers = nbreMaxPassagers;
        this.prixKm = prixKm;
    }

    /**
     * getter id taxi
     *
     * @return identifiant du taxi
     */
    public int getId() {
        return id;
    }

    /**
     * setter id taxi
     *
     * @param id identifiant du taxi
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter immatriculation taxi
     *
     * @return immatriculation du taxi
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * setter immatriculation taxi
     *
     * @param immatriculation immatriculation du taxi
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getNbreMaxPassagers() {
        return nbreMaxPassagers;
    }

    public void setNbreMaxPassagers(int nbreMaxPassagers) {
        this.nbreMaxPassagers = nbreMaxPassagers;
    }

    public double getPrixKm() {
        return prixKm;
    }

    public void setPrixKm(double prixKm) {
        this.prixKm = prixKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return Objects.equals(immatriculation, taxi.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation);
    }
}
