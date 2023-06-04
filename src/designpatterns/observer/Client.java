package designpatterns.observer;

import designpatterns.observer.Observer;

public class Client extends Observer {
    private int idClient;
    private String mail, nom, prenom, tel;

    public Client(int idClient, String mail, String nom, String prenom, String tel) {
        this.idClient = idClient;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public void update(String msg) {
        System.out.println("Received notification: " + msg);
    }
}
