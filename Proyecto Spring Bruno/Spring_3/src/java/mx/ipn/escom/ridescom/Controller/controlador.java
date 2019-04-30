package mx.ipn.escom.ridescom.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.stereotype.Controller;
import mx.ipn.escom.ridescom.Config.Conexion;
import mx.ipn.escom.ridescom.Entidad.Alumno;
import java.util.List;
import org.jsoup.Connection;
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
    //JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarSAES());
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarApp());
    ModelAndView mav1=new ModelAndView();
    
    @RequestMapping(value = "principal.htm", method = RequestMethod.GET)
    public ModelAndView Listar(){
        /*String sql="select Nombre_Evento, Act_Deportiva_ID_Deporte, Fecha_Evento, Lugar_del_evento, Descripcion from evento";
        String sql1 = "select concat(Nombre, ' ', Ap_Pat, ' ', Ap_Mat) as NC,  from persona";
        String sql2 = "select Escuela from escuela";
        String sql3 = "select Disciplina from act_deportiva";
        String sql4 = "select Prueba from pruebas";
        String sql5 = "select Lugar_Obtenido, Marca from resultados";
        
        List datos=this.jdbcTemplate.queryForList(sql);
        List datos1=this.jdbcTemplate.queryForList(sql1);
        List datos2=this.jdbcTemplate.queryForList(sql2);
        List datos3=this.jdbcTemplate.queryForList(sql3);
        List datos4=this.jdbcTemplate.queryForList(sql4);
        List datos5=this.jdbcTemplate.queryForList(sql5);
        mav1.addObject("Evento",datos);
        mav1.addObject("Persona",datos1);
        mav1.addObject("Escuela",datos2);
        mav1.addObject("Deporte",datos3);
        mav1.addObject("Prueba",datos4);
        mav1.addObject("Resultado",datos5);*/
        mav1.setViewName("principal");
        return mav1;
    }
    
    @RequestMapping(value="consulta_inscripcion.htm", method = RequestMethod.GET)
    public ModelAndView ins(){
        String saql = "select ";
        mav1.setViewName("consulta_inscripcion");
        return mav1;
    }
  }

