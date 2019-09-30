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
public class Connect {
     Connection con;
    String url="jdbc:mysql://localhost:3306/ridescom";
    String user="root";
    String pass="";
    public Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            
        }
        return con;
    }
}
