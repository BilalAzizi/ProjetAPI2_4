import java.util.Objects;

public class Taxi {
    private int id;
    private String immatriculation;
    private int nbreMaxPassagers;
    private double prixKm;


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
}
