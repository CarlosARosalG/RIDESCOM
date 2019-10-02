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

/**
 *
 * @author spy51
 */
public class Alumno {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
    List p;
    List dat;
    List dat1;
    List dat2;
    
    @RequestMapping(value="InfoAlumno", method=RequestMethod.GET)
    public ModelAndView Ialu(HttpServletRequest re){   
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
            if(us.getRol()==1){
                mav.setViewName("DDyFD");
            }else if(us.getRol()==2){
                mav.setViewName("CoordUA");
            }else {
                mav.setViewName("InfoAlumno");
            }
            
        }else {
        mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    
    @RequestMapping(value="Alumno", method=RequestMethod.GET)
    public ModelAndView Ddyfd(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")!= null){
//            if(us.getRol()==1){
//                mav.setViewName("DDyFD");
//            }else if(us.getRol()==2){
//                mav.setViewName("CoordUA");
//            }else {
                //Info del Usuario principal
        String sqlp="select u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular" +
"	from persona p, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r" +
"		where r.ID_Roles='3' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto" ;
        p=this.rid.queryForList(sqlp);
        if(p!=null)
            mav.addObject("alum",p);
                //Consulta de Eventos registrados en la Base de Datos
            String sql1="select Evento_ID, Nombre_Evento, Descripcion, DATE_FORMAT(Fecha_Inicio_Registro,'%d-%m-%Y') AS FIR, DATE_FORMAT(Fecha_Fin_Registro,'%d-%m-%Y') AS FFR,\n"
                    + " DATE_FORMAT(Fecha_Evento, '%d-%m-%Y') AS FE, Ciclo_Escolar, Disciplina, Nombre_S, Municipio, Estado \n"
                    + "					from Evento e\n"
                    + "                    inner join (Ciclo ci, Act_Deportiva d, Sede s, Municipio m, Estados edo, Pruebas p) \n"
                    + "                    on (e.Ciclo_ID_Ciclo=ci.ID_Ciclo \n"
                    + "                    AND e.Pruebas_ID_Pruebas = p.ID_Pruebas\n"
                    + "                    AND p.act_deportiva_ID_Deporte = d.ID_Deporte\n"
                    + "                    AND e.Sede_ID_Sede=s.ID_Sede \n"
                    + "                    AND s.Municipio_ID_Municipio=m.ID_Municipio \n"
                    + "                    AND s.Municipio_Estados_ID_estado=m.Estados_ID_estado \n"
                    + "                    AND m.Estados_ID_estado=edo.ID_estado) \n"
                    + "                    AND e.Fecha_Evento>left(now(),10) order by Fecha_evento ASC;";
            dat = this.rid.queryForList(sql1);
            //Aqui el sql solo muestra los eventos que no hayan pasado 
            if(dat!=null)
                mav.addObject("eve",dat);
                mav.setViewName("Alumno");
            
            
        }else {
        mav.setViewName("LoginAlumno");
        }
        return mav;
    }
    @RequestMapping(value="Alumno", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("Nombre_U");
        String pass=req.getParameter("Password_U");
        //String jefe= "DDyFD";
        
        us=udao.validar(usuario, pass);
        if(us.getNombre_U()!= null){
            if(us.getRol()==1){
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/DDyFD");
            }else if(us.getRol()==2) {
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Coordinador");
            }else{
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Alumno");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login");
        }
    }
}
