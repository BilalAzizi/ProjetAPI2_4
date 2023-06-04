package mvp.model;

import metier.Taxi;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxiModelDB implements DAOTaxi {
    private static final Logger logger = LogManager.getLogger(TaxiModelDB.class);
    private Connection dbConnect;

    public TaxiModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            logger.error("Erreur de connexion");
            System.exit(1);
        }
        logger.info("Connexion établie");
    }

    @Override
    public Taxi addTaxi(Taxi taxi) {
        String query1 = "INSERT INTO Taxi(immatriculation, nbreMaxPassagers, prixKm) VALUES (?, ?, ?)";
        String query2 = "SELECT id FROM Taxi WHERE immatriculation = ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, taxi.getImmatriculation());
            pstm1.setInt(2, taxi.getNbreMaxPassagers());
            pstm1.setDouble(3, taxi.getPrixKm());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, taxi.getImmatriculation());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int idTaxi = rs.getInt(1);
                    taxi.setId(idTaxi);
                    return taxi;
                } else {
                    logger.error("Record introuvable");
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Erreur SQL : " + e);
            return null;
        }
    }

    @Override
    public boolean removeTaxi(Taxi taxi) {
        String query = "DELETE FROM Taxi WHERE id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, taxi.getId());
            int n = pstm.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            logger.error("Erreur d'effacement : " + e);
            return false;
        }
    }

    @Override
    public Taxi updateTaxi(Taxi taxi) {
        String query = "UPDATE Taxi SET immatriculation = ?, nbreMaxPassagers = ?, prixKm = ? WHERE id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, taxi.getImmatriculation());
            pstm.setInt(2, taxi.getNbreMaxPassagers());
            pstm.setDouble(3, taxi.getPrixKm());
            pstm.setInt(4, taxi.getId());
            int n = pstm.executeUpdate();
            if (n != 0) {
                return readTaxi(taxi.getId());
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Erreur de mise à jour : " + e);
            return null;
        }
    }

    @Override
    public Taxi readTaxi(int idTaxi) {
        String query = "SELECT * FROM Taxi WHERE id = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idTaxi);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String immatriculation = rs.getString("immatriculation");
                int nbreMaxPassagers = rs.getInt("nbreMaxPassagers");
                double prixKm = rs.getDouble("prixKm");
                return new Taxi(idTaxi, immatriculation, nbreMaxPassagers, prixKm);
            } else {
                logger.error("Record introuvable");
                return null;
            }
        } catch (SQLException e) {
            logger.error("Erreur de lecture : " + e);
            return null;
        }
    }

    @Override
    public List<Taxi> getTaxis() {
        List<Taxi> liste = new ArrayList<>();
        String query = "SELECT * FROM Taxi";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idTaxi = rs.getInt("id");
                String immatriculation = rs.getString("immatriculation");
                int nbreMaxPassagers = rs.getInt("nbreMaxPassagers");
                double prixKm = rs.getDouble("prixKm");
                Taxi taxi = new Taxi(idTaxi, immatriculation, nbreMaxPassagers, prixKm);
                liste.add(taxi);
            }
            return liste;
        } catch (SQLException e) {
            logger.error("Erreur de lecture : " + e);
            return null;
        }
    }
}
