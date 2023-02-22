import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe client du Taxi
 * @outhor Bilal Azizi
 */
public class Client {

    /**
     * identifiant unique du client
     */
    private int id;
    /**
     * mail du client
     */
    private String mail;
    /**
     * nom du client
     */
    private String nom;
    /**
     * prénom du client
     */
    private String prenom;
    /**
     * numéro de telephone du client
     */
    private String tel;

    //faire la doc de ceci
    private List<Location> location = new ArrayList<>();

    /**
     * constructeur par défaut
     */
    public Client(){

    }

    /**
     * constructeur paramétré
     *
     * @param id identifiant unique du client, affecté par la base de données
     * @param mail mail du client
     * @param nom nom du client
     * @param prenom prénom du client
     * @param tel téléphone du client
     * @param location
     */
    public Client(int id, String mail, String nom, String prenom, String tel, List<Location> location) {
        this.id = id;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.location = location;
    }

    /**
     * getter id client
     *
     * @return identifiant du client
     */
    public int getId() {
        return id;
    }

    /**
     * setter id client
     *
     * @param id identifiant du client
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter mail
     *
     * @return mail du client
     */
    public String getMail() {
        return mail;
    }

    /**
     * setter mail
     *
     * @param mail mail du client
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * getter nom
     *
     * @return nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom du client
     *
     * @param nom nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prénom client
     *
     * @return prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prénom du client
     *
     * @param prenom prénom du client
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter téléphone
     *
     * @return téléphone du client
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter téléphone
     *
     * @param tel téléphone du client
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(mail, client.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
