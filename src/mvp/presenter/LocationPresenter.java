package mvp.presenter;

import metier.Location;
import metier.Taxi;
import metier.Adresse;
import metier.Client;
import mvp.model.DAOLocation;
import mvp.view.LocationViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LocationPresenter {
    private DAOLocation model;
    private LocationViewInterface view;

    private ClientPresenter clientPresenter;
    private AdressePresenter adressePresenter;
    private TaxiPresenter taxiPresenter;
    private static final Logger logger = LogManager.getLogger(LocationPresenter.class);

    public void setAdressePresenter(AdressePresenter adressePresenter) {
        this.adressePresenter = adressePresenter;
    }

    public void setClientPresenter(ClientPresenter clientPresenter) {
        this.clientPresenter = clientPresenter;
    }

    public void setTaxiPresenter(TaxiPresenter taxiPresenter) {
        this.taxiPresenter = taxiPresenter;
    }

    public LocationPresenter(DAOLocation model, LocationViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListeLocations(getAll());
    }

    public List<Location> getAll() {
        return model.getLocations();
    }

    public void addLocation(Location location) {
        Location loc = model.addLocation(location);
        if (loc != null) {
            view.afficherMessage("Création de : " + loc);
        } else {
            view.afficherMessage("Erreur de création");
        }
    }

    public void removeLocation(Location location) {
        boolean ok = model.removeLocation(location);
        if (ok) {
            view.afficherMessage("Location effacée");
        } else {
            view.afficherMessage("Location non effacée");
        }
    }

    public Location selectionner() {
        logger.info("Appel de la sélection de location");
        Location loc = view.selectionner(getAll());
        return loc;
    }

    public void update(Location location) {
        Location loc = model.updateLocation(location);
        if (loc == null) {
            view.afficherMessage("Mise à jour infructueuse");
        } else {
            view.afficherMessage("Mise à jour effectuée : " + loc);
        }
    }

    public void search(int idLocation) {
        Location loc = model.readLocation(idLocation);
        if (loc == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.afficherMessage(loc.toString());
        }
    }

    public void searchByDate(String date) {
        List<Location> locations = model.getLocationsByDateDebut(date);
        if (locations == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.setListeLocations(locations);
        }
    }

    public void searchByClient(int idClient) {
        List<Location> locations = model.getLocationsByClient(idClient);
        if (locations == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.setListeLocations(locations);
        }
    }
}
