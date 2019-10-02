/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import mx.ipn.escom.ridescom.config.ConectaCedula;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
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
    
    @RequestMapping(value="Coordinador/AlumnosInscritos", method=RequestMethod.GET)
    public ModelAndView coord(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
//            if(us.getRol()==1){
//                mav.setViewName("Error404");
//            }else if(us.getRol()==2){
            String sql="select ae.Alumno_ID_Alumno as ID_Alumno, p.Nombre as Nombre, p.Ap_Pat as Ap_Pat, p.Ap_Mat as Ap_Mat, ae.Evento_Evento_ID as No_Evento, e.Nombre_Evento as Nombre_Evento, ae.Escuela_ID_Escuela as Escuela_ID, es.Escuela as Escuela" +
"	from Inscripcion ae, Alumno a, Persona p, Evento e, Escuela es" +
"		WHERE ae.Alumno_ID_Alumno = a.ID_Alumno" +
"        AND a.Persona_ID_Persona = p.ID_Persona" +
"        AND ae.Evento_Evento_ID = e.Evento_ID" +
"        AND ae.Escuela_ID_Escuela = es.ID_Escuela";
                mav.setViewName("AlumnosInscritos");
//            }else {
//                mav.setViewName("Error404");
//            }
            
        }else {
        mav.setViewName("Login");
        }
        return mav;
    }
    @RequestMapping(value="Coordinador/AlumnosInscritos", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        CedulaInscripcion ci=new CedulaInscripcion();
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String val=req.getParameter("iddeporte");
        try {
            ConectaCedula con = new ConectaCedula();
            java.sql.Connection conn = con.getConexion();
            
            JasperReport reporte = null;
            String path = "src\\java\\mx\\ipn\\escom\\ridescom\\cedula\\CedulaInscripcion.jasper";
            
            Map parametro = new HashMap();
            parametro.put("ACT_ID", val); //Reemplazar el 4 por el valor del input
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
        } catch (Exception e) {
            Logger.getLogger(CedulaInscripcion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        }else{
            return new ModelAndView("reditect:Coordinador/AlumnosInscritos");
        }
    return new ModelAndView("reditect:Coordinador/AlumnosInscritos");
    }
}
