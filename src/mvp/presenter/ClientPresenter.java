package mvp.presenter;

import metier.Client;
import mvp.model.DAOClient;
import mvp.view.ClientViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClientPresenter {
    private DAOClient model;
    private ClientViewInterface view;
    private static final Logger logger = LogManager.getLogger(ClientPresenter.class);

    public ClientPresenter(DAOClient model, ClientViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        view.setListeClients(getAll());
    }

    public List<Client> getAll() {
        return model.getClients();
    }

    public void addClient(Client client) {
        Client cl = model.addClient(client);
        if (cl != null) {
            view.afficherMessage("Création de : " + cl);
        } else {
            view.afficherMessage("Erreur de création");
        }
    }

    public void removeClient(Client client) {
        boolean ok = model.removeClient(client);
        if (ok) {
            view.afficherMessage("Client effacé");
        } else {
            view.afficherMessage("Client non effacé");
        }
    }

    public Client selectionner() {
        logger.info("Appel de la sélection de client");
        Client cl = view.selectionner(getAll());
        return cl;
    }

    public void update(Client client) {
        Client cl = model.updateClient(client);
        if (cl == null) {
            view.afficherMessage("Mise à jour infructueuse");
        } else {
            view.afficherMessage("Mise à jour effectuée : " + cl);
        }
    }

    public void search(int idClient) {
        Client cl = model.readClient(idClient);
        if (cl == null) {
            view.afficherMessage("Recherche infructueuse");
        } else {
            view.afficherMessage(cl.toString());
        }
    }
}
