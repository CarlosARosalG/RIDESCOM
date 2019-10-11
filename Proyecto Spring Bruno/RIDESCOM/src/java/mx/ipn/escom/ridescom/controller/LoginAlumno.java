/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

//import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import mx.ipn.escom.ridescom.model.AlumnoDAO;
import mx.ipn.escom.ridescom.config.Craw;
import static mx.ipn.escom.ridescom.config.Craw.cookies;
import mx.ipn.escom.ridescom.config.Crawp;
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
//    Crawp crwp=new Crawp();
    Crawler crawl=new Crawler();
    Conexion cn=new Conexion();
    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario usu=new Usuario();
    AlumnoDAO adao=new AlumnoDAO();
    
    List dat;
    
    public String regno;
    public String passwd;
    public String vrfcd;
    
    private static final String saes = "https://www.saes.escom.ipn.mx/";
    private static final String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
    public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";
    
//Cerrar sesion del usuario DDyFD
    @RequestMapping(value="/Logout.html", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/LoginAlumno.html";
    }
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.GET)
    public ModelAndView alumno(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
            if(usu.getRol()==1){
            mav.setViewName("DDyFD");
        }else if(usu.getRol()==2){
            mav.setViewName("CoordUA");
        }else{
            mav.setViewName("Alumno");
        }
        }else {
            crw.conectar();
            crw.res();
            crw.cookie();
            crw.d();
            crw.capt();
            crw.im();
            crw.ima();// DEBERIA DE GENERAR IMAGENES
            crw.form();
         mav.addObject("src", crw.capt());
            mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp, Crawler cr) throws Exception{
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("User");
        String pass=req.getParameter("Password");
        String capt=req.getParameter("Captcha");
        //String jefe= "DDyFD";
        
        usu=adao.validar(usuario, pass);
        if(usu.getNombre_U()!= null){
//            if(usu.getRol()==1){
//
//            HttpSession session=req.getSession();
//            session.setAttribute("Nombre_U", usuario); //user
//            return new ModelAndView("redirect:/DDyFD");
//            }else if(usu.getRol()==2) {
//                HttpSession session=req.getSession();
//                session.setAttribute("Nombre_U", usuario); //user
//                return new ModelAndView("redirect:/Coordinador");
//            }else{
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Alumno.html");
//            }
        }else{
            regno=usuario;
            passwd=pass;
            vrfcd=capt;
            crw.log(regno, passwd, vrfcd);
            Connection conn = Jsoup.connect(saes+"/Default.aspx?ReturnUrl=%2falumnos%2fdefault.aspx")
	            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
	            .cookies(crw.cookie())
	            .timeout(0)
                    .data(crw.form())
	            .data("ctl00$leftColumn$LoginUser$LoginButton","Iniciar")
	            .method(Connection.Method.POST);
            Connection.Response response = conn.execute();
            response.cookies().get(logi);


            Map<String, String> loginCookies = response.cookies();

            Document docn = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/default.aspx")
	          .cookies(loginCookies)
	          .get();

            Document docs = Jsoup.connect("https://www.saes.escom.ipn.mx/Alumnos/Reinscripciones/Comprobante_Horario.aspx")
		          .cookies(loginCookies)
		          .get();

            Element n = docn.getElementById("ctl00_mainCopy_FormView1_nombrelabel");	    
	    String nombre = n.text();
            if(nombre.isEmpty()){
                    ModelAndView mv=new ModelAndView("LoginAlumno.html");
                    return mv;
            }else{
                Element e = docs.select("table#ctl00_mainCopy_GV_Horario td").first();
                String grupo=e.text();
                if(grupo.isEmpty()){
                    ModelAndView mv=new ModelAndView("LoginAlumno.html");
                    return mv;
                }else{
                    ModelAndView mv=new ModelAndView("InfoAlumno.html");
                    return mv;
                }
            }
        }
        }else{
            ModelAndView mv=new ModelAndView("LoginAlumno.html");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>");
        return mv;
        }
    }
}