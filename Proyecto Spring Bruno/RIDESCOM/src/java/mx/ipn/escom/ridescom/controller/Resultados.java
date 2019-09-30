/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.model.Contacto;
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Persona;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class Resultados {
    Conexion con=new Conexion();
    Connect cn=new Connect();
    Connection ct;

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
    
    @RequestMapping(value="Coordinador/Resultados", method=RequestMethod.GET)
    public ModelAndView resul(){   
        mav.setViewName("Resultados");
        return mav;
    }
    
    @RequestMapping(value="Alumno/Resultados", method=RequestMethod.GET)
    public ModelAndView resulA(){   
        mav.setViewName("ResultadosAlumno");
        return mav;
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="Coordinador/Resultados/AgregarResultado", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Error404");
        }else{
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
            mav.addObject("al",dat);
            mav.setViewName("AgregarResultado");
        }
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/AgregarUsuario", method=RequestMethod.POST)
    public ModelAndView Agrega(Usuario u, Persona p, Eventos ev, Contacto c )throws Exception{
            
            String sql="insert into Persona (Nombre, Ap_Pat, Ap_Mat, Tipo_Sexo_ID_Tipo_Sexo, CURP, Fecha_Nac, NSS, Municipio_ID_Municipio, Municipio_Estados_ID_estado) values (?,?,?,?,?,?,?,?, (select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+"))";
            this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
            String sqlu="insert into Usuario (Nombre_U, Password_U, Activo, Fecha_inicio, Roles_ID_Roles, Persona_ID_Persona) values (?,?,1,left(now(),10),2,(select MAX(ID_Persona)from Persona))";
            this.rid.update(sqlu, u.getNombre_U(), u.getPassword_U());
            String sql1="insert into Contacto (Persona_ID_Persona) values ((select MAX(ID_Persona)from Persona))";
            this.rid.update(sql1);
            String sqltf="insert into Telefono_fijo (Telefono, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltf, c.getTel_fijo());
            String sqltc="insert into Telefono_Celular (Celular, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltc, c.getTel_cel());
            String sqlc="insert into Email (Correo, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqlc, c.getCorreo());
            return new ModelAndView ("redirect:../Coordinador/Resultados/Resultadoiguiente");
    }
    @RequestMapping(value="Coordinador/Resultados/Resultadosiguiente", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
          HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Error404");
        }else{
            mav.setViewName("Resultadonext");
        }
        return mav;
    }
    
    //Scripts para edición de Usuarios
    @RequestMapping(value="Coordinador/Resultados/EditarResultado", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            ResulID=Integer.parseInt(re.getParameter("ResulID"));
            
            String sql="select * from Persona p, Usuario u, Contacto c, Email em, Telefono_fijo tf, Telefono_celular tc, Municipio m, Estados es, Tipo_Sexo ts"+
"           WHERE u.Roles_ID_Roles=2"+
"            AND p.ID_Persona = u.Persona_ID_Persona"+
"            AND p.Tipo_Sexo_ID_Tipo_Sexo = ts.ID_Tipo_Sexo"+
"            AND p.Municipio_ID_Municipio = m.ID_Municipio"+
"            AND p.Municipio_Estados_ID_estado = m.Estados_ID_estado"+
"            AND m.Estados_ID_estado = es.ID_estado"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto"+ 
"            AND ID_Persona="+ResulID;
//        String sqles="select Escuela from Escuela where ID_Escuela=7";
        dat = this.rid.queryForList(sql);
//        es=this.rid.queryForList(sqles);
        mav.addObject("da",dat);
//        mav.addObject("es",es);
            mav.setViewName("Error404");
        }else{
            mav.setViewName("EditarResultado");
        }
        return mav;
    }
    @RequestMapping(value="Coordinador/Resultados/EditarResultado", method=RequestMethod.POST)
    public ModelAndView Editar(Usuario u, Persona p, Contacto c, Eventos ev){
        String sqlu="update Usuario set Nombre_U=?, Password_U=? where Persona_ID_Persona="+ResulID;
        this.rid.update(sqlu, u.getNombre_U(), u.getPassword_U());
        String sql="update Persona set Nombre=?, Ap_Pat=?, Ap_Mat=?, Tipo_Sexo_ID_Tipo_Sexo=?, CURP=?, Fecha_Nac=?, NSS=?, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+") where ID_Persona="+ResulID;
        this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
        
        String sqlcon="select ID_contacto from Contacto where Persona_ID_Persona="+a;
        try{
            ct=cn.Connect();
            ps=ct.prepareStatement(sqlcon);
            rs=ps.executeQuery();
            if(rs!=null){
                while(rs.next())
                co =rs.getString("ID_Contacto");
                
            }
        }catch(Exception e){
        }
        String sqltf="update Telefono_fijo set Telefono=? where Contacto_ID_Contacto="+co;
            this.rid.update(sqltf, c.getTel_fijo());
            String sqltc="update Telefono_Celular set Celular=? where Contacto_ID_Contacto="+co;
            this.rid.update(sqltc, c.getTel_cel());
            String sqlc="update Email set Correo=? where Contacto_ID_Contacto="+co;
            this.rid.update(sqlc, c.getCorreo());

        ModelAndView mv=new ModelAndView ("redirect:../Resultados");
//        mv.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
        return mv;
    }
}
