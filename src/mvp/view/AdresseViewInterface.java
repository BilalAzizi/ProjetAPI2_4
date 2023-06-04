package mvp.view;

import metier.Adresse;
import mvp.presenter.AdressePresenter;

import java.util.List;

public interface AdresseViewInterface {
    public void setPresenter(AdressePresenter presenter);

    public void setListeAdresses(List<Adresse> adresses);

    public void afficherMessage(String message);

    public Adresse selectionner(List<Adresse> adresses);
}

