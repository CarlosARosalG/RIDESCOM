/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos A. Rosales
 */
public class ConectaCedula {
    
    private final String base = "ridescom";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3308/" + base;
    private Connection con = null;
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.err.println(e);
        } 
        
        return con;
    }
    
}
