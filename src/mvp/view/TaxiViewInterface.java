package mvp.view;

import metier.Taxi;
import mvp.presenter.TaxiPresenter;

import java.util.List;

public interface TaxiViewInterface {
    void setPresenter(TaxiPresenter presenter);

    void setListeTaxis(List<Taxi> taxis);

    void afficherMessage(String message);

    Taxi saisirTaxi();

    Taxi selectionner(List<Taxi> taxis);
}
