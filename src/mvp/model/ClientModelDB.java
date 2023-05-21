package mvp.model;

import metier.Client;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ClientModelDB implements DAOClient, ClientSpecial {
    private static final Logger logger = LogManager.getLogger(ClientModelDB.class);
    protected Connection dbConnect;

    public ClientModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            // System.err.println("erreur de connexion");
            logger.error("erreur de connexion");
            System.exit(1);
        }
        logger.info("connexion établie");
    }

    @Override
    public Client addClient(Client client) {
        String query1 = "insert into APITCLIENT(nom,prenom,mail,tel) values(?,?,?,?)";
        String query2 = "select idclient from APITCLIENT where mail= ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, client.getNom());
            pstm1.setString(2, client.getPrenom());
            pstm1.setString(3, client.getMail());
            pstm1.setString(4, client.getTel());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, client.getNom());
                pstm2.setString(2, client.getPrenom());
                pstm2.setString(3, client.getTel());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int idclient = rs.getInt(1);
                    client.setId(idclient);
                    return client;
                } else {
                    logger.error("record introuvable");
                    //  System.err.println("record introuvable");
                    return null;
                }
            } else return null;

        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public boolean removeClient(Client client) {
        String query = "delete from APITCLIENT where idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, client.getId());
            int n = pstm.executeUpdate();
            if (n != 0) return true;
            else return false;

        } catch (SQLException e) {
            //  System.err.println("erreur sql :"+e);
            logger.error("erreur d'effacement : " + e);
            return false;
        }
    }

    @Override
    public Client updateClient(Client client) {
        String query = "update APITCLIENT set nom =?, prenom =?, mail =?, tel =? where idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, client.getNom());
            pstm.setString(2, client.getPrenom());
            pstm.setString(3, client.getMail());
            pstm.setString(4, client.getTel());
            pstm.setInt(5, client.getId());
            int n = pstm.executeUpdate();
            if (n != 0) return readClient(client.getId());
            else return null;

        } catch (SQLException e) {
            logger.error("erreur d'update : " + e);
            return null;
        }
    }

    @Override
    public Client readClient(int idClient) {
        String query = "SELECT * FROM APITCLIENT WHERE idclient = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idClient);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String mail = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                Client cl = new Client(idClient, mail, nom, prenom, tel);
                return cl;
            } else {
                logger.error("record introuvable");
                // System.err.println("record introuvable");
                return null;
            }
        } catch (SQLException e) {
            logger.error("erreur sql : " + e);
            // System.err.println("erreur sql :"+e);
            return null;
        }
    }

    @Override
    public List<Client> getClients() {
        List<Client> liste = new ArrayList();
        String query = "SELECT * FROM APITCLIENT";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idClient = rs.getInt(1);
                String mail = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                Client cl = new Client(idClient, mail, nom, prenom, tel);
                liste.add(cl);
            }
            return liste;
        } catch (SQLException e) {
            logger.error("erreur sql : " + e);
            // System.err.println("erreur sql :"+e);
            return null;
        }
    }

}
