/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.Controller;

import org.springframework.stereotype.Controller;
import mx.ipn.escom.ridescom.Config.Conexion;
//import mx.ipn.escom.ridescom.Config.Crawler;
import mx.ipn.escom.ridescom.Entidad.Alumno;
import mx.ipn.escom.ridescom.Entidad.Usuario;
import mx.ipn.escom.ridescom.Entidad.Crawlerdat;
import java.io.IOException;
import java.util.List;
import mx.ipn.escom.ridescom.Bs.Crawlerlog;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class Insertadatos {
    Conexion con=new Conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarApp());
    JdbcTemplate jdbcTemplate1=new JdbcTemplate(con.ConectarSAES());
    ModelAndView mav=new ModelAndView();
    
    String cadena;
    String sa;
    //String prin;
    //String di = "principal.htm";
    
    @Autowired
    private Crawlerlog Crawlerlog;
//Crawler crw = new Crawler ();
    //private Crawler Crawler;
    
    @RequestMapping(value="iniciosesion.htm", method = RequestMethod.GET)
    
    public ModelAndView inicia() throws IOException, Exception{
       // String dire=this.crw.craw();
        cadena = Crawlerlog.downloadCaptcha(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        
        mav.addObject(new Usuario());
        mav.addObject(new Crawlerdat());
        mav.setViewName("iniciosesion");
        return mav;
    }
    
    @RequestMapping(value="iniciosesion.htm", method = RequestMethod.POST)
    public ModelAndView inicia(Crawlerdat c) throws Exception{
//        System.out.println("--> R: "+c.getRegno());
//        System.out.println("--> P: "+c.getPasswd());
//        System.out.println("--> V: "+c.getVrfcd());
        this.Crawlerlog.run();
       
       return new ModelAndView("redirect:/principal.htm");
    }
    
    @RequestMapping(value="inicioasesionCord.htm", method = RequestMethod.GET)
    public ModelAndView iniciaCord() throws IOException{
       // String dire=this.crw.craw();
        //cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        mav.addObject(new Usuario());
        //mav.addObject(new Crawler());
        mav.setViewName("iniciasesionCord");
        return mav;
    }
    
    @RequestMapping(value="iniciasesionJFD.htm", method = RequestMethod.GET)
    public ModelAndView iniciaJFD() throws IOException{
       // String dire=this.crw.craw();
        //cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        mav.addObject(new Usuario());
        //mav.addObject(new Crawler());
        mav.setViewName("iniciasesionJFD");
        return mav;
    }
    
    @RequestMapping(value="ingresa_resultados.htm", method = RequestMethod.GET)
    public ModelAndView re(){
        //mav.addObject(new resultados);
        mav.setViewName("ingresa_resultados");
        return mav;
    }
    /*public ModelAndView inicia(Crawler c) throws Exception{
       this.crw.getData(c.getRegno(),c.getPasswd(),c.getVrfcd());
       return new ModelAndView("redirect:/index.htm");
    }*/
    
    @RequestMapping(value="registrar.htm", method = RequestMethod.GET)
    public ModelAndView registra(){
        mav.addObject(new Alumno());
        mav.setViewName("registrar");
        return mav;
    }

}
