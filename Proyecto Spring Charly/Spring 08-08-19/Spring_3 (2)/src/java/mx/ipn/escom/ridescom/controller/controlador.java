package mx.ipn.escom.ridescom.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.stereotype.Controller;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Alumno;
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
    
    @RequestMapping(value = "principalJFD.htm", method = RequestMethod.GET)
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
        mav1.setViewName("principalJFD");
        return mav1;
    }
    
    @RequestMapping(value = "principalcoord.htm", method = RequestMethod.GET)
    public ModelAndView Listarcoord(){
        mav1.setViewName("principalcoord");
        return mav1;
    }
    
    @RequestMapping(value = "principalalum.htm", method = RequestMethod.GET)
    public ModelAndView Listaralum(){
        mav1.setViewName("principalalum");
        return mav1;
    }
    
    @RequestMapping(value="consulta_inscripcion.htm", method = RequestMethod.GET)
    public ModelAndView ins(){
        String saql = "select ae.ALUMNO_ID_ALUMNO, ae.EVENTO_EVENTO_ID "
                    + "from ALUMNO_HAS_EVENTO"
                    + "WHERE ALUMNO_ID_ALUMNO = #alumno"
                    + "alumno", alumnoId;
        mav1.setViewName("consulta_inscripcion");
        return mav1;
    }
    
    @RequestMapping(value="difundirevento.htm", method = RequestMethod.GET)
    public ModelAndView difun(){
        String saql = " select e.Nombre_Evento, e.Fecha_inicio_Registro, e.Fecha_fin_Registro, e.Lugar_del_evento, e.Descripcion, e.Fecha_Evento, e.Ciclo_ID_Ciclo, e.Act_Deportiva_ID_Deporte\n" +
"	from Evento e; ";
        mav1.setViewName("difundirevento");
        return mav1;
    }
    
    @RequestMapping(value="Valida.htm", method = RequestMethod.GET)
    public ModelAndView valida(){
        String saql = " select e.Nombre_Evento, e.Fecha_inicio_Registro, e.Fecha_fin_Registro, e.Lugar_del_evento, e.Descripcion, e.Fecha_Evento, e.Ciclo_ID_Ciclo, e.Act_Deportiva_ID_Deporte\n" +
"	from Evento e; ";
        mav1.setViewName("Valida");
        return mav1;
    }
    
    @RequestMapping(value="Usuario.htm", method = RequestMethod.GET)
    public ModelAndView usuario(){
        String saql = " select e.Nombre_Evento, e.Fecha_inicio_Registro, e.Fecha_fin_Registro, e.Lugar_del_evento, e.Descripcion, e.Fecha_Evento, e.Ciclo_ID_Ciclo, e.Act_Deportiva_ID_Deporte\n" +
"	from Evento e; ";
        mav1.setViewName("Usuario");
        return mav1;
    }
    
  }

