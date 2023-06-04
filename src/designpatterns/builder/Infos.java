package designpatterns.builder;

import java.util.Objects;

public class Infos {
    private int nbrePassagers;
    private Taxi vehicule;

    public Infos() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return nbrePassagers == infos.nbrePassagers &&
                Objects.equals(vehicule, infos.vehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbrePassagers, vehicule);
    }

    @Override
    public String toString() {
        return "Infos{" +
                "nbrePassagers=" + nbrePassagers +
                ", vehicule=" + vehicule +
                '}';
    }
}
