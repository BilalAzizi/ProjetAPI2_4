package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe client du metier.Taxi
 * @outhor Bilal Azizi
 * @version 1.0
 * @see Location
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

    /**
     * liste des locations
     */
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
     */
    public Client(int id, String mail, String nom, String prenom, String tel) {
        this.id = id;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
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

    /**
     * getter location
     *
     * @return location du client
     */
    public List<Location> getLocation() {
        return location;
    }

    /**
     * setter location
     *
     * @param location location du client
     */
    public void setLocation(List<Location> location) {
        this.location = location;
    }

    /**
     * égalité de deux clients basée sur le mail
     * @param o autre élément
     * @return égalité ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(mail, client.mail);
    }

    /**
     * calcul du hashcode du client basé sur le mail
     * @return valeur du hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", location=" + location +
                '}';
    }
}
