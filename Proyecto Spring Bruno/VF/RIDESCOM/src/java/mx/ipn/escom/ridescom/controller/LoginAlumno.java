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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.captcha.botdetect.web.servlet.Captcha;
import java.io.FileWriter;
import java.io.PrintWriter;
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
import mx.ipn.escom.ridescom.config.Connect;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LoginAlumno {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
//    Connection con;
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
//    PreparedStatement ps;
//    ResultSet rs;
    Craw cw=new Craw();
    
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    Usuario us=new Usuario();
    Crawler cra=new Crawler();
    UsuarioDAO udao=new UsuarioDAO();
//    CrawlerDAO crdao=new CrawlerDAO();
    
    List dat;
    
    public Map<String, String> cookies;

	private static String saes = "https://www.saes.escom.ipn.mx/";
	private static String logi = "https://www.saes.escom.ipn.mx/Default.aspx";
	public static String user = "https://www.saes.escom.ipn.mx/Alumnos/default.aspx";

    
    @RequestMapping(value="LoginAlumno.html", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req) throws IOException, Exception{
        HttpSession session = req.getSession();
        String ur="select Roles_ID_Roles from usuario where Nombre_U='"+session.getAttribute("Nombre_U")+"';";
         try{
            ct=cn.Connect();
            ps=ct.prepareStatement(ur);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next() ){
                ro =rs.getString("Roles_ID_Roles");
                }
            }
        }catch(Exception e){
        }
        if(session.getAttribute("Nombre_U")!= null){
            if(ro.equals("1")){
            mav.setViewName("redirect:/DDyFD.html");
            }else if(ro.equals("2")){
            mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
            mav.setViewName("redirect:/Alumno.html");    
            }
        }else{
            cw.ca();
//            downloadCaptcha();
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
        System.out.println("Entra usuario" + usuario + pass+ capt);
        //String jefe= "DDyFD";
        if(capt==null || capt.equals(" ")){
            mav.setViewName("redirect:/LoginAlumno.html");
                    mav.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido. null</div>"); 
        }else{
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
//                // validate the Captcha to check we're not dealing with a bot
//    Captcha captcha = Captcha.load(req, "basicExample");
//    boolean isHuman = captcha.validate(capt);
//    
//    if (isHuman) {
//        mav.setViewName("redirect:/LoginAlumno.html");
//        mav.addObject("mjs", "<div style='color: red;'>ES HUMANO</div>"); 
//    } else {
//     mav.setViewName("redirect:/LoginAlumno.html");
//        mav.addObject("mjs", "<div style='color: red;'>Que pedo?</div>"); 
//    }
                //Aqui deberia ir el crawler
                cw.setRegno(usuario);
                cw.setPasswd(pass);
                cw.setCapt(capt);
                    mav.setViewName("redirect:/LoginAlumno.html");
                    String datos = "Entra usuario"+" "+" "+cw.getRegno()+" "+cw.getPasswd()+" "+cw.getCapt();
                    mav.addObject("mjs", "<div style='color: red;'>"+datos+"</div>"); 
                }
        }
        }else{
            mav.setViewName("redirect:/LoginAlumno.html");
        }
        return mav;
    }
    
    @RequestMapping(value="Privacidad.html")
    ModelAndView term(){
        mav.setViewName("Condiciones");
        return mav;
    }
    
}