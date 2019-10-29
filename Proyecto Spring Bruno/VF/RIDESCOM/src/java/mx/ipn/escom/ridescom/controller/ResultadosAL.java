/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class ResultadosAL {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    int ResulID;
    
    ResultSet rs=null;
    PreparedStatement ps;
    
    List dat;
    List dat2;
    List es;
    List ust;
    String p;
    String a;
    String co;
    
    @RequestMapping(value="Alumno/Resultados.html", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")!= null){
                mav.setViewName("Inscribirse");
        }else {
        mav.setViewName("LoginAlumno");
        }
        String sql="select i.Alumno_ID_Alumno, p.Nombre, e.Escuela, ad.Disciplina, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento \n" +
"	FROM Resultados r\n" +
"    inner join (Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a )\n" +
"    on (p.ID_Persona=a.Persona_ID_Persona\n" +
"       and pr.Act_Deportiva_ID_Deporte=ad.ID_Deporte\n" +
"       and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas\n" +
"       and a.ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and ev.Evento_ID=i.Evento_Evento_ID\n" +
"       and e.ID_Escuela=i.Escuela_ID_Escuela\n" +
"       and r.Inscripcion_Alumno_ID_Alumno=i.Alumno_ID_Alumno\n" +
"       and r.Inscripcion_Evento_Evento_ID=i.Evento_Evento_ID)"
                + "where a.ID_Alumno="+session.getAttribute("Nombre_U");
            
            dat=this.rid.queryForList(sql);
            if(dat!=null)
            mav.addObject("res",dat);
        mav.setViewName("ResultadosAlumno");
        return mav;
    }
}
