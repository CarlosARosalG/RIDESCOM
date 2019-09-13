/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class CoordUA {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
    List p;
    List dat;
    List dat1;
    List dat2;
    
    //Cerrar sesion del usuario DDyFD
    @RequestMapping(value="/Logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/Login";
    }
    
    @RequestMapping(value="Coordinador", method=RequestMethod.GET)
    public ModelAndView Ddyfd(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("DDyFD");
        }else{
            mav.setViewName("CoordUA");
        }
        //Info del Usuario Coordinador
        String sqlp="select u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular" +
"	from persona p, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r" +
"		where r.ID_Roles='2' " +
"               AND p.Usuario_Usuario_ID = u.Usuario_ID" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto";
        p=this.rid.queryForList(sqlp);
        if(p!=null)
            mav.addObject("e",p);
                    //Consulta de Eventos registrados en la Base de Datos
            String sql1="select Evento_ID, Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_evento, Direccion, P_referencia, Descripcion, Fecha_evento, Ciclo.Ciclo_Escolar, Act_Deportiva.Disciplina from Evento "
            + "inner join (Ciclo, Act_Deportiva) on (Evento.Ciclo_ID_Ciclo=Ciclo.ID_Ciclo AND Evento.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte) where Fecha_evento > left(now(),10) order by Fecha_evento ASC";
            dat=this.rid.queryForList(sql1);
            
            if(dat!=null)
                mav.addObject("eve",dat);
            
                    //Consulta de Entrenadpres
            String sql="SELECT p.ID_Persona, concat(p.Nombre, ' ', p.Ap_Pat, ' ', p.Ap_Mat) as Nombre, em.Correo, e.Act_Deportiva_ID_Deporte, d.Disciplina, tf.telefono, tc.Celular"+
"	from Persona p, persona_has_act_deportiva e, act_deportiva d, Contacto c, Email em, Telefono_fijo tf, Telefono_celular tc"+
"		WHERE p.Usuario_Usuario_ID is null"+
"            AND p.ID_Persona = e.Persona_ID_Persona"+
"            AND e.Act_Deportiva_ID_Deporte = d.ID_Deporte"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto;";
            dat2=this.rid.queryForList(sql);
            if(dat2!=null)
                mav.addObject("ent", dat2);
            
                    //Consulta de Resultados registrados en la Base de Datos
            String sql2="select concat(p.Nombre,'',p.Ap_Pat,'',p.Ap_Mat) as Nombre, es.Escuela as Escuela, ad.Disciplina as Deporte, pr.Prueba as Prueba, r.Lugar_Obtenido as Lugar, r.Marca as Marca, e.Nombre_Evento as Evento "
                    + "from Resultados r, Inscripcion ae, Alumno a, Persona p, Evento e, Escuela es, Escuela_Act_Deportiva ead, Act_Deportiva ad, Pruebas pr "
                    + "WHERE r.Inscripcion_Alumno_ID_Alumno = ae.Alumno_ID_Alumno "
                    + "AND ae.Alumno_ID_Alumno = a.ID_Alumno "
                    + "AND a.Persona_ID_Persona = p.ID_Persona "
                    + "AND ae.Evento_Evento_ID = e.Evento_ID "
                    + "AND ae.Escuela_ID_Escuela = es.ID_Escuela "
                    + "AND es.ID_Escuela = ead.Escuela_ID_Escuela "
                    + "AND ead.Act_Deportiva_ID_Deporte = ad.ID_Deporte "
                    + "AND ad.ID_Deporte = pr.Act_Deportiva_ID_Deporte ";
            
            dat1=this.rid.queryForList(sql2);
            if(dat1!=null)
            mav.addObject("res",dat1);
        return mav;
    }
    @RequestMapping(value="Coordinador", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("Nombre_U");
        String pass=req.getParameter("Password_U");
        String jefe= "DDyFD";
        
        us=udao.validar(usuario, pass);
//        if(req.getParameter("btn")!= null){
        if(us.getNombre_U()!= null){
            if(us.getNombre_U().equals(jefe)){
            
            HttpSession session=req.getSession();
            session.setAttribute("Nombre_U", jefe); //user
            
            return new ModelAndView("redirect:/DDyFD");
            }else {
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Coordinador");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login");
        }
    }
}