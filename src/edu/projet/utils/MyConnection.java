/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mey
 */
public class MyConnection {

    public String url = "jdbc:mysql://localhost:3306/esprit";
    public String login = "root";
    public String pwd = "";
    public static MyConnection instance;
    public Connection cnx;

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }
    

    public Connection getcnx() {
        return cnx;
    }

    public static class getInstance extends MyConnection {

        public getInstance() {
        }
    }

}
