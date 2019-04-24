/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import Config.Conexion;
import Config.Crawler;
import Entidad.Alumno;
import Entidad.Usuario;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class insertadatos {
    Conexion con=new Conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarApp());
    JdbcTemplate jdbcTemplate1=new JdbcTemplate(con.ConectarSAES());
    ModelAndView mav=new ModelAndView();
    
    String cadena;
    Crawler crw = new Crawler ();
    //private Crawler Crawler;
    
    @RequestMapping(value="Login.htm", method = RequestMethod.GET)
    public ModelAndView inicia() throws IOException{
       // String dire=this.crw.craw();
        cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        mav.addObject(new Usuario());
        mav.addObject(new Crawler());
        mav.setViewName("Login");
        return mav;
    }
    @RequestMapping(value="Login.htm", method = RequestMethod.POST)
    public ModelAndView inicia(Crawler c) throws Exception{
       this.crw.getData(c.getRegno(),c.getPasswd(),c.getVrfcd());
       return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping(value="registrar.htm", method = RequestMethod.GET)
    public ModelAndView registra(){
        mav.addObject(new Alumno());
        mav.setViewName("registrar");
        return mav;
    }
    
   @RequestMapping(value="LoginC.htm", method = RequestMethod.GET)
    public ModelAndView loginC(){
        mav.addObject(new Usuario());
        return mav;
    }
}
