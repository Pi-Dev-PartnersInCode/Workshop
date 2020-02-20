/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Member;
import entities.Member;
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
public class MemberCRUD {

    Connection cn2;
    Statement st;

    public MemberCRUD() {
        cn2 = MyConnection.getInstance().getcnx();
    }

    public void ajouterMember(Member m) {
        try {
            String requete2 = "INSERT INTO  Member VALUES (?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
            pst.setInt(1, m.getIdM());
            pst.setString(2, m.getNameM());
            pst.setInt(3, m.getCinM());
            pst.setInt(4, m.getIdW());
            pst.setInt(5, m.getIdUser());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerMember(Member m) {

        String req = "delete from Member where idM=?";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = cn2.prepareStatement(req);

            preparedStatement.setInt(1, m.getIdM());
            preparedStatement.executeUpdate();
        } catch (SQLException er) {
            System.out.println("delete erreur Member");
        }
    }



    public List<Member> afficherMember() {
        ArrayList<Member> per = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM Member";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Member m = new Member();

                m.setIdM(rs.getInt("idM"));
                m.setCinM(rs.getInt("CinM"));
                m.setNameM(rs.getString("NameM"));
                m.setIdUser(rs.getInt("idUser"));
                m.setIdW(rs.getInt("idW"));

                per.add(m);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return per;

    }

}
