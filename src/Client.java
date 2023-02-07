import java.util.Objects;
import java.util.Set;

public class Client {
    private int id;
    private String mail;
    private String nom;
    private String prenom;
    private String tel;
    private Set<Location> location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(mail, client.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
