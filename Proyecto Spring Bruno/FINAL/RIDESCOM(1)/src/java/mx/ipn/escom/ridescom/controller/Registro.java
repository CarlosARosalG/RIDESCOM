/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;

    String sas;
    String reg;
    String nombre;
    String APP;
    String APM;
    String insc;
    
    List p;
    List dat;
    
    
    @RequestMapping(value="InfoAlumno.html", method=RequestMethod.GET)
    public ModelAndView Ialu(HttpServletRequest re){   
//        HttpSession session = re.getSession();
//        String ur="select Roles_ID_Roles from usuario where Nombre_U='"+session.getAttribute("Nombre_U")+"';";
//         try{
//            ct=cn.Connect();
//            ps=ct.prepareStatement(ur);
//            rs=ps.executeQuery();
//            if(rs!=null ){
//                while(rs.next() ){
//                ro =rs.getString("Roles_ID_Roles");
//                }
//            }
//        }catch(Exception e){
//        }
//        if(session.getAttribute("Nombre_U")== null){
//         mav.setViewName("redirect:/Login.html");
//        }else{
//            if(ro.equals("1")){
//            mav.setViewName("redirect:/DDyFD.html");
//            }else if(ro.equals("2")){
//            mav.setViewName("redirect:/Coordinador.html");
//            }else if(ro.equals("3")){
            mav.setViewName("InfoAlumno");    
//            }
//        }
        return mav;
    }
    @RequestMapping(value="InfoAlumno.html", method=RequestMethod.POST)
    public ModelAndView ralu(Usuario u){   
            
        return mav;
    }
}
