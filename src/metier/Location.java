package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Location {
    private int id;
    private LocalDate dateloc;
    private int kmtotal;
    private double cout;
    private Client client;
    private Adresse adrDepart;
    private List<Infos> location = new ArrayList<>();

    public Location() {
    }

    public Location(int id, LocalDate dateloc, int kmtotal, double cout, Client client, Adresse adrDepart, List<Infos> location) {
        this.id = id;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
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

    public LocalDate getDateloc() {
        return dateloc;
    }

    public void setDateloc(LocalDate dateloc) {
        this.dateloc = dateloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
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
                kmtotal == location1.kmtotal &&
                Double.compare(location1.cout, cout) == 0 &&
                Objects.equals(dateloc, location1.dateloc) &&
                Objects.equals(client, location1.client) &&
                Objects.equals(adrDepart, location1.adrDepart) &&
                Objects.equals(location, location1.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateloc, kmtotal, cout, client, adrDepart, location);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", dateloc=" + dateloc +
                ", kmtotal=" + kmtotal +
                ", cout=" + cout +
                ", client=" + client +
                ", adrDepart=" + adrDepart +
                ", location=" + location +
                '}';
    }
}
