package mvp.model;

import metier.Adresse;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseModelDB implements DAOAdresse {
    private static final Logger logger = LogManager.getLogger(AdresseModelDB.class);
    private Connection dbConnect;

    public AdresseModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            logger.error("Erreur de connexion");
            System.exit(1);
        }
        logger.info("Connexion établie");
    }

    @Override
    public Adresse addAdresse(Adresse adresse) {
        String query1 = "insert into APIADRESSE(cp,localite,rue,num) values(?,?,?,?)";
        String query2 = "select id from APIADRESSE where cp = ? and localite = ? and rue = ? and num = ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2)){
            pstm1.setInt(1,adresse.getCp());
            pstm1.setString(2,adresse.getLocalite());
            pstm1.setString(3,adresse.getRue());
            pstm1.setString(4,adresse.getNum());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setInt(1,adresse.getCp());
                pstm2.setString(2,adresse.getLocalite());
                pstm2.setString(3,adresse.getRue());
                pstm2.setString(4,adresse.getNum());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idadresse= rs.getInt(1);
                    adresse.setId(idadresse);
                    return adresse;
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
    public boolean removeAdresse(Adresse adresse) {
        String query = "delete from APIADRESSE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,adresse.getId());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;
        } catch (SQLException e) {
            logger.error("Erreur d'effacement : "+e);
            return false;
        }
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
        String query = "update APIADRESSE set cp = ?, localite = ?, rue = ?, num = ? where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,adresse.getCp());
            pstm.setString(2,adresse.getLocalite());
            pstm.setString(3,adresse.getRue());
            pstm.setString(4,adresse.getNum());
            pstm.setInt(5,adresse.getId());
            int n = pstm.executeUpdate();
            if(n!=0) return readAdresse(adresse.getId());
            else return null;
        } catch (SQLException e) {
            logger.error("Erreur d'update : "+e);
            return null;
        }
    }

    @Override
    public Adresse readAdresse(int idAdresse) {
        String query = "select * from APIADRESSE where id = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idAdresse);
            try(ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    int cp = rs.getInt(2);
                    String localite = rs.getString(3);
                    String rue = rs.getString(4);
                    String num = rs.getString(5);
                    return new Adresse(idAdresse,cp,localite,rue,num);
                } else {
                    logger.error("Record introuvable");
                    return null;
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur de lecture : "+e);
            return null;
        }
    }

    @Override
    public List<Adresse> getAdresses() {
        List<Adresse> liste = new ArrayList<>();
        String query = "select * from APIADRESSE";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            try(ResultSet rs = pstm.executeQuery()) {
                while(rs.next()){
                    int id = rs.getInt(1);
                    int cp = rs.getInt(2);
                    String localite = rs.getString(3);
                    String rue = rs.getString(4);
                    String num = rs.getString(5);
                    liste.add(new Adresse(id,cp,localite,rue,num));
                }
                return liste;
            }
        } catch (SQLException e) {
            logger.error("Erreur de lecture : "+e);
            return null;
        }
    }
}
