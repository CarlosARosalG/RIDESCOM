/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ridescom.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.com.ridescom.config.Conexion;

/**
 *
 * @author spy51
 */
public class PersonaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Persona consultarPersona (){
        Persona p = new Persona();
        Usuario us=new Usuario();
        Contacto c=new Contacto();
        
        String sql="select Usuario.Nombre_U, Nombre, Ap_Pat, Ap_Mat, Tipo_Sexo.Sexo, CURP, DATE_FORMAT(Fecha_Nac, %d/%m/%Y)AS Fecha_Nac, NSS,  from Persona"
                + "inner join (Usuario,Tipo_Sexo) on (Persona.Usuario_Usuario_ID=Usuario.Usuario_ID AND Persona.Tipo_Sexo_ID_Tipo_Sexo=Tipo_Sexo.ID_Tipo_Sexo)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
         
        }catch(Exception e){
        }
        return p;
    }
}