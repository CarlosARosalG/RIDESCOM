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
import mx.ipn.escom.ridescom.config.Connect;
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
     
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    java.sql.Connection cs;
    ResultSet rsc;
    PreparedStatement psc;
    int s;
    String sr;
    
    List p;
    List dat;
    
    
    @RequestMapping(value="Alumno.html", method=RequestMethod.GET)
    public ModelAndView Alumno(HttpServletRequest re){
        HttpSession session = re.getSession();
        mav.clear();
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
         mav.setViewName("redirect:/LoginAlumno.html");
        }else {
        if(ro.equals("1")){
            mav.setViewName("redirect:/DDyFD.html");
            }else if(ro.equals("2")){
            mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
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
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto"+
"               AND Nombre_U='"+session.getAttribute("Nombre_U")+"'";
        p=this.rid.queryForList(sqlp);
        String se="select ts.ID_Tipo_Sexo from persona p inner join (tipo_sexo ts,Usuario u) on (p.ID_Persona=u.Persona_ID_Persona and ts.ID_Tipo_Sexo=p.Tipo_Sexo_ID_Tipo_Sexo) where u.Nombre_U='"+session.getAttribute("Nombre_U")+"'";
         try{
            cs=cn.Connect();
            psc=cs.prepareStatement(se);
            rsc=psc.executeQuery();
            while(rsc.next()){
                s=rsc.getInt("ID_Tipo_Sexo");
            }
        }catch(Exception e){
        }
         if(s==1){
             sr="Varonil";
         }else{
             sr="Femenil";
         }
            if(p!=null)
            mav.addObject("alu",p);
        String sql1="SELECT * from (select Evento_ID, Nombre_Evento, Descripcion, concat(Calle,', ',Numero,', ',Colonia,', ',CP,', ',Estado,', ',Municipio)as direccion, DATE_FORMAT(Fecha_Inicio_Registro,'%d-%m-%Y') AS FIR, DATE_FORMAT(Fecha_Fin_Registro,'%d-%m-%Y') AS FFR, DATE_FORMAT(Fecha_Evento, '%d-%m-%Y') AS FE, Ciclo_Escolar, Disciplina, Nombre_S, Municipio, Estado, Prueba, Rama \n" +
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
"                    where Fecha_Fin_Registro >= left(now(),10)"
                + " and Rama='"+sr+"' order by FE ASC) as eve left join (inscripcion i) on (i.Evento_Evento_ID=eve.Evento_ID) order by Disciplina";
            dat=this.rid.queryForList(sql1);
            
            if(dat!=null)
                mav.addObject("eve",dat);
                mav.setViewName("Alumno");    
            }
        }
        return mav;
    }
}
