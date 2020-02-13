/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.servicies;

import edu.projet.entities.Trainer;
import edu.projet.entities.Trainer;
import edu.projet.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mey
 */
public class TrainerCRUD {
        Connection cn2;
    Statement st;

    public TrainerCRUD() {
        cn2 = MyConnection.getInstance().getcnx();
    }


    public void ajouterTrainer(Trainer t) {
        try {
            String requete2 = "INSERT INTO  Trainer VALUES (?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
            pst.setInt(1, t.getIdTrainer());
            pst.setString(2, t.getNameT());
            pst.setInt(3, t.getCinT());
            pst.setString(4, t.getSpeciality());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public void modifierTrainer(Trainer t) {

        String sql = "UPDATE Trainer SET   NameT=?,CinT=?, Speciality=?  where idTrainer=?";// + t.getIdTrainer();

        PreparedStatement ps;
        try {
            ps = cn2.prepareStatement(sql);

            ps.setString(1, t.getNameT());
            ps.setInt(2, t.getCinT());
            ps.setString(3, t.getSpeciality());
                        ps.setInt(4, t.getIdTrainer());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le trainer a été modifier avec succès");
            }
        } catch (SQLException e) {
            System.out.println("Erreur " );

        }

    }
        public void supprimerTrainer(Trainer t){
   
           String req="delete from Trainer where idTrainer=?";
                    PreparedStatement preparedStatement;

        try{
                       preparedStatement = cn2.prepareStatement(req);

           preparedStatement.setInt(1, t.getIdTrainer());
           preparedStatement.executeUpdate();
        }catch(SQLException er){
            System.out.println("delete erreur Trainer");
        }
    }

    public List<Trainer> afficherTrainer() {
        ArrayList<Trainer> per = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM Trainer";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Trainer t = new Trainer();

                t.setIdTrainer(rs.getInt("idTrainer"));
               t.setNameT(rs.getString("NameT"));
                t.setCinT(rs.getInt("CinT"));
                t.setSpeciality(rs.getString("Speciality"));
            

                per.add(t);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return per;

    }
}
