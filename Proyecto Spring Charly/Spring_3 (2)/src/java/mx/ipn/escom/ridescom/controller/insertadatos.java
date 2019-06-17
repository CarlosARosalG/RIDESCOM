/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import org.springframework.stereotype.Controller;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Crawler;
import mx.ipn.escom.ridescom.model.Alumno;
import mx.ipn.escom.ridescom.model.Usuario;
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
    //String prin;
    //String di = "principal.htm";
    
    Crawler crw = new Crawler ();
    //private Crawler Crawler;
    
    @RequestMapping(value="iniciosesion.htm", method = RequestMethod.GET)
    public ModelAndView inicia() throws IOException{
       // String dire=this.crw.craw();
        cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
       
        mav.addObject("src",cadena);
        
        mav.addObject(new Usuario());
        mav.addObject(new Crawler());
        mav.setViewName("iniciosesion");
        return mav;
    }
    
    @RequestMapping(value="iniciosesion.htm", method = RequestMethod.POST)
    public ModelAndView inicia(Crawler c) throws Exception{
       this.crw.getData(c.getRegno(),c.getPasswd(),c.getVrfcd());
       return new ModelAndView("redirect:/principal.htm");
    }
    
    @RequestMapping(value="iniciasesionCord.htm", method = RequestMethod.GET)
    public ModelAndView iniciaCord() throws IOException{
       // String dire=this.crw.craw();
        cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        mav.addObject(new Usuario());
        mav.addObject(new Crawler());
        mav.setViewName("iniciasesionCord");
        return mav;
    }
    
    @RequestMapping(value="iniciasesionJFD.htm", method = RequestMethod.GET)
    public ModelAndView iniciaJFD() throws IOException{
       // String dire=this.crw.craw();
        cadena = this.crw.craw(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav.addObject("src",cadena);
        mav.addObject(new Usuario());
        mav.addObject(new Crawler());
        mav.setViewName("iniciasesionJFD");
        return mav;
    }
    
    @RequestMapping(value="ingresaresultados.htm", method = RequestMethod.GET)
    public ModelAndView re(){
        String sql1 = " INSERT INTO Resultados  (Lugar_Obtenido, Marca, Alumno_has_Evento_Alumno_ID_Alumno, Alumno_has_Evento_Evento_Evento_ID)\n" +
"	values ('2', '1:45','2015630443', '1');  ";
        
        //mav.addObject(new resultados);
        mav.setViewName("ingresaresultados");
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
    
    @RequestMapping(value="registroentrenador.htm", method= RequestMethod.GET)
    public ModelAndView entrenador(){
        String sql1 = " insert into Persona(Nombre, Ap_Pat, Ap_Mat, Tipo_Sexo_ID_Tipo_Sexo, CURP, Fecha_Nac, NSS, Usuario_Usuario_ID, Municipio_ID_Municipio, Municipio_Estados_ID_estado)\n" +
"	values ('José', 'Ramirez', 'Olvera', '1','ROGC960117HDFSNR09', '1996-01-17','123456789', '4', '0222','07'); ";
//        mav.addObject(new entrenador());
        mav.setViewName("registroentrenador");
        return mav;
    }
    
    @RequestMapping(value="registroevento.htm", method= RequestMethod.GET)
    public ModelAndView evento(){
        String sql1 = " insert into Evento (Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_evento, Descripcion, Fecha_Evento, Ciclo_ID_Ciclo, Act_Deportiva_ID_Deporte) \n" +
"			values ('Evento de Atlestismo', '2019-06-15', '2019-06-17', 'Estadio Wilfrido el evento se llevara a cabo dentro del estudio', 'Evento deportivo para atletismo', '2019-07-15', '1', '4'); ";
//        mav.addObject(new Evento());
        mav.setViewName("registroevento");
        return mav;
    }
    
    @RequestMapping(value="Registracord.htm", method= RequestMethod.GET)
    public ModelAndView cord(){
     
        mav.setViewName("Registrarcord");
        return mav;
    }
    
    @RequestMapping(value="inscripcioninter2.htm", method= RequestMethod.GET)
    public ModelAndView inscribe2(){
     
        mav.setViewName("inscripcioninter2");
        return mav;
    }
    
    @RequestMapping(value="inscripcioninter3.htm", method= RequestMethod.GET)
    public ModelAndView inscribe3(){
     
        mav.setViewName("inscripcioninter3");
        return mav;
    }
    
}
