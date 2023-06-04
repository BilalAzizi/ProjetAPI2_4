package mvp.presenter;

import metier.Taxi;
import mvp.model.DAOTaxi;
import mvp.view.TaxiViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TaxiPresenter {
    private DAOTaxi model;
    private TaxiViewInterface view;
    private static final Logger logger = LogManager.getLogger(TaxiPresenter.class);

    public TaxiPresenter(DAOTaxi model, TaxiViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListeTaxis(getAll());
    }

    public List<Taxi> getAll() {
        return model.getTaxis();
    }

    public void addTaxi(Taxi taxi) {
        Taxi t = model.addTaxi(taxi);
        if (t != null) {
            view.afficherMessage("Création de : " + t);
        } else {
            view.afficherMessage("Erreur de création");
        }
    }

    public void removeTaxi(Taxi taxi) {
        boolean ok = model.removeTaxi(taxi);
        if (ok) {
            view.afficherMessage("Taxi effacé");
        } else {
            view.afficherMessage("Taxi non effacé");
        }
    }

    public void update(Taxi taxi) {
        Taxi t = model.updateTaxi(taxi);
        if (t == null) {
            view.afficherMessage("Mise à jour infructueuse");
        } else {
            view.afficherMessage("Mise à jour effectuée : " + t);
        }
    }

    public void search(int idTaxi) {
        Taxi taxi = model.readTaxi(idTaxi);
        if (taxi == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.afficherMessage(taxi.toString());
        }
    }
}
