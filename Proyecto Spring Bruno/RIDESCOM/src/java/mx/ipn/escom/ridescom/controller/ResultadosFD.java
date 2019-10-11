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
public class ResultadosFD {
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
    
    @RequestMapping(value="DDyFD/Resultados.html", method=RequestMethod.GET)
    public ModelAndView Res(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        if(session.getAttribute("Nombre_U")!= null){
//            if(us.getRol()==1){
                        //Consulta de Resultados registrados en la Base de Datos
            String sql2="SELECT i.Alumno_ID_Alumno, p.Nombre, e.Escuela, ad.Disciplina, pr.Prueba, r.Lugar_Obtenido, r.Marca, ev.Nombre_Evento " +
"	FROM Resultados r, Inscripcion i, Escuela e, Evento ev, Pruebas pr, Act_Deportiva ad, Persona p, Alumno a " +
"     WHERE r.Inscripcion_Alumno_ID_Alumno = i.Alumno_ID_Alumno " +
"     	AND i.Alumno_ID_Alumno= a.ID_Alumno " +
"        AND p.ID_Persona = a.Persona_ID_Persona " +
"     	AND	i.Escuela_ID_Escuela = e.ID_Escuela " +
"        AND i.Evento_Evento_ID = ev.Evento_ID " +
"        AND ev.Pruebas_ID_Pruebas = pr.ID_Pruebas " +
"        AND pr.Act_Deportiva_ID_Deporte = ad.ID_Deporte;";
            
            dat=this.rid.queryForList(sql2);
            if(dat!=null)
            mav.addObject("res",dat);
                mav.setViewName("ResultadosFD");
//            }else if(us.getRol()==2){
//                mav.setViewName("CoordUA");
//            }else if(us.getRol()==3){
//                mav.setViewName("Alumno");
//            }
//            return mav;
//        }else{
//            mav.setViewName("Login");
//        }
        return mav;
    }
}
