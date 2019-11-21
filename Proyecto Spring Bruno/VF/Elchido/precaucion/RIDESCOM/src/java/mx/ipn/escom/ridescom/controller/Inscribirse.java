/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.model.Inscribir;
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
public class Inscribirse {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    Connect cn =new Connect();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    Connection ct;
    PreparedStatement psre;
    PreparedStatement ps;
    ResultSet rsre;
    ResultSet rs;
    
    String cu;
    String de;
    
    int Ev;
    List p;
    List dat;
    List dat1;
    List dat2;
    List dat3;
    
    @RequestMapping(value="Alumno/Inscripciones.html", method=RequestMethod.GET)
    public ModelAndView insc(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
            String sqli="select i.Evento_Evento_ID, concat(p.Nombre,' ',p.Ap_Pat,' ',p.Ap_Mat) as Nombre, a.ID_Alumno, ev.Nombre_Evento, d.ID_Deporte, d.Disciplina, ci.Ciclo_Escolar from persona p \n" +
"        INNER JOIN (alumno a, inscripcion i, Escuela es, evento ev, act_deportiva d, pruebas pr, ciclo ci) \n" +
"        on (a.Persona_ID_Persona=p.ID_Persona AND ev.Ciclo_ID_Ciclo=ci.ID_Ciclo AND ev.Pruebas_ID_Pruebas=pr.ID_Pruebas AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte AND i.Evento_Evento_ID=ev.Evento_ID AND i.Alumno_ID_Alumno=a.ID_Alumno AND i.Escuela_ID_Escuela=es.ID_Escuela)\n" +
"where a.ID_Alumno='"+session.getAttribute("Nombre_U")+"'";
        dat2=this.rid.queryForList(sqli);
        mav.addObject("resu",dat2);
            mav.setViewName("ConsultaInscritos");
        }else {
        mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    
    
    @RequestMapping(value="Alumno/Inscribirse.html", method=RequestMethod.GET)
    public ModelAndView alumn(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
                mav.setViewName("Inscribirse");
        }else {
        mav.setViewName("LoginAlumno");
        }
        String sc="select edo.Estado \n" +
"	from persona p, Alumno a, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Escuela es, Prog_Academico prog, Escuela_has_Prog_Academico ep, Estados edo, Municipio m\n" +
"		where  edo.Homo=(select left(right(P.CURP,7),2))\n" +
"        	   AND r.ID_Roles='3' \n" +
"               AND edo.ID_estado=m.Estados_ID_estado\n" +
"			   AND p.Municipio_ID_Municipio=m.ID_Municipio\n" +
"			   AND p.Municipio_Estados_ID_estado=m.Estados_ID_estado\n" +
"               AND p.ID_Persona = u.Persona_ID_Persona\n" +
"               AND p.ID_Persona = a.Persona_ID_Persona\n" +
"               AND u.Roles_ID_Roles = r.ID_Roles\n" +
"               AND p.ID_Persona = c.Persona_ID_Persona\n" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo\n" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto\n" +
"			   AND c.ID_Contacto = tf.Contacto_ID_Contacto\n" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto\n" +
"               AND es.ID_Escuela=ep.Escuela_ID_Escuela\n" +
"               AND prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico\n" +
"               AND u.Nombre_U='"+session.getAttribute("Nombre_U")+"'";
         try{
            ct=cn.Connect();
            psre=ct.prepareStatement(sc);
            rsre=psre.executeQuery();
            if(rsre!=null ){
                while(rsre.next()){
                cu =rsre.getString("Estado");
                }
            }
        }catch(Exception e){
        }
        mav.addObject("lugar", cu);
        //Info del Usuario principal
        String sqlp="select a.ID_Alumno, u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular, es.Escuela, prog.Programa" +
"	from persona p, Alumno a, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Escuela es, Prog_Academico prog, Escuela_has_Prog_Academico ep" +
"		where r.ID_Roles='3' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND p.ID_Persona = a.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto"+
"               AND es.ID_Escuela=ep.Escuela_ID_Escuela"+
"               AND prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico"+
"               AND Nombre_U='"+session.getAttribute("Nombre_U")+"'";
        p=this.rid.queryForList(sqlp);
        if(p!=null)
            mav.addObject("alum",p);
                    //Consulta de Eventos registrados en la Base de Datos
            String sql1="SELECT * from (select Evento_ID, Nombre_Evento, Descripcion, DATE_FORMAT(Fecha_Inicio_Registro,'%d-%m-%Y') AS FIR, DATE_FORMAT(Fecha_Fin_Registro,'%d-%m-%Y') AS FFR, DATE_FORMAT(Fecha_Evento, '%d-%m-%Y') AS FE, Ciclo_Escolar, Disciplina, Nombre_S, Municipio, Estado, Prueba, Rama \n" +
                        "from Evento e " +
                    "inner join (Ciclo ci, Pruebas pr, Act_Deportiva d, Sede s, Municipio m, Estados edo, Tipo_Pruebas tp) " +
"                    on (e.Ciclo_ID_Ciclo=ci.ID_Ciclo " +
"                    AND pr.Tipo_Pruebas_ID_Tipo=tp.ID_Tipo " +
"                    AND e.Pruebas_ID_Pruebas=pr.ID_Pruebas " +
"                    AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte " +
"                    AND e.Sede_ID_Sede=s.ID_Sede " +
"                    AND s.Municipio_ID_Municipio=m.ID_Municipio " +
"                    AND s.Municipio_Estados_ID_estado=m.Estados_ID_estado " +
"                    AND m.Estados_ID_estado=edo.ID_estado) " +
"                    where Fecha_evento >= left(now(),10) order by FE ASC) as eve left join (inscripcion i) on (i.Evento_Evento_ID=eve.Evento_ID)";
            dat=this.rid.queryForList(sql1);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
            if(dat!=null)
                mav.addObject("eve",dat);
        return mav;
    }
    PreparedStatement pst;
    ResultSet rt;
    String et;
    @RequestMapping(value="Alumno/Inscribirse.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, Inscribir ir) throws Exception{
        HttpSession session = req.getSession();
        String evn="select Evento_Evento_ID from inscripcion where Evento_Evento_ID="+ir.getEvento();
         try{
            ct=cn.Connect();
            pst=ct.prepareStatement(evn);
            rt=pst.executeQuery();
            if(rt!=null ){
                while(rt.next()){
                et =rt.getString("Evento_Evento_ID");
                }
            }
        }catch(Exception e){
        }
        if(et!=null){            
            mav.setViewName("redirect:/Alumno/Inscribirse.html");
            mav.addObject("mjs", "<div style='color: red;'>Ya estás inscrito en el evento.</div>");
        }else{
            String ev=req.getParameter("Evento");
            String sqi="insert Inscripcion (Alumno_ID_Alumno, Evento_Evento_ID, Escuela_ID_Escuela) values('"+session.getAttribute("Nombre_U")+"',"+ev+",7)";
            this.rid.update(sqi);
            mav.setViewName("redirect:/Alumno/Inscripciones.html");
            
        }
        return mav;
    }
    
//Checar
    @RequestMapping(value="Alumno/Inscripciones/BorrarInscripcion.html", method=RequestMethod.GET)
    public ModelAndView inscr(HttpServletRequest re){
        HttpSession session = re.getSession();
        Ev=Integer.parseInt("Ev");
        if(session.getAttribute("Nombre_U")!= null){
            String sqled="select a.ID_Alumno, u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular, es.Escuela, prog.Programa" +
"	from persona p, Alumno a, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Escuela es, Prog_Academico prog, Escuela_has_Prog_Academico ep" +
"		where r.ID_Roles='3' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND p.ID_Persona = a.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto"+
"               AND es.ID_Escuela=ep.Escuela_ID_Escuela"+
"               AND prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico"+
"               AND Nombre_U='"+session.getAttribute("Nombre_U")+"'";
        dat3=this.rid.queryForList(sqled);
        mav.addObject("resu",dat3);
        String sc="select edo.Estado \n" +
"	from persona p, Alumno a, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Escuela es, Prog_Academico prog, Escuela_has_Prog_Academico ep, Estados edo, Municipio m\n" +
"		where  edo.Homo=(select left(right(P.CURP,7),2))\n" +
"        	   AND r.ID_Roles='3' \n" +
"               AND edo.ID_estado=m.Estados_ID_estado\n" +
"			   AND p.Municipio_ID_Municipio=m.ID_Municipio\n" +
"			   AND p.Municipio_Estados_ID_estado=m.Estados_ID_estado\n" +
"               AND p.ID_Persona = u.Persona_ID_Persona\n" +
"               AND p.ID_Persona = a.Persona_ID_Persona\n" +
"               AND u.Roles_ID_Roles = r.ID_Roles\n" +
"               AND p.ID_Persona = c.Persona_ID_Persona\n" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo\n" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto\n" +
"			   AND c.ID_Contacto = tf.Contacto_ID_Contacto\n" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto\n" +
"               AND es.ID_Escuela=ep.Escuela_ID_Escuela\n" +
"               AND prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico\n" +
"               AND u.Nombre_U='"+session.getAttribute("Nombre_U")+"'";
         try{
            ct=cn.Connect();
            psre=ct.prepareStatement(sc);
            rsre=psre.executeQuery();
            if(rsre!=null ){
                while(rsre.next()){
                cu =rsre.getString("Estado");
                }
            }
        }catch(Exception e){
        }
        mav.addObject("lugar", cu);
        //Info del Usuario principal
        String sqlp="select a.ID_Alumno, u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular, es.Escuela, prog.Programa" +
"	from persona p, Alumno a, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Escuela es, Prog_Academico prog, Escuela_has_Prog_Academico ep" +
"		where r.ID_Roles='3' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND p.ID_Persona = a.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto"+
"               AND es.ID_Escuela=ep.Escuela_ID_Escuela"+
"               AND prog.ID_Prog_Academico=ep.Prog_Academico_ID_Prog_Academico"+
"               AND Nombre_U='"+session.getAttribute("Nombre_U")+"'";
        p=this.rid.queryForList(sqlp);
        if(p!=null)
            mav.addObject("alum",p);
                //Consulta de Eventos registrados en la Base de Datos
            String sld="select i.Evento_Evento_ID, concat(p.Nombre,' ',p.Ap_Pat,' ',p.Ap_Mat) as Nombre, a.ID_Alumno, ev.Nombre_Evento, d.ID_Deporte, d.Disciplina, ci.Ciclo_Escolar from persona p \n" +
"        INNER JOIN (alumno a, inscripcion i, Escuela es, evento ev, act_deportiva d, pruebas pr, ciclo ci) \n" +
"        on (a.Persona_ID_Persona=p.ID_Persona AND ev.Ciclo_ID_Ciclo=ci.ID_Ciclo AND ev.Pruebas_ID_Pruebas=pr.ID_Pruebas AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte AND i.Evento_Evento_ID=ev.Evento_ID AND i.Alumno_ID_Alumno=a.ID_Alumno AND i.Escuela_ID_Escuela=es.ID_Escuela)\n" +
"where a.ID_Alumno='"+session.getAttribute("Nombre_U")+"' and i.Evento_Evento_ID="+Ev;
            try{
            ct=cn.Connect();
            ps=ct.prepareStatement(sld);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next()){
                de =rs.getString("Disciplina");
                }
            }
            }   catch(Exception e){
            }
            mav.addObject("deporte",de);
            mav.setViewName("BorrarInscripcion");
        }else {
        mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    @RequestMapping(value="Alumno/Inscripciones/BorrarInscripcion.html", method=RequestMethod.POST)
    public ModelAndView inscB(HttpServletRequest re){
        HttpSession session = re.getSession();
        Ev=Integer.parseInt("Ev");
        String sqld="delete from Inscripcion where a.ID_Alumno='"+session.getAttribute("Nombre_U")+"' and Evento_Evento_ID="+Ev;
        this.rid.update(sqld);
        
        mav.setViewName("redirect:/Alumno/Inscripciones.html");
        mav.addObject("mjs", "<div style='color: green;'>Tu inscripción se realizó correctamente.</div>");
        return mav;
    }
}
