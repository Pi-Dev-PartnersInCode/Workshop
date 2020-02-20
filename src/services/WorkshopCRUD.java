/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Trainer;
import entities.Workshop;
import utils.MyConnection;
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
            pst.setInt(6,w.getMyTrainer().getIdTrainer());
            
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
    
    
      public Workshop rechercherWorkshopByID(int idWorkshop) {
     Workshop w = null;
            try
        {
            Statement ps = cn2.createStatement();
            Statement ps2 = cn2.createStatement();
            ResultSet res;
            ResultSet res2 ;
            res=ps.executeQuery("select w.*,t.* from Workshop w inner join trainer t on w.idTrainer = t.idTrainer  where idW="+idWorkshop);
            while(res.next())
            { 
                    Trainer t = new Trainer(res.getInt("idTrainer"),res.getString("NameT"),res.getString("CinT") , res.getString("Speciality"));
                    w = new Workshop(res.getString("NameW"),res.getInt("idW"),res.getString("DateW"),res.getString("Duration"),res.getString("AddressW"),t);
                    int idW = res.getInt("idW"); 
                    w. setIdW(idW);
                    w.setNameW(res.getString("NameW"));
            }
        }catch(SQLException e)
        {
           System.out.println("Workshop Introuvable"+e.getMessage());
        } 
         return w;
          
 }
      
            public Workshop rechercheByName(String nomworkshop) {
           
         
        
        try { 
            Statement ps=cn2.createStatement();
            ResultSet res;
            
            res=ps.executeQuery("select * from Workshop where NameW like '%"+nomworkshop+"%' ");
            while(res.next())
            {
               
                String NameW=res.getString("NameW");
                 int idW = res.getInt("idW");
                String DateW=res.getString("DateW"); 
                String Duration=res.getString("Duration");
                String AddressW=res.getString("AddressW");
                int  idTrainer=res.getInt("idTrainer");
 
                
               
               
              
             return  new  Workshop(idW, NameW, DateW, Duration  ,AddressW, idTrainer);   
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur"+ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @return
     */
    public List<Workshop> afficherWorkshop() {
        
        ArrayList<Workshop> per = new ArrayList<>();
        try {
 ResultSet res;
            String requete3 = "select w.*,t.* from Workshop w inner join trainer t on w.idTrainer = t.idTrainer";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Workshop w;
                w = new Workshop();
  Trainer t = new Trainer(rs.getInt("idTrainer"),rs.getString("NameT"),rs.getString("CinT") , rs.getString("Speciality"));
                w.setIdW(rs.getInt("idW"));
                w.setNameW(rs.getString("NameW"));
                w.setDateW(rs.getString("DateW"));
                w.setDuration(rs.getString("Duration"));
                w.setAddressW(rs.getString("AddressW"));
                w.setMyTrainer(t);
                

                per.add(w);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return per;

    }
}
