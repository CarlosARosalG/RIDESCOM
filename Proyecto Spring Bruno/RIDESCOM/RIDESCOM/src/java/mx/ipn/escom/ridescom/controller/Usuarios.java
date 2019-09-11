/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
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

@Controller
public class Usuarios {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    int UsuarioID;
    
    
    List dat;
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/AgregarUsuario", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Usuarios");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/AgregarUsuario", method=RequestMethod.POST)
    public ModelAndView Agrega(Persona p, Eventos ev, Contacto c )throws Exception{
            
            String sql="insert into Persona (Nombre, Ap_Pat, Ap_Mat, Tipo_Sexo_ID_Tipo_Sexo, CURP, Fecha_Nac, NSS, Usuario_Usuario_ID, Municipio_ID_Municipio, Municipio_Estados_ID_estado) values (?,?,?,?,?,?,?,NULL,?, (select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+"))";
            this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
            String sql1="insert into Contacto (Persona_ID_Persona) values ((select MAX(ID_Persona)from Persona))";
            this.rid.update(sql1);
            String sqld="insert into Persona_has_Act_Deportiva (Act_Deportiva_ID_Deporte,Persona_ID_Persona) values ((select ID_Deporte from Act_Deportiva where ID_Deporte="+ev.getDeporte()+"),(select MAX(ID_Persona)from Persona))";
            this.rid.update(sqld);
            String sqltf="insert into Telefono_fijo (Telefono, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltf, c.getTel_fijo());
            String sqltc="insert into Telefono_Celular (Celular, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltc, c.getTel_cel());
            String sqlc="insert into Email (Correo, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqlc, c.getCorreo());
            return new ModelAndView ("redirect:../Coordinador/Usuariosiguiente");
    }
    @RequestMapping(value="DDyFD/Usuariosiguiente", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
          HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Usuarionext");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    
    //Scripts para edición de Usuarios
    @RequestMapping(value="DDyFD/EditarUsuario", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
            
            String sql="select * from Persona p, persona_has_act_deportiva e, act_deportiva d, Contacto c, Email em, Telefono_fijo tf, Telefono_celular tc, Municipio m, Estados es, Tipo_Sexo ts"+
"           WHERE p.Usuario_Usuario_ID=2"+
"            AND p.ID_Persona = e.Persona_ID_Persona"+
"            AND p.Tipo_Sexo_ID_Tipo_Sexo = ts.ID_Tipo_Sexo"+
"            AND p.Municipio_ID_Municipio = m.ID_Municipio"+
"            AND p.Municipio_Estados_ID_estado = m.Estados_ID_estado"+
"            AND m.Estados_ID_estado = es.ID_estado"+
"            AND e.Act_Deportiva_ID_Deporte = d.ID_Deporte"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto"+ 
"            AND ID_Persona="+UsuarioID;
        dat = this.rid.queryForList(sql);
        mav.addObject("per",dat);
            mav.setViewName("EditarUsuario");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/EditarUsuario", method=RequestMethod.POST)
    public ModelAndView Editar(Persona p, Contacto c, Eventos ev){
        String sql="update Persona set Nombre=?, Ap_Pat=?, Ap_Mat=?, Tipo_Sexo_ID_Tipo_Sexo=?, CURP=?, Fecha_Nac=?, NSS=?, Usuario_Usuario_ID=NULL, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+")where ID_Persona="+UsuarioID;
        this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
//        String sql1="update Contacto set Persona_ID_Persona="+UsuarioID;
//        this.rid.update(sql1);
        String sqld="update Persona_has_Act_Deportiva set Act_Deportiva_ID_Deporte=(select ID_Deporte from Act_Deportiva where ID_Deporte="+ev.getDeporte()+") where Persona_ID_Persona="+UsuarioID;
        this.rid.update(sqld);
        String sqltf="update Telefono_fijo set Telefono=? where Contacto_ID_Contacto=(select ID_Contacto from Contacto where Persona_ID_Persona="+UsuarioID+")";
        this.rid.update(sqltf, c.getTel_fijo());
        String sqltc="update Telefono_Celular set Celular=? where Contacto_ID_Contacto=(select ID_Contacto from Contacto where Persona_ID_Persona="+UsuarioID+")";
        this.rid.update(sqltc, c.getTel_cel());
        String sqlc="update Email set Correo=? where Contacto_ID_Contacto=(select ID_Contacto from Contacto where Persona_ID_Persona="+UsuarioID+")";
        this.rid.update(sqlc, c.getCorreo());

        ModelAndView mv=new ModelAndView ("redirect:../Coordinador");
//        mv.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaUsuario", method=RequestMethod.GET)
    public ModelAndView confirm(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
        String sql="select * from Act_Deportiva where ID_Deporte="+UsuarioID;
        dat = this.rid.queryForList(sql);
        mav.addObject("usu",dat);
        mav.setViewName("DDyFD");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }

    //Scripts para borrar registros
    @RequestMapping(value="Coordinador/BorrarUsuario", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
        String sql="select * from Persona p, persona_has_act_deportiva e, act_deportiva d, Contacto c, Email em, Telefono_fijo tf, Telefono_celular tc, Municipio m, Estados es, Tipo_Sexo ts"+
"	WHERE p.Usuario_Usuario_ID is null"+
"            AND p.ID_Persona = e.Persona_ID_Persona"+
"            AND p.Tipo_Sexo_ID_Tipo_Sexo = ts.ID_Tipo_Sexo"+
"            AND p.Municipio_ID_Municipio = m.ID_Municipio"+
"            AND p.Municipio_Estados_ID_estado = m.Estados_ID_estado"+
"            AND m.Estados_ID_estado = es.ID_estado"+
"            AND e.Act_Deportiva_ID_Deporte = d.ID_Deporte"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto"+ 
"            AND ID_Persona="+UsuarioID;
        dat = this.rid.queryForList(sql);
        mav.addObject("per",dat);
        mav.setViewName("BorrarUsuario");
        }else{
        
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="Coordinador/BorrarUsuario", method=RequestMethod.POST)
    public ModelAndView delete(Persona p, Contacto c, Eventos ev){
        String sql="update Persona set Nombre=?, Ap_Pat=?, Ap_Mat=?, Tipo_Sexo_ID_Tipo_Sexo=?, CURP=?, Fecha_Nac=?, NSS=?, Usuario_Usuario_ID=NULL, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+") where ID_Persona="+UsuarioID;
        this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
//            String sql1="insert into Contacto (Persona_ID_Persona) values ((select MAX(ID_Persona)from Persona))";
//            this.rid.update(sql1);
//            String sqld="insert into Persona_has_Act_Deportiva (Act_Deportiva_ID_Deporte,Persona_ID_Persona) values ((select ID_Deporte from Act_Deportiva where ID_Deporte="+ev.getDeporte()+"),(select MAX(ID_Persona)from Persona))";
//            this.rid.update(sqld);
//            String sqltf="insert into Telefono_fijo (Telefono, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
//            this.rid.update(sqltf, c.getTel_fijo());
//            String sqltc="insert into Telefono_Celular (Celular, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
//            this.rid.update(sqltc, c.getTel_cel());
//            String sqlc="insert into Email (Correo, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
//            this.rid.update(sqlc, c.getCorreo());
        
//        String sql="update Persona set Disciplina=? where ID_Deporte="+UsuarioID;
//        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../ConfirmaBorrarUsuario");
        return mv;
    }
    @RequestMapping(value="Coordinador/ConfirmaBorrarUsuario")
    public ModelAndView confirma(HttpServletRequest re){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
        String sql ="delete from Persona where ID_Persona="+UsuarioID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../DDyFD");
        return mv;
    }
}
