package exercicesJDBC;

import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1 {
    public void demo(){

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        String query = "select * from APITCLIENT";
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                String n = "" + rs.getInt("IDCLIENT");
                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");
                String mail = rs.getString("MAIL");
                String tel = rs.getString("TEL");
                System.out.println(n + " " + prenom + " " + nom + " " + mail + " " + tel);
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        }

        DBConnection.closeConnection();
    }

    public static void main(String[] args) {
        ex1 pgm = new ex1();
        pgm.demo();
    }
}
