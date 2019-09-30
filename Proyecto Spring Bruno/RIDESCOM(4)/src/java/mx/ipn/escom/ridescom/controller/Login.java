/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
    ModelAndView mav=new ModelAndView();
    Conexion cn=new Conexion();
    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    List dat;
    
    @RequestMapping(value="Login", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")== null){
            mav.setViewName("Login");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("ESCOM")){
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="Login", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("Nombre_U");
        String pass=req.getParameter("Password_U");
        String jefe= "DDyFD";
        
        us=udao.validar(usuario, pass);
        if(us.getNombre_U()!= null){
            if(us.getNombre_U().equals(jefe)){
            
            HttpSession session=req.getSession();
            session.setAttribute("Nombre_U", jefe); //user
            return new ModelAndView("redirect:/DDyFD");
            }else {
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Coordinador");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login");
        }
    }
    
    @RequestMapping(value="Error")
    public ModelAndView alumno(){   
        mav.setViewName("Error404");
        return mav;
    }
}
