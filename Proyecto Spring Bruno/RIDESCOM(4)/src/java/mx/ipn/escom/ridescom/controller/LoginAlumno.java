/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

//import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Crawler;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import mx.ipn.escom.ridescom.config.Craw;
import org.jsoup.Connection;
//import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class LoginAlumno {
    ModelAndView mav=new ModelAndView();
    Craw crw=new Craw();
    Conexion cn=new Conexion();
    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    List dat;
    
//    public Map<String, String> cookies;
//
	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

//Cerrar sesion del usuario DDyFD
    @RequestMapping(value="/Logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/LoginAlumno";
    }
    String crawl;
    @RequestMapping(value="LoginAlumno", method=RequestMethod.GET)
    public ModelAndView alumno(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){         
         String a=crw.capt();
         mav.addObject("src", a);
         mav.setViewName("LoginAlumno");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Error404");
        }else{
            mav.setViewName("Error404");
        }
        return mav;
    }
    @RequestMapping(value="Alumno", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp, Crawler cr) throws Exception{
        String regno=;
        String passwd;
        String vrfcd;
        crw.log(regno, passwd, vrfcd);
    }
    }