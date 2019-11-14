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

    Connect cn=new Connect();
    Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    List p;
    List dat;
    List dat1;
    List dat2;
    
    //Cerrar sesion del usuario DDyFD
    @RequestMapping(value="/Logout.html", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/Home.html";
    }
    
    @RequestMapping(value="DDyFD.html", method=RequestMethod.GET)
    public ModelAndView Ddyfd(HttpServletRequest re){
        HttpSession session = re.getSession();
        String ur="select Roles_ID_Roles from usuario where Nombre_U='"+session.getAttribute("Nombre_U")+"';";
         try{
            ct=cn.Connect();
            ps=ct.prepareStatement(ur);
            rs=ps.executeQuery();
            if(rs!=null ){
                while(rs.next() ){
                ro =rs.getString("Roles_ID_Roles");
                }
            }
        }catch(Exception e){
        }
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("redirect:/Login.html");
        }else{
            if(ro.equals("1")){
            //Info del Usuario principal
        String sqlp="select u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, tc.Celular" +
"	from persona p, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r" +
"		where r.ID_Roles='1' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto"+
"               AND Nombre_U='"+session.getAttribute("Nombre_U")+"'";
        p=this.rid.queryForList(sqlp);
        if(p!=null)
            mav.addObject("ddyfd",p);
                    //Consulta de Eventos registrados en la Base de Datos
//            String sql1="select Evento_ID, Nombre_Evento, Descripcion, DATE_FORMAT(Fecha_Inicio_Registro,'%d-%m-%Y') AS FIR, DATE_FORMAT(Fecha_Fin_Registro,'%d-%m-%Y') AS FFR, DATE_FORMAT(Fecha_Evento, '%d-%m-%Y') AS FE, Ciclo_Escolar, Disciplina, Nombre_S, Municipio, Estado, Prueba, Rama from Evento e "
//                    + "inner join (Ciclo ci, Pruebas pr, Act_Deportiva d, Sede s, Municipio m, Estados edo, Tipo_Pruebas tp) "
//                    + "on (e.Ciclo_ID_Ciclo=ci.ID_Ciclo "
//                    + "AND pr.Tipo_Pruebas_ID_Tipo=tp.ID_Tipo "
//                    + "AND e.Pruebas_ID_Pruebas=pr.ID_Pruebas "
//                    + "AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte "
//                    + "AND e.Sede_ID_Sede=s.ID_Sede "
//                    + "AND s.Municipio_ID_Municipio=m.ID_Municipio "
//                    + "AND s.Municipio_Estados_ID_estado=m.Estados_ID_estado "
//                    + "AND m.Estados_ID_estado=edo.ID_estado) "
//                    + "order by Fecha_evento ASC";
        String sql1="SELECT *,\n" +
"(case\n" +
"	when Evento_Evento_ID is NULL then 0\n" +
"    else 1\n" +
"    end)as algo\n" +
"from (select Evento_ID, Nombre_Evento, Fecha_Evento, Descripcion, DATE_FORMAT(Fecha_Inicio_Registro,'%d-%m-%Y') AS FIR, DATE_FORMAT(Fecha_Fin_Registro,'%d-%m-%Y') AS FFR, DATE_FORMAT(Fecha_Evento, '%d-%m-%Y') AS FE, Ciclo_Escolar, Disciplina, Nombre_S, Municipio, Estado, Prueba, Rama \n" +
"                        from Evento e\n" +
"                    inner join (Ciclo ci, Pruebas pr, Act_Deportiva d, Sede s, Municipio m, Estados edo, Tipo_Pruebas tp) \n" +
"                    on (e.Ciclo_ID_Ciclo=ci.ID_Ciclo \n" +
"                    AND pr.Tipo_Pruebas_ID_Tipo=tp.ID_Tipo \n" +
"                    AND e.Pruebas_ID_Pruebas=pr.ID_Pruebas \n" +
"                    AND pr.Act_Deportiva_ID_Deporte=d.ID_Deporte\n" +
"                    AND e.Sede_ID_Sede=s.ID_Sede \n" +
"                    AND s.Municipio_ID_Municipio=m.ID_Municipio \n" +
"                    AND s.Municipio_Estados_ID_estado=m.Estados_ID_estado \n" +
"                    AND m.Estados_ID_estado=edo.ID_estado) \n" +
"                    ) as eve left join (select distinct i.Evento_Evento_ID from inscripcion i) as ins on (ins.Evento_Evento_ID=eve.Evento_ID)order by FE DESC";
            dat=this.rid.queryForList(sql1);
            
            //Aqui el sql solo muestra los eventos que no hayan pasado 
            if(dat!=null)
                mav.addObject("eve",dat);
        mav.setViewName("DDyFD");
            }else if(ro.equals("2")){
            mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
            mav.setViewName("redirect:/Alumno.html");    
            }
        }
//                mav.setViewName("DDyFD");

        return mav;
    }
    @RequestMapping(value="DDyFD.html", method=RequestMethod.POST)
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
            
            return new ModelAndView("redirect:/DDyFD.html");
            }else {
                HttpSession session=req.getSession();
                session.setAttribute("Nombre_U", usuario); //user
                return new ModelAndView("redirect:/Coordinador.html");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login.html");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login.html");
        }
    }
}
