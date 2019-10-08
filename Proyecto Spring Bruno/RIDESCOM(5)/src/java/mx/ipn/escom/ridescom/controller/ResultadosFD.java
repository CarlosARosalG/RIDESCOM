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
    
    @RequestMapping(value="DDyFD/Resultados", method=RequestMethod.GET)
    public ModelAndView Res(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        if(session.getAttribute("Nombre_U")!= null){
//            if(us.getRol()==1){
                        //Consulta de Resultados registrados en la Base de Datos
            String sql2="select a.ID_Alumno, concat(p.Nombre,' ',p.Ap_Pat,' ',p.Ap_Mat) as Nombre, es.Escuela as Escuela, ad.Disciplina as Deporte, pr.Prueba as Prueba, r.Lugar_Obtenido as Lugar, r.Marca as Marca, e.Nombre_Evento as Evento "
                    + "from Resultados r, Inscripcion ae, Alumno a, Persona p, Evento e, Escuela es, Escuela_Act_Deportiva ead, Act_Deportiva ad, Pruebas pr "
                    + "WHERE r.Inscripcion_Alumno_ID_Alumno = ae.Alumno_ID_Alumno "
                    + "AND ae.Alumno_ID_Alumno = a.ID_Alumno "
                    + "AND a.Persona_ID_Persona = p.ID_Persona "
                    + "AND ae.Evento_Evento_ID = e.Evento_ID "
                    + "AND ae.Escuela_ID_Escuela = es.ID_Escuela "
                    + "AND es.ID_Escuela = ead.Escuela_ID_Escuela "
                    + "AND ead.Act_Deportiva_ID_Deporte = ad.ID_Deporte "
                    + "AND ad.ID_Deporte = pr.Act_Deportiva_ID_Deporte ";
            
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
