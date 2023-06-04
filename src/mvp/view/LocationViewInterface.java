package mvp.view;

import metier.Location;
import mvp.presenter.LocationPresenter;

import java.util.List;

public interface LocationViewInterface {
    void setPresenter(LocationPresenter presenter);

    void setListeLocations(List<Location> locations);

    void afficherMessage(String message);

    Location selectionner(List<Location> locations);
}
