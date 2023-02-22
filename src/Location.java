import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Location {
    /**
     * identifiant unique de la location
     */
    private int id;
    /**
     * date de la location
     */
    private String dateloc;
    private int kmtotal;
    /**
     * cout de la location
     */
    private double cout;
    private Client client;
    private Adresse adrDepart;
    private List<Infos> location = new ArrayList<>();

    /**
     * constructeur par défaut
     */
    public Location(){

    }

    /**
     * constructeur paramétré
     *
     * @param id
     * @param dateloc
     * @param kmtotal
     * @param cout
     * @param client
     * @param adrDepart
     * @param location
     */
    public Location(int id, String dateloc, int kmtotal, double cout, Client client, Adresse adrDepart, List<Infos> location) {
        this.id = id;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.cout = cout;
        this.client = client;
        this.adrDepart = adrDepart;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateloc() {
        return dateloc;
    }

    public void setDateloc(String dateloc) {
        this.dateloc = dateloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Adresse getAdrDepart() {
        return adrDepart;
    }

    public void setAdrDepart(Adresse adrDepart) {
        this.adrDepart = adrDepart;
    }

    public List<Infos> getLocation() {
        return location;
    }

    public void setLocation(List<Infos> location) {
        this.location = location;
    }
}
