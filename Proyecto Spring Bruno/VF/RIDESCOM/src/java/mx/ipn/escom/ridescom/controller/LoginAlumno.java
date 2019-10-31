/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

//import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
//import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Craw;
import mx.ipn.escom.ridescom.model.Crawler;
import mx.ipn.escom.ridescom.model.CrawlerDAO;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LoginAlumno {
    ModelAndView mav=new ModelAndView();
    Conexion cn=new Conexion();
//    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
//    PreparedStatement ps;
//    ResultSet rs;
    Craw cw=new Craw();
    
    Usuario us=new Usuario();
    Crawler cra=new Crawler();
    UsuarioDAO udao=new UsuarioDAO();
//    CrawlerDAO crdao=new CrawlerDAO();
    
    List dat;
    
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req) throws IOException, Exception{
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")!= null){
            if(us.getRol()==1){
                mav.setViewName("Error404");
            }else if(us.getRol()==2){
                mav.setViewName("CoordUA");
            }else if(us.getRol()==3){
                mav.setViewName("Alumno");
            }
        }else{
            cw.downloadCaptcha();
            mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp, Craw cw) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("User");
        String pass=req.getParameter("Password");
        String capt=req.getParameter("Captcha");
        //String jefe= "DDyFD";
        
            us=udao.validar(usuario, pass);
            if(us.getNombre_U()!= null){
                if(us.getRol()==3){
                    HttpSession session=req.getSession();
                    session.setAttribute("Nombre_U", usuario); //user
                    return new ModelAndView("redirect:/Alumno.html");
                }else{
                    return new ModelAndView("redirect:/Error404.html");
                }
            }else{
                //Aqui deberia ir el crawler
                    mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>"); 
                }
        }else{
                
                    mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>"); 
                }
        return mav;
    }
    
    @RequestMapping(value="Privacidad.html")
    ModelAndView term(){
        mav.setViewName("Condiciones");
        return mav;
    }
    
}