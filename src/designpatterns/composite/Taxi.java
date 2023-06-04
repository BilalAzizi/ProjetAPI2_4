package designpatterns.composite;

import java.util.Objects;

public class Taxi extends Element {
    private String immatriculation;
    private int nbreMaxPassagers;
    private double prixKm;

    public Taxi(int id, String immatriculation, int nbreMaxPassagers, double prixKm) {
        super(id);
        this.immatriculation = immatriculation;
        this.nbreMaxPassagers = nbreMaxPassagers;
        this.prixKm = prixKm;
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
    public int nbreVehicule() {
        return 1;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + getId() +
                ", immatriculation='" + immatriculation + '\'' +
                ", nbreMaxPassagers=" + nbreMaxPassagers +
                ", prixKm=" + prixKm +
                '}';
    }
}
