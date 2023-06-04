package mvp.view;

import metier.Client;
import mvp.presenter.ClientPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static utilitaires.Utilitaire.*;

public class ClientViewConsole implements ClientViewInterface {
    private ClientPresenter presenter;
    private List<Client> clients;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setPresenter(ClientPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListeClients(List<Client> clients) {
        this.clients = clients;
        afficherListe(clients);
        afficherMenu();
    }

    @Override
    public void afficherMessage(String message) {
        System.out.println("Information : " + message);
    }

    @Override
    public Client selectionner(List<Client> clients) {
        int index = choixListe(clients);
        return clients.get(index - 1);
    }

    public void afficherMenu() {
        List<String> options = new ArrayList<>(Arrays.asList("Ajouter", "Retirer", "Rechercher", "Modifier", "Retour"));
        do {
            int choix = choixListe(options);

            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    retirerClient();
                    break;
                case 3:
                    rechercherClient();
                    break;
                case 4:
                    modifierClient();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void modifierClient() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(clients);
        Client client = clients.get(index - 1);
        String nom = modifierSiNonVide("Nom :", client.getNom());
        String prenom = modifierSiNonVide("Prénom :", client.getPrenom());
        String mail = modifierSiNonVide("Mail :", client.getMail());
        String tel = modifierSiNonVide("Téléphone :", client.getTel());
        try {
            presenter.update(new Client(client.getId(), nom, prenom, mail, tel));
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        clients = presenter.getAll();
        afficherListe(clients);
    }

    private void rechercherClient() {
        System.out.println("Id du client : ");
        int id = lireEntier();
        presenter.search(id);
    }

    private void retirerClient() {
        System.out.println("Numéro de ligne : ");
        int index = choixElement(clients);
        Client client = clients.get(index - 1);
        presenter.removeClient(client);
    }

    private void ajouterClient() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Mail : ");
        String mail = scanner.nextLine();
        System.out.print("Téléphone : ");
        String tel = scanner.nextLine();
        try {
            presenter.addClient(new Client(0, nom, prenom, mail, tel));
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
