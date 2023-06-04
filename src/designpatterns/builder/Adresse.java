package designpatterns.builder;

import java.util.Objects;

public class Adresse {
    private int id;
    private int cp;
    private String localite;
    private String rue;
    private String num;

    public Adresse() {
    }

    public Adresse(int id, int cp, String localite, String rue, String num) {
        this.id = id;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return id == adresse.id &&
                cp == adresse.cp &&
                Objects.equals(localite, adresse.localite) &&
                Objects.equals(rue, adresse.rue) &&
                Objects.equals(num, adresse.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cp, localite, rue, num);
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", cp=" + cp +
                ", localite='" + localite + '\'' +
                ", rue='" + rue + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
