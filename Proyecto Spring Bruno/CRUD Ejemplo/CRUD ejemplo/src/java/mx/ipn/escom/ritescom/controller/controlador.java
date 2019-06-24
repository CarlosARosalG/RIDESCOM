package mx.ipn.escom.ritescom.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import mx.ipn.escom.ritescom.bs.PruebaBs;
import org.springframework.stereotype.Controller;
import mx.ipn.escom.ritescom.config.Conexion;
import java.util.List;
import mx.ipn.escom.ritescom.entidad.Deporte;
import mx.ipn.escom.ritescom.entidad.Usuario;
import mx.ipn.escom.ritescom.entidad.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author spy51
 */
@Controller
public class controlador {
    Conexion con=new Conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.Conectarp());
    JdbcTemplate jdbcTemplate1=new JdbcTemplate(con.ConectarApp());
    ModelAndView mav1=new ModelAndView();
    
    String cadena;
    @Autowired
    private PruebaBs pruebaBs;
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        //Query BD_puser
        String sql="select * from usuarios";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav1.addObject("lista",datos);
        //Query BD_Act_Deportiva RIDESCOM
        String sql1="select * from Act_Deportiva";
        List datos1=this.jdbcTemplate1.queryForList(sql1);
        mav1.addObject("rid",datos1);
        
        mav1.setViewName("index"); //Nombre del JSP
        //Hermes example
        cadena = pruebaBs.pruba(); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav1.addObject("cadena", cadena);
        
        return mav1;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav1.addObject(new Usuario());
        mav1.setViewName("agregar");
        return mav1;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Usuario u){
        
        String sql= "insert into usuarios(Nombre_user, Psw_user) values (?,?);";
        this.jdbcTemplate.update(sql, u.getNombre_user(),u.getPsw_user());
        return new ModelAndView("redirect:/index.htm");
    }

    @RequestMapping(value = "agregard.htm", method = RequestMethod.GET)
    public ModelAndView Agregard(){
        mav1.addObject(new Deporte());
        mav1.setViewName("agregard");
        return mav1;
    }
    @RequestMapping(value = "agregard.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Deporte d){
        
        String sql= "insert into Act_Deportiva(ID_Deporte,Disciplina) values (?,?);";
        this.jdbcTemplate1.update(sql, d.getID_Deporte(), d.getDisciplina());
        return new ModelAndView("redirect:/index.htm");
    }
    
    @RequestMapping("Registrarevent.htm")
    public ModelAndView Listard(){
        //Query BD_Act_Deportiva RIDESCOM
        String sql1="select * from Act_Deportiva";
        List datos1=this.jdbcTemplate1.queryForList(sql1);
        mav1.addObject("rid",datos1);
        mav1.setViewName("Registrarevent"); //Nombre del JSP
        return mav1;
    }
    
    @RequestMapping(value = "Registrarevent.htm", method = RequestMethod.GET)
    public ModelAndView Agregare(){
        mav1.addObject(new Evento());
//        String sql1="select * from Act_Deportiva";
//        List datos1=this.jdbcTemplate1.queryForList(sql1);
//        mav1.addObject("ride",datos1);
        mav1.setViewName("Registrarevent");
        return mav1;
    }
    @RequestMapping(value = "Registrarevent.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Evento e){
        
        String sql= "insert into Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_evento, Descripcion, Fecha_Evento, Cliclo_ID_Ciclo, Act_Deportiva_ID_Deporte) values (?,?,?,?,?,?,?,?);";
        this.jdbcTemplate1.update(sql, e.getNombre_E(), e.getFecha_in(), e.getFecha_fin(), e.getLugar(), e.getDescripcion(), e.getFecha_E(), e.getCiclo_(), e.getAct_Deportiva_ID_Deporte());
        return new ModelAndView("redirect:/index.htm");
    }
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
  }

