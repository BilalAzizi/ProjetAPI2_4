package utilitaires;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner scanner = new Scanner(System.in);

    public static int lireEntier() {
        int n = 0;
        do {
            try {
                String ns = scanner.nextLine();
                n = Integer.parseInt(ns);
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Valeur numérique incorrecte");
            }
        } while (true);
    }

    public static void afficherListe(List<?> liste) {
        int index = 1;
        for (Object element : liste) {
            System.out.println(index + ". " + element);
            index++;
        }
    }

    public static int choixListe(List<?> liste) {
        afficherListe(liste);
        return choixElement(liste);
    }

    public static int choixElement(List<?> liste) {
        int choix;
        do {
            System.out.print("Choix : ");
            choix = lireEntier();
        } while (choix < 1 || choix > liste.size());
        return choix;
    }

    public static String modifierSiNonVide(String label, String ancienneValeur) {
        System.out.println(label + " : " + ancienneValeur);
        System.out.print("Nouvelle valeur (appuyez sur Entrée pour ne pas modifier) : ");
        String nouvelleValeur = scanner.nextLine();
        if (nouvelleValeur.isBlank()) {
            return ancienneValeur;
        }
        return nouvelleValeur;
    }

    public static LocalDate lireDate() {
        do {
            try {
                String[] jma = scanner.nextLine().split(" ");
                int jour = Integer.parseInt(jma[0]);
                int mois = Integer.parseInt(jma[1]);
                int annee = Integer.parseInt(jma[2]);
                return LocalDate.of(annee, mois, jour);
            } catch (Exception e) {
                System.out.println("Date incorrecte");
            }
        } while (true);
    }

    public static LocalTime lireHeure() {
        do {
            try {
                String[] hms = scanner.nextLine().split(" ");
                int heures = Integer.parseInt(hms[0]);
                int minutes = Integer.parseInt(hms[1]);
                int secondes = Integer.parseInt(hms[2]);
                return LocalTime.of(heures, minutes, secondes);
            } catch (Exception e) {
                System.out.println("Heure incorrecte");
            }
        } while (true);
    }

    public static String formaterDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return formatter.format(date);
    }
}
