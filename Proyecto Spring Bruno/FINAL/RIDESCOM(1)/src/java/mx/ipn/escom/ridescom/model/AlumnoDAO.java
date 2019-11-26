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
public class AlumnoDAO {
//Conexion cn=new Conexion();
    Connect cn=new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement psp;
    ResultSet rsp;
    
    public Usuario validar(String usuario){
        Usuario us=new Usuario();

        String sql="select Nombre_U, Roles_ID_Roles from usuario u inner join (Persona p, Alumno a) on (p.ID_Persona=u.Persona_ID_Persona and p.ID_Persona=a.Persona_ID_Persona) where u.Nombre_U=? and a.ID_Alumno=? and u.Activo=1";
        try{
            con=cn.Connect();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, usuario);
            rs=ps.executeQuery();

            while(rs.next()){
                us.setNombre_U(rs.getString("Nombre_U"));
                us.setRol(rs.getInt("Roles_ID_Roles"));
            }
        }catch(Exception e){
        }
        
        return us;
    }
}
