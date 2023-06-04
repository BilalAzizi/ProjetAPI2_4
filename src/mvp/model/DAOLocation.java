package mvp.model;

import metier.Location;

import java.util.List;

public interface DAOLocation {
    Location addLocation(Location location);

    boolean removeLocation(Location location);

    Location updateLocation(Location location);

    Location readLocation(int idLocation);

    List<Location> getLocations();

    List<Location> getLocationsByDateDebut(String dateDebut);

    List<Location> getLocationsByClient(int idClient);
}
