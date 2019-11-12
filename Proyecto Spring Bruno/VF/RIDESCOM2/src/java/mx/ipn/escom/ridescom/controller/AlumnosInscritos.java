/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.io.*;
import java.util.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.ipn.escom.ridescom.config.ConectaCedula;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Ced;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author spy51
 */
public class AlumnosInscritos {
  ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
    List p;
    List dat;
    List dat1;
    List dat2;
    
    @RequestMapping(value="Coordinador/AlumnosInscritos.html", method=RequestMethod.GET)
    public ModelAndView Alumno(){   
        String sqli="select concat(p.Nombre,' ',p.Ap_Pat,' ',p.Ap_Mat) as Nombre, a.ID_Alumno, ev.Nombre_Evento, d.ID_Deporte, d.Disciplina, ci.Ciclo_Escolar from persona p " +
"INNER JOIN (alumno a, inscripcion i, Escuela es, evento ev, act_deportiva d, pruebas pr, ciclo ci) "
                + "on (a.Persona_ID_Persona=p.ID_Persona AND ev.Ciclo_ID_Ciclo=ci.ID_Ciclo AND ev.Pruebas_ID_Pruebas=pr.ID_Pruebas AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte AND i.Evento_Evento_ID=ev.Evento_ID AND i.Alumno_ID_Alumno=a.ID_Alumno AND i.Escuela_ID_Escuela=es.ID_Escuela)";
        dat=this.rid.queryForList(sqli);
        mav.addObject("ins",dat);
        mav.setViewName("AlumnosInscritos");
        return mav;
    }
    @RequestMapping(value="Coordinador/AlumnosInscritos.html", method=RequestMethod.POST)
    public ModelAndView Alu(HttpServletRequest request, HttpServletResponse response,Ced cd) throws JRException, IOException{   
        ConectaCedula cc=new ConectaCedula();
            //File reportfile =new File(application.getRealPath("WEB-INF/jsp/Cedula.jasper"));
            Map<String, Object> parameter = new HashMap<>();
//            Map<String, Object> parameter1 = new HashMap<>();
            String path = "Cedula.jasper";
            
//            String dat=request.getParameter("iddeporte");
            parameter.put("Deporte",cd.getIddeporte());
            parameter.put("Ciclo",cd.getCiclo());
            JasperReport reportfile = (JasperReport) JRLoader.loadObjectFromFile(path);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile, parameter, cc.getConexion());
//            byte[] bytes1 = JasperRunManager.runReportToPdf(reportfile, parameter1, cc.getConexion());
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
//            response.setContentLength(bytes1.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);
//            outputstream.write(bytes1, 0, bytes1.length);
            
            outputstream.flush();
            outputstream.close();
       
        return new ModelAndView("redirect:/Coordinador/AlumnosInscritos.html");
    }
//    @RequestMapping(value="Coordinador/Cedula", method=RequestMethod.GET)
//    public ModelAndView cedul(){   
//        mav.setViewName("pdf");
//        return mav;
//    }
}
