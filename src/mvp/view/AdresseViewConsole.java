package mvp.view;

import metier.Adresse;
import mvp.presenter.AdressePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static utilitaires.Utilitaire.*;

public class AdresseViewConsole implements AdresseViewInterface {
    private AdressePresenter presenter;
    private List<Adresse> adresses;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(AdressePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListeAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
        afficherListe(adresses);
        afficherMenu();
    }

    @Override
    public void afficherMessage(String message) {
        System.out.println("Information : " + message);
    }

    @Override
    public Adresse selectionner(List<Adresse> adresses) {
        int index = choixListe(adresses);
        return adresses.get(index - 1);
    }

    public void afficherMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("Ajouter", "Retirer", "Rechercher", "Modifier", "Retour"));
        do {
            int choix = choixListe(options);

            switch (choix) {
                case 1:
                    ajouterAdresse();
                    break;
                case 2:
                    retirerAdresse();
                    break;
                case 3:
                    rechercherAdresse();
                    break;
                case 4:
                    modifierAdresse();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void modifierAdresse() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(adresses);
        Adresse adresse = adresses.get(index - 1);
        Integer codePostal = Integer.parseInt(modifierSiNonVide("Code postal", String.valueOf(adresse.getCp())));
        String localite = modifierSiNonVide("Localité", adresse.getLocalite());
        String rue = modifierSiNonVide("Rue", adresse.getRue());
        String numero = modifierSiNonVide("Numéro", adresse.getNum());
        try {
            presenter.update(new Adresse(adresse.getId(), codePostal, localite, rue, numero));
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        adresses = presenter.getAll(); // Rafraîchissement
        afficherListe(adresses);
    }

    private void rechercherAdresse() {
        System.out.println("Id de l'adresse : ");
        int id = lireEntier();
        presenter.search(id);
    }

    private void retirerAdresse() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(adresses);
        Adresse adresse = adresses.get(index - 1);
        presenter.removeAdresse(adresse);
    }

    private void ajouterAdresse() {
        System.out.print("Code postal : ");
        int codePostal = scanner.nextInt();
        scanner.skip("\n");
        System.out.print("Localité : ");
        String localite = scanner.nextLine();
        System.out.print("Rue : ");
        String rue = scanner.nextLine();
        System.out.print("Numéro : ");
        String numero = scanner.nextLine();
        try {
            presenter.addAdresse(new Adresse(0, codePostal, localite, rue, numero));
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
