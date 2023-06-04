package mvp.view;

import metier.Client;
import mvp.presenter.ClientPresenter;

import java.util.List;

public interface ClientViewInterface {
    void setPresenter(ClientPresenter presenter);

    void setListeClients(List<Client> clients);

    void afficherMessage(String message);

    Client selectionner(List<Client> clients);
}
