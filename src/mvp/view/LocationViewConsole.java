package mvp.view;

import metier.Location;
import mvp.presenter.LocationPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static utilitaires.Utilitaire.*;

public class LocationViewConsole implements LocationViewInterface {
    private LocationPresenter presenter;
    private List<Location> locations;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(LocationPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListeLocations(List<Location> locations) {
        this.locations = locations;
        //petite condition pour éviter un nullPointerException
        if (locations != null){
            afficherListe(locations);
        } else {
            System.out.println("Aucune location trouvée");
        }
        afficherMenu();
    }

    @Override
    public void afficherMessage(String message) {
        System.out.println("Information : " + message);
    }

    @Override
    public Location selectionner(List<Location> locations) {
        int index = choixListe(locations);
        return locations.get(index - 1);
    }

    public void afficherMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("Ajouter", "Retirer", "Rechercher", "Modifier", "Rechercher par date", "Rechercher par client", "Retour"));
        do {
            int choix = choixListe(options);

            switch (choix) {
                case 1:
                    ajouterLocation();
                    break;
                case 2:
                    retirerLocation();
                    break;
                case 3:
                    rechercherLocation();
                    break;
                case 4:
                    modifierLocation();
                    break;
                case 5:
                    rechercherParDate();
                    break;
                case 6:
                    rechercherParClient();
                    break;
                case 7:
                    return;
            }
        } while (true);
    }

    private void ajouterLocation() {

    }

    private void retirerLocation() {

    }

    private void modifierLocation() {

    }

    private void rechercherLocation() {

    }

    private void rechercherParDate() {

    }

    private void rechercherParClient() {

    }
}
