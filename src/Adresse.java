/**
 * classe métier de la gestion d'adresse
 * @outhour Bilal Azizi
 * @version 1.0
 */
public class Adresse {
    /**
     * identifiant unique de l'adresse
     */
    private int id;
    /**
     * code postal de la localité
     */
    private int cp;
    /**
     * localité
     */
    private String localite;
    /**
     * rue
     */
    private String rue;
    /**
     * numéro de rue
     */
    private String num;

    /**
     * constructeur par défaut
     */
    public Adresse(){

    }

    /**
     * constructeur paramétré
     *
     * @param id identifiant unique de l'adresse, affecté par la base de données
     * @param cp code postal de l'adresse
     * @param localite localité de l'adresse
     * @param rue rue de l'adresse
     * @param num numéro de l'adresse
     */
    public Adresse(int id, int cp, String localite, String rue, String num) {
        this.id = id;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    /**
     * getter id adresse
     *
     * @return identifiant de l'adresse
     */
    public int getId() {
        return id;
    }

    /**
     * setter id adresse
     *
     * @param id identifiant de l'adresse
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter code postal
     *
     * @return code postal
     */
    public int getCp() {
        return cp;
    }

    /**
     * setter code postal
     *
     * @param cp code postal
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * getter localite
     *
     * @return localite
     */
    public String getLocalite() {
        return localite;
    }

    /**
     * setter localite
     *
     * @param localite localité
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

    /**
     * getter rue
     *
     * @return rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * setter rue
     *
     * @param rue rue de l'adresse
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * getter numéro de rue
     *
     * @return numéro de rue
     */
    public String getNum() {
        return num;
    }

    /**
     * setter numéro de rue
     *
     * @param num numéro de rue
     */
    public void setNum(String num) {
        this.num = num;
    }
}
