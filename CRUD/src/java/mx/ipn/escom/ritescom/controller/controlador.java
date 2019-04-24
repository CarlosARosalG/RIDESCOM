package mx.ipn.escom.ritescom.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import mx.ipn.escom.ritescom.bs.PruebaBs;
import org.springframework.stereotype.Controller;
import mx.ipn.escom.ritescom.config.Conexion;
import mx.ipn.escom.ritescom.entidad.Alumno;
import java.util.List;
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
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.ConectarSAES());
    ModelAndView mav1=new ModelAndView();
    String cadena;
    @Autowired
    private PruebaBs pruebaBs;
    
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql="select Numero_Boleta, CURP, Nombre,Apellido_Pat, Apellido_Mat, Escuela,Promedio, Turno, Fecha_Nac, Semestre_Min, Semestre_Max, Semestre_Inscrito, Calle, Colonia, Estado, CP, Carrera, Especialidad, Plan_Estud, E_mail, Tipo_Alumno, Inscrito, Sexo, Tot_Creditos, Modo_Ingreso, Periodo_Escolar_Ingreso, Egresado, Cumple_Carga_Minima, Origen, Usuario_ID, Observaciones, Reprobadas from Estudiante where Inscrito=1";
        List datos=this.jdbcTemplate.queryForList(sql);
        mav1.addObject("lista",datos);
        mav1.setViewName("index");
        cadena = pruebaBs.pruba(pruebaBs); //se pasan las cadenas de entrada USUARIO, PASSWORD Y CAPTCHA.
        mav1.addObject("cadena", cadena);
        return mav1;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav1.addObject(new Alumno());
        mav1.setViewName("agregar");
        return mav1;
    }
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Alumno a){
        
        String sql= "insert into Estudiante (Numero_Boleta, CURP, Nombre,Apellido_Pat, Apellido_Mat, Escuela,Promedio, Turno, Fecha_Nac, Semestre_Min, Semestre_Max, Semestre_Inscrito, Calle, Colonia, Estado, CP, Carrera, Especialidad, Plan_Estud, E_mail, Tipo_Alumno, Inscrito, Sexo, Tot_Creditos, Modo_Ingreso, Periodo_Escolar_Ingreso, Egresado, Cumple_Carga_Minima, Origen, Usuario_ID, Observaciones, Reprobadas)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getNumero_Boleta(), a.getCURP(), a.getNombre(), a.getApellido_Pat(), a.getApellido_Mat(), a.getEscuela(), a.getPromedio(), a.getTurno(), a.getFecha_Nac(), a.getSemestre_Min(), a.getSemestre_Max(), a.getSemestre_Inscrito(), a.getCalle(), a.getColonia(), a.getEstado(), a.getCP(), a.getCarrera(),a.getEspecialidad(), a.getPlan_Estud(), a.getE_mail(), a.getTipo_Alumno(), a.getInscrito(), a.getSexo(), a.getTot_Creditos(), a.getModo_Ingreso(), a.getPeriodo_Escolar_Ingreso(), a.getEgresado(), a.getCumple_Carga_Minima(), a.getOrigen(), a.getUsuario_ID(), a.getObservaciones(), a.getReprobadas());
        return new ModelAndView("redirect: /index.htm");
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
  }

