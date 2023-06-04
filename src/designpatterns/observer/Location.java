package designpatterns.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Location {
    private int id;
    private LocalDate dateLoc;
    private int kmTotal;
    private double cout;
    private Client client;
    private Adresse adrDepart;
    private List<Infos> location = new ArrayList<>();

    public Location(int id, LocalDate dateLoc, int kmTotal, double cout, Client client, Adresse adrDepart, List<Infos> location) {
        this.id = id;
        this.dateLoc = dateLoc;
        this.kmTotal = kmTotal;
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

    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(LocalDate dateLoc) {
        this.dateLoc = dateLoc;
    }

    public int getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return id == location1.id &&
                kmTotal == location1.kmTotal &&
                Double.compare(location1.cout, cout) == 0 &&
                Objects.equals(dateLoc, location1.dateLoc) &&
                Objects.equals(client, location1.client) &&
                Objects.equals(adrDepart, location1.adrDepart) &&
                Objects.equals(location, location1.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateLoc, kmTotal, cout, client, adrDepart, location);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateLoc=" + dateLoc +
                ", kmTotal=" + kmTotal +
                ", cout=" + cout +
                ", client=" + client +
                ", adrDepart=" + adrDepart +
                ", location=" + location +
                '}';
    }
}
