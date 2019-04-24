package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.stereotype.Controller;
import Config.Conexion;
import Entidad.Alumno;
import java.util.List;
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
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarSAES());
    ModelAndView mav1=new ModelAndView();
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql="select Numero_Boleta, Nombre,concat(Apellido_Pat, ' ' ,Apellido_Mat) as Apellidos, Sexo, CURP,  DATE_FORMAT(Fecha_Nac, \"%d/%m/%Y\")as Fecha_Nac, Escuela, if(Carrera='I','Ingenieria','Otra') as Carrera from Estudiante where Inscrito=1";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav1.addObject("lista",datos);
        mav1.setViewName("index");
        return mav1;
    }
  }

