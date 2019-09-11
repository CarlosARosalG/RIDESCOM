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
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class DDyFD {
    ModelAndView mav=new ModelAndView();
    Conexion con=new Conexion();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
    List dat;
    List dat1;
    
    //Cerrar sesion del usuario DDyFD
    @RequestMapping(value="/Logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/Login";
    }
    
    @RequestMapping(value="DDyFD", method=RequestMethod.GET)
    public ModelAndView Ddyfd(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
//        mav.addObject(new Eventos());
//        mav.addObject(new Usuario());
//        mav.addObject(new Pruebas());
        mav.setViewName("DDyFD");
        }else{
            mav.setViewName("CoordUA");
        }           //Consulta de Eventos registrados en la Base de Datos
            String sql1="select Evento_ID, Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_evento, Direccion, P_referencia, Descripcion, Fecha_evento, Ciclo.Ciclo_Escolar, Act_Deportiva.Disciplina from Evento "
            + "inner join (Ciclo, Act_Deportiva) on (Evento.Ciclo_ID_Ciclo=Ciclo.ID_Ciclo AND Evento.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte)";
            dat=this.rid.queryForList(sql1);
            mav.addObject("eve",dat);
                    //Consulta de Uusarios de Coordinadores de UA
            //String sql="";
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
            mav.addObject("res",dat1);
        return mav;
    }
    @RequestMapping(value="DDyFD", method=RequestMethod.POST)
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
