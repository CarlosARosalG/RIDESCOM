/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
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
public class ResultadosAL {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    int ResulID;
    
    ResultSet rs=null;
    PreparedStatement ps;
    
    List dat;
    List dat2;
    List es;
    List ust;
    String p;
    String a;
    String co;
    
    @RequestMapping(value="Alumno/Resultados.html", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")!= null){
            if(us.getRol()==1){
                mav.setViewName("DDyFD");
            }else if(us.getRol()==2){
                mav.setViewName("CoordUA");
            }else if(us.getRol()==3){
                mav.setViewName("ResultadosAlumno");
            }
        }else{
            mav.setViewName("Login");
        }
        return mav;
    }
}
