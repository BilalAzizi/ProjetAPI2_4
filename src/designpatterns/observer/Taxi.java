package designpatterns.observer;

import designpatterns.observer.Subject;

public class Taxi extends Subject {
    private int idTaxi;
    private String immatriculation, carburant;
    private double prixKm;

    public Taxi(int idTaxi, String immatriculation, String carburant, double prixKm) {
        this.idTaxi = idTaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixKm = prixKm;
    }

    public int getIdTaxi() {
        return idTaxi;
    }

    public void setIdTaxi(int idTaxi) {
        this.idTaxi = idTaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public double getPrixKm() {
        return prixKm;
    }

    public void setPrixKm(double prixKm) {
        this.prixKm = prixKm;
        notifyObservers();
    }

    @Override
    public String getNotification() {
        return "Changement du prix au km du taxi : ID - " + idTaxi + ", Immatriculation - " + immatriculation + ", Nouveau prix - " + prixKm + "€";
    }
}
