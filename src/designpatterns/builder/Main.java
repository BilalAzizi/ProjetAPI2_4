package designpatterns.builder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Adresse adresse = new Adresse(1, 12345, "Localite", "Rue", "1");
            Client client = new Client(1, "Bilal@gmail.com", "Azizi", "Bilal", "123456789");
            Taxi taxi = new Taxi(1, "ABC123", 4, 2.5);
            Infos infos = new Infos(3, taxi);

            Location location = new Location(1, LocalDate.now(), 100, 50.0, client, adresse, null);
            location.getLocation().add(infos);

            System.out.println(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
