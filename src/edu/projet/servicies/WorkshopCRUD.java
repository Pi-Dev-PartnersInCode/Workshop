/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.servicies;

import edu.projet.entities.Workshop;
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
public class WorkshopCRUD {
    
    
    
    Connection cn2;
    Statement st;

    public WorkshopCRUD() {
        cn2 = MyConnection.getInstance().getcnx();
    }


    public void ajouterWorkshop(Workshop w) {
        try {
            String requete2 = "INSERT INTO  Workshop VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
            pst.setInt(2, w.getIdW());
            pst.setString(1, w.getNameW());
            pst.setString(3, w.getDateW());
            pst.setString(4, w.getDuration());
            pst.setString(5, w.getAddressW());
            pst.setInt(6, w.getIdTrainer());

            pst.executeUpdate();
            System.out.println("added");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void supprimerWorkshop (int idW){
   
           String req="delete from Workshop where idW=?";
                    PreparedStatement preparedStatement;

        try{
                       preparedStatement = cn2.prepareStatement(req);

           preparedStatement.setInt(1, idW);
           preparedStatement.executeUpdate();
        }catch(SQLException er){
            System.out.println("delete erreur Workshop ");
        }
    }
    
    
   
    public void modifierWorkshop(Workshop w) {

        String sql = "UPDATE Workshop SET   NameW=?, Date=?, Duration=?  , AddressW=?  where idW=" + w.getIdW();

        PreparedStatement ps;
        try {
            ps = cn2.prepareStatement(sql);

            ps.setString(1, w.getNameW());
            ps.setString(2, w.getDateW());
            ps.setString(3, w.getDuration());
            ps.setString(4, w.getAddressW());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le workshop a été modifier avec succès");
            }
        } catch (SQLException e) {
            System.out.println("Erreur" );

        }

    }

    /**
     *
     * @return
     */
    public List<Workshop> afficherWorkshop() {
        ArrayList<Workshop> per = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM Workshop";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Workshop w;
                w = new Workshop();

                w.setIdW(rs.getInt("idW"));
                w.setNameW(rs.getString("NameW"));
                w.setDateW(rs.getString("Date"));
                w.setDuration(rs.getString("Duration"));
                w.setAddressW(rs.getString("AddressW"));
                w.setIdTrainer(rs.getInt("idTrainer"));

                per.add(w);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return per;

    }
}
