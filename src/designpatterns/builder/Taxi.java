package designpatterns.builder;

import java.util.Objects;

public class Taxi {
    private int id;
    private String immatriculation;
    private int nbreMaxPassagers;
    private double prixKm;

    public Taxi() {
    }

    public Taxi(int id, String immatriculation, int nbreMaxPassagers, double prixKm) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nbreMaxPassagers = nbreMaxPassagers;
        this.prixKm = prixKm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

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

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", immatriculation='" + immatriculation + '\'' +
                ", nbreMaxPassagers=" + nbreMaxPassagers +
                ", prixKm=" + prixKm +
                '}';
    }
}
