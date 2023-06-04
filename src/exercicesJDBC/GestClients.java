package exercicesJDBC;

import metier.Client;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class GestClients {

    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("\n1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

    }

    public void ajout() {
        System.out.print("nom :");
        String nom = sc.nextLine();
        System.out.print("prénom :");
        String prenom = sc.nextLine();
        System.out.print("mail :");
        String mail = sc.nextLine();
        System.out.print("tel :");
        String tel = sc.nextLine();
        String query1 = "insert into APITCLIENT(nom,prenom,mail,tel) values(?,?,?,?)";
        String query2 = "select idclient from APITCLIENT where mail= ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, nom);
            pstm1.setString(2, prenom);
            pstm1.setString(3, mail);
            pstm1.setString(4, tel);
            int n = pstm1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if (n == 1) {
                pstm2.setString(1, mail);
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int idclient = rs.getInt(1);
                    System.out.println("idclient = " + idclient);
                } else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    public void recherche() {
        System.out.println("id du client recherché ");
        int idrech = sc.nextInt();
        String query = "select * from APITCLIENT where idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idrech);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String mail = rs.getString(4);
                String tel = rs.getString(5);
                Client cl = new Client(idrech, nom, prenom, mail, tel);
                System.out.println(cl);
                opSpeciales(cl);
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    public void modification() {
        System.out.println("id du client recherché ");
        int idrech = sc.nextInt();
        sc.skip("\n");
        System.out.println("nouveau téléphone ");
        String ntel = sc.nextLine();
        String query = "update APITCLIENT set tel=? where idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, ntel);
            pstm.setInt(2, idrech);
            int n = pstm.executeUpdate();
            if (n != 0) System.out.println(n + "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    public void suppression() {
        System.out.println("id du client recherché ");
        int idrech = sc.nextInt();
        String query = "delete from APITCLIENT where idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idrech);
            int n = pstm.executeUpdate();
            if (n != 0) System.out.println(n + " ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    private void tous() {
        String query = "select * from APITCLIENT";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idclient = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String mail = rs.getString(4);
                String tel = rs.getString(5);
                System.out.printf("%d %s %s %s %s\n", idclient, nom, prenom, mail, tel);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql:" + e);
        }
    }

    private void opSpeciales(Client client) {
        do {
            System.out.println("\n1.Toutes les locations par adresse\n2.Tous les taxi utilisés par client\n3.Le km total parcouru par chaque taxi\n4.Menu principal");
            System.out.println("choix: ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    locationsEntreDeuxDates(client);
                    break;
                case 2:
                    taxiUtiliseParClient(client);
                    break;
                case 3:
                    adressesRenduSansDoublon(client);
                    break;

                case 4:
                    return;
                default:
                    System.out.println("Choix invalide recommencez ");
            }
        } while (true);

    }

    private void locationsEntreDeuxDates(Client client) {
        String query = "SELECT * FROM APILOCATION WHERE IDCLIENT = ? AND DATELOC BETWEEN ? AND ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, client.getId());

            System.out.print("Date de début: ");
            int j = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            LocalDate dateDebut = LocalDate.of(a, m, j);
            pstm.setDate(2, Date.valueOf(dateDebut));

            System.out.print("Date de fin: ");
            int j1 = sc.nextInt();
            int m1 = sc.nextInt();
            int a1 = sc.nextInt();
            LocalDate dateFin = LocalDate.of(a1, m1, j1);
            pstm.setDate(3, Date.valueOf(dateFin));

            ResultSet rs = pstm.executeQuery();
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                int idLocation = rs.getInt("IDLOCATION");
                LocalDate dateLoc = rs.getDate("DATELOC").toLocalDate();
                int kmTotal = rs.getInt("KMTOTAL");
                double cout = rs.getDouble("COUT");
                System.out.printf("ID Location: %d, Date location: %s, KM total: %d, Coût: %.2f%n", idLocation, dateLoc, kmTotal, cout);
            }

            if (!trouve) {
                System.out.println("Aucune location trouvée entre les deux dates pour le client dont l'ID est " + client.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e);
        }
    }

    private void taxiUtiliseParClient(Client client) {
        String query = "SELECT * FROM TAXI_PAR_CLIENT WHERE IDCLIENT = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, client.getId());
            ResultSet rs = pstm.executeQuery();

            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");
                String immatriculation = rs.getString("IMMATRICULATION");
                int nbreMaxPassagers = rs.getInt("NBREMAXPASSAGERS");
                double prixKm = rs.getDouble("PRIXKM");
                System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Immatriculation: " + immatriculation + ", Nombre max passagers: " + nbreMaxPassagers + ", Prix KM: " + String.format("%.2f", prixKm));
            }

            if (!trouve) {
                System.out.println("Aucun taxi utilisé par le client dont l'ID est " + client.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e);
        }

    }

    private void adressesRenduSansDoublon(Client client) {
        String query = "SELECT DISTINCT A.* FROM APIADRESSE A " +
                "JOIN APILOCATION L ON A.IDADRESSE = L.IDADRESSE " +
                "WHERE L.IDCLIENT = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, client.getId());
            ResultSet rs = pstm.executeQuery();
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                int idAdresse = rs.getInt("IDADRESSE");
                String rue = rs.getString("RUE");
                String codePostal = rs.getString("CP");
                String ville = rs.getString("VILLE");
                System.out.println("ID Adresse: " + idAdresse + ", Rue: " + rue + ", Code postal: " + codePostal + ", Ville: " + ville);
            }

            if (!trouve) {
                System.out.println("Aucune adresse unique trouvée pour le client dont l'ID est " + client.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e);
        }
    }

    public static void main(String[] args) {

        GestClients g = new GestClients();
        g.gestion();
    }
}
