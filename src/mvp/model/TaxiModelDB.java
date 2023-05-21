package mvp.model;

import metier.Taxi;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;


public class TaxiModelDB {
    private static final Logger logger = LogManager.getLogger(TaxiModelDB.class);
    protected Connection dbConnect;

    public TaxiModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            // System.err.println("erreur de connexion");
            logger.error("erreur de connexion");
            System.exit(1);
        }
        logger.info("connexion établie");
    }

    public Taxi addTaxi(Taxi taxi) {
        String query1 = "insert into APITAXI(immatriculation,marque,modele,annee) values(?,?,?,?)";
        String query2 = "select idtaxi from APITAXI where immatriculation= ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, taxi.getImmatriculation());
            pstm1.setString(2, taxi.getId());
            pstm1.setString(3, taxi.get());
            pstm1.setInt(4, taxi.getNbreMaxPassagers());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, taxi.getImmatriculation());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    taxi.setId(idtaxi);
                    return taxi;
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




}
