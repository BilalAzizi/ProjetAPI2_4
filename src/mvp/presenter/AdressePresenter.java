package mvp.presenter;

import metier.Adresse;
import mvp.model.DAOAdresse;
import mvp.view.AdresseViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class AdressePresenter {
    private DAOAdresse model;
    private AdresseViewInterface view;
    private static final Logger logger = LogManager.getLogger(AdressePresenter.class);

    public AdressePresenter(DAOAdresse model, AdresseViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListeAdresses(getAll());
    }

    public List<Adresse> getAll() {
        return model.getAdresses();
    }

    public void addAdresse(Adresse adresse) {
        Adresse adr = model.addAdresse(adresse);
        if (adr != null) {
            view.afficherMessage("Création de : " + adr);
        } else {
            view.afficherMessage("Erreur de création");
        }
    }

    public void removeAdresse(Adresse adresse) {
        boolean ok = model.removeAdresse(adresse);
        if (ok) {
            view.afficherMessage("Adresse effacée");
        } else {
            view.afficherMessage("Adresse non effacée");
        }
    }

    public Adresse selectionner() {
        logger.info("Appel de la sélection d'adresse");
        Adresse adr = view.selectionner(getAll());
        return adr;
    }

    public void update(Adresse adresse) {
        Adresse adr = model.updateAdresse(adresse);
        if (adr == null) {
            view.afficherMessage("Mise à jour infructueuse");
        } else {
            view.afficherMessage("Mise à jour effectuée : " + adr);
        }
    }

    public void search(int idAdresse) {
        Adresse adr = model.readAdresse(idAdresse);
        if (adr == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.afficherMessage(adr.toString());
        }
    }
}
