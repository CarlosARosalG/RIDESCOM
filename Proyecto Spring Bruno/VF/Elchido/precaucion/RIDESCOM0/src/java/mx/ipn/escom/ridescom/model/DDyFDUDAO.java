/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mx.ipn.escom.ridescom.config.Connect;

/**
 *
 * @author spy51
 */
public class DDyFDUDAO {
    //Conexion cn=new Conexion();
    Connect cn=new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement psp;
    ResultSet rsp;
    
    public Usuario validar(String usuario, String pass){
        Usuario usf=new Usuario();

        String sql="select Nombre_U, Password_U, Roles_ID_Roles from usuario where BINARY Nombre_U=? and BINARY Password_U=? and Activo=1 and Roles_ID_Roles=1";
        try{
            con=cn.Connect();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();

            while(rs.next()){
                //us.setNombre_U(rs.getString("ID_Roles"));
                usf.setNombre_U(rs.getString("Nombre_U"));
                usf.setPassword_U(rs.getString("Password_U"));
//                us.setRol(rs.getInt("Roles_ID_Roles"));
            }
        }catch(Exception e){
        }
        
        return usf;
    }

}

