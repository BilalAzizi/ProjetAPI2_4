package mvp.model;

import metier.Location;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocationModelDB implements DAOLocation {
    private static final Logger logger = LogManager.getLogger(LocationModelDB.class);
    private Connection dbConnect;

    public LocationModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            logger.error("Erreur de connexion");
            System.exit(1);
        }
        logger.info("Connexion établie");
    }

    @Override
    public Location addLocation(Location location) {
        String query1 = "insert into APILOCATION(dateloc, kmtotal, cout, idadresse,idclient) values(?,?,?,?,?)";
        String query2 = "select max(idlocation) from APILOCATION where idadresse = ? and idclient = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
            PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ){
            pstm1.setDate(1, Date.valueOf(location.getDateloc()));
            pstm1.setInt(2, location.getKmtotal());
            pstm1.setDouble(3, location.getCout());
            pstm1.setInt(4, location.getAdrDepart().getId());
            pstm1.setInt(5, location.getClient().getId());
            int n = pstm1.executeUpdate();
            if(n == 1){
                pstm2.setInt(1, location.getAdrDepart().getId());
                pstm2.setInt(2, location.getClient().getId());
                ResultSet rs = pstm2.executeQuery();
                if(rs.next()){
                    int idlocation = rs.getInt(1);
                    location.setId(idlocation);
                    return location;
                }
                else {
                    logger.error("Record introuvable");
                    return null;
                }
            }
            else return null;
        } catch (SQLException e) {
            logger.error("Erreur sql : "+e);
            return null;
        }
    }

    @Override
    public boolean removeLocation(Location location) {
        String query = "delete from APILOCATION where idlocation = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            pstm.setInt(1, location.getId());
            int n = pstm.executeUpdate();
            return n == 1;
        } catch (SQLException e) {
            logger.error("Erreur sql : "+e);
            return false;
        }
    }

    @Override
    public Location updateLocation(Location location) {
        String query = "update APILOCATION set dateloc = ?, kmtotal = ?, cout = ?, idadresse = ?, idclient = ? where idlocation = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            pstm.setDate(1, Date.valueOf(location.getDateloc()));
            pstm.setInt(2, location.getKmtotal());
            pstm.setDouble(3, location.getCout());
            pstm.setInt(4, location.getAdrDepart().getId());
            pstm.setInt(5, location.getClient().getId());
            pstm.setInt(6, location.getId());
            int n = pstm.executeUpdate();
            if(n == 1) return location;
            else return null;
        } catch (SQLException e) {
            logger.error("Erreur sql : "+e);
            return null;
        }
    }

    @Override
    public Location readLocation(int idLocation) {
        String query = "select * from VUELOCATION where idlocation = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            pstm.setInt(1, idLocation);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int idclient = rs.getInt(1);
                String mail = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
            }
            try{
                Client cl = new Client(idclient,mail,nom,prenom,tel);

            }

        } catch (SQLException e) {
            System.out.println("Erreur : "+e.getMessage());
            return null;
        }
    }

    @Override
    public List<Location> getLocations() {

    }

    @Override
    public List<Location> getLocationsByDateDebut(String dateDebut) {

    }

    @Override
    public List<Location> getLocationsByClient(int idClient) {

    }
}
