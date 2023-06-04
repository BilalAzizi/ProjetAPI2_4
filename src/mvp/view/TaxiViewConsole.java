package mvp.view;

import metier.Taxi;
import mvp.presenter.TaxiPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static utilitaires.Utilitaire.*;

public class TaxiViewConsole implements TaxiViewInterface {
    private TaxiPresenter presenter;
    private List<Taxi> taxis;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(TaxiPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListeTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
        // Petite condition pour éviter un NullPointerException
        if (taxis != null){
            afficherListe(taxis);
        } else {
            System.out.println("Aucun taxi trouvé");
        }
        afficherMenu();
    }

    @Override
    public void afficherMessage(String message) {
        System.out.println("Information : " + message);
    }

    @Override
    public Taxi saisirTaxi() {
        System.out.print("Immatriculation : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Nombre maximum de passagers : ");
        int nbreMaxPassagers = lireEntier();
        System.out.print("Prix par kilomètre : ");
        double prixKm = scanner.nextDouble();
        scanner.nextLine(); // Nettoyer le tampon
        return new Taxi(0, immatriculation, nbreMaxPassagers, prixKm);
    }

    @Override
    public Taxi selectionner(List<Taxi> taxis) {
        int index = choixListe(taxis);
        return taxis.get(index - 1);
    }

    public void afficherMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("Ajouter", "Retirer", "Rechercher", "Modifier", "Retour"));
        do {
            int choix = choixListe(options);

            switch (choix) {
                case 1:
                    ajouterTaxi();
                    break;
                case 2:
                    retirerTaxi();
                    break;
                case 3:
                    rechercherTaxi();
                    break;
                case 4:
                    modifierTaxi();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void ajouterTaxi() {
        Taxi taxi = saisirTaxi();
        presenter.addTaxi(taxi);
        taxis = presenter.getAll(); // Rafraîchissement
        afficherListe(taxis);
    }

    private void retirerTaxi() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(taxis);
        Taxi taxi = taxis.get(index - 1);
        presenter.removeTaxi(taxi);
        taxis = presenter.getAll(); // Rafraîchissement
        afficherListe(taxis);
    }

    private void modifierTaxi() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(taxis);
        Taxi taxi = taxis.get(index - 1);
        Taxi taxiModifie = saisirTaxi();
        taxiModifie.setId(taxi.getId());
        presenter.update(taxiModifie);
        taxis = presenter.getAll(); // Rafraîchissement
        afficherListe(taxis);
    }

    private void rechercherTaxi() {
        System.out.println("Id du taxi : ");
        int id = lireEntier();
        presenter.search(id);
    }
}
