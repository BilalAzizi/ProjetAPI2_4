package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * classe métier de la gestion de location
 * @version 1.0
 * @outhor Bilal Azizi
 * @see Client
 * @see Adresse
 * @see Infos
 */
public class Location {
    /**
     * identifiant unique de la location
     */
    private int id;
    /**
     * date de la location
     */
    private LocalDate dateloc;
    /**
     * Kilomètre total de la location
     */
    private int kmtotal;
    /**
     * cout de la location
     */
    private double cout;
    /**
     * client de la location
     */
    private Client client;
    /**
     * adresse de départ de la location
     */
    private Adresse adrDepart;
    /**
     * infos de la location
     */
    private List<Infos> location = new ArrayList<>();

    /**
     * constructeur par défaut
     */
    public Location(){

    }

    /**
     * constructeur paramétré
     *
     * @param id identifiant unique du client, affecté par la base de données
     * @param dateloc date de location
     * @param kmtotal kilomètre total de la location
     * @param cout cout de la location
     * @param client client de la location
     * @param adrDepart adresse de départ
     * @param location info de la location
     */
    public Location(int id, LocalDate dateloc, int kmtotal, double cout, Client client, Adresse adrDepart, List<Infos> location) {
        this.id = id;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.cout = cout;
        this.client = client;
        this.adrDepart = adrDepart;
        this.location = location;
    }

    /**
     * getter id
     *
     * @return id de la location
     */
    public int getId() {
        return id;
    }

    /**
     * setter id
     *
     * @param id id de la location
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter dateloc
     *
     * @return date de la location
     */
    public LocalDate getDateloc() {
        return dateloc;
    }

    /**
     * setter dateloc
     *
     * @param dateloc date de la location
     */
    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
    }

    /**
     * getter kmtotal
     *
     * @return kilomètre total de la location
     */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     *
     * @param kmtotal kilomètre total de la location
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    /**
     * getter cout
     *
     * @return cout de la location
     */
    public double getCout() {
        return cout;
    }

    /**
     * setter cout
     *
     * @param cout cout de la location
     */
    public void setCout(double cout) {
        this.cout = cout;
    }

    /**
     * getter client de la location
     *
     * @return client de la location
     */
    public Client getClient() {
        return client;
    }

    /**
     * setter client de la location
     *
     * @param client client de la location
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * getter adresse de départ de la location
     *
     * @return adresse de départ de la location
     */
    public Adresse getAdrDepart() {
        return adrDepart;
    }

    /**
     * setter adresse de départ de la location
     *
     * @param adrDepart adresse de départ de la location
     */
    public void setAdrDepart(Adresse adrDepart) {
        this.adrDepart = adrDepart;
    }

    /**
     * getter infos de location
     *
     * @return liste des infos de la location
     */
    public List<Infos> getLocation() {
        return location;
    }

    /**
     * setter infos de la location
     *
     * @param location liste des infos de la location
     */
    public void setLocation(List<Infos> location) {
        this.location = location;
    }
}
