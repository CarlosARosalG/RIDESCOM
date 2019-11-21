/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author spy51
 */
public class SAES {
    Connection con;
    String url="jdbc:mysql://localhost:3308/saes_dae";
    String user="root";
    String pass="";
    public Connection ConnectSAES(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            
        }
        return con;
    }
}
