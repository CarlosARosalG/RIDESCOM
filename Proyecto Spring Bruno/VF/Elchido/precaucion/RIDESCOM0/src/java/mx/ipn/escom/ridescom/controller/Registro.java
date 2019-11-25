/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.config.SAES;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class Registro {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
     
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    SAES sacn=new SAES();
//    java.sql.Connection cts;
//    ResultSet rss;
//    PreparedStatement pss;
    String sas;
    String reg;
    String nombre;
    String APP;
    String APM;
    String insc;
    
    List p;
    List dat;
    
    
    @RequestMapping(value="InfoAlumno.html", method=RequestMethod.GET)
    public ModelAndView Ialu(){   
        mav.setViewName("InfoAlumno");
        return mav;
    }
    @RequestMapping(value="InfoAlumno.html", method=RequestMethod.POST)
    public ModelAndView ralu(Usuario u){   
        String all="select Numero_Boleta, Nombre, Apellido_Pat, Apellido_Mat, Inscrito from estudiante where Numero_Boleta="+u.getNombre_U();
        try{
                ct=sacn.ConnectSAES();
            ps=ct.prepareStatement(all);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next() ){
                sas =rs.getString("Numero_Boleta");
                nombre=rs.getString("Nombre");
                APP=rs.getString("Apellido_Pat");
                APM=rs.getString("Apellido_Mat");
                insc=rs.getString("Inscrito");
                }
            }
            }catch(Exception ex){
            }
        if(insc.equals("1")){
            mav.addObject("bol",sas);
            mav.addObject("nom",nombre);
            mav.addObject("nom",APP);
            mav.addObject("nom",APM);
            mav.addObject("mjs", "<div style='color: red;'>"+insc+sas+nombre+APP+APM+"</div>");
            mav.setViewName("InfoAlumno");
        }else{
            mav.setViewName("InfoAlumno");
            mav.addObject("mjs", "<div style='color: red;'>Lo sentimos no estás inscrito</div>");
        }
        return mav;
    }
}
