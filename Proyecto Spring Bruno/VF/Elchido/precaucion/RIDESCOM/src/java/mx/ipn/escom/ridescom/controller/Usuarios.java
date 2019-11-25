/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

@Controller
public class Usuarios {
    Conexion con=new Conexion();
    Connect cn=new Connect();
    Connection ct;

    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    int UsuarioID;
    
    ResultSet rs=null;
    PreparedStatement ps;
    
    ResultSet rs1=null;
    PreparedStatement ps1;
    
    List dat;
    List dat2;
    List es;
    List ust;
    String p;
    String a;
    String co;
    String u;
    
    @RequestMapping(value="DDyFD/Usuarios.html", method=RequestMethod.GET)
    public ModelAndView lista(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            //Consulta de Uusarios de Coordinadores de UA
            String sql="select u.Nombre_U, if(u.Activo=1,'Activo','Inactivo')as Activo, p.Nombre, p.ID_Persona, p.Ap_Pat, p.Ap_Mat, s.Sexo, p.Fecha_Nac, p.CURP, p.NSS, ce.Correo, tf.Telefono, ex.Ext, tc.Celular" +
"	from persona p, Usuario u, contacto c, tipo_sexo s, email ce, telefono_fijo tf, telefono_celular tc, Roles r, Extension ex" +
"		where r.ID_Roles='2' " +
"               AND p.ID_Persona = u.Persona_ID_Persona" +
"               AND u.Roles_ID_Roles = r.ID_Roles" +
"               AND p.ID_Persona = c.Persona_ID_Persona" +
"               AND p.Tipo_Sexo_ID_Tipo_Sexo = s.ID_Tipo_Sexo" +
"               AND c.ID_Contacto = ce.Contacto_ID_Contacto" +
"		AND c.ID_Contacto = tf.Contacto_ID_Contacto" +
"		AND tf.ID_Tel_fijo= ex.Telefono_Fijo_ID_Tel_Fijo" +
"               AND c.ID_Contacto = tc.Contacto_ID_Contacto";
            dat2=this.rid.queryForList(sql);
            if(dat2!=null)
                mav.addObject("coo", dat2);
        mav.setViewName("Usuarios");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/Usuarios/AgregarUsuario.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("AgregarUsuario");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/AgregarUsuario.html", method=RequestMethod.POST)
    public ModelAndView Agrega(Usuario u, Persona p, Eventos ev, Contacto c )throws Exception{
            
            String sql="insert into Persona (Nombre, Ap_Pat, Ap_Mat, Tipo_Sexo_ID_Tipo_Sexo, CURP, Fecha_Nac, NSS, Municipio_ID_Municipio, Municipio_Estados_ID_estado) values (?,?,?,?,?,?,?,?, (select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+"))";
            this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
            String sqlu="insert into Usuario (Nombre_U, Password_U, Activo, Fecha_inicio, Roles_ID_Roles, Persona_ID_Persona) values (?,?,1,left(now(),10),2,(select MAX(ID_Persona)from Persona))";
            this.rid.update(sqlu, u.getNombre_U(), u.getPassword_U());
            String sql1="insert into Contacto (Persona_ID_Persona) values ((select MAX(ID_Persona)from Persona))";
            this.rid.update(sql1);
            String sqltf="insert into Telefono_fijo (Telefono, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltf, c.getTel_fijo());
            String sqltex="insert into Extension (Ext, Telefono_Fijo_ID_Tel_Fijo) values (?,(select MAX(ID_Tel_Fijo)from Telefono_Fijo))";
            this.rid.update(sqltex, c.getExt());
            String sqltc="insert into Telefono_Celular (Celular, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqltc, c.getTel_cel());
            String sqlc="insert into Email (Correo, Contacto_ID_Contacto) values (?,(select MAX(ID_Contacto)from Contacto))";
            this.rid.update(sqlc, c.getCorreo());
//            return new ModelAndView ("redirect:../Usuarios/Usuariosiguiente.html");
        mav.setViewName("redirect:../Usuarios.html");
        mav.addObject("mjs", "<div style='color: green;'>Se ha Agregado un Usuario correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/Usuariosiguiente.html", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/Usuarios/EditarUsuario.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
            
            String sql="select * from Persona p, Usuario u, Contacto c, Email em, Telefono_fijo tf, Extension ex,Telefono_celular tc, Municipio m, Estados es, Tipo_Sexo ts"+
"           WHERE u.Roles_ID_Roles=2"+
"            AND p.ID_Persona = u.Persona_ID_Persona"+
"            AND p.Tipo_Sexo_ID_Tipo_Sexo = ts.ID_Tipo_Sexo"+
"            AND p.Municipio_ID_Municipio = m.ID_Municipio"+
"            AND p.Municipio_Estados_ID_estado = m.Estados_ID_estado"+
"            AND m.Estados_ID_estado = es.ID_estado"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND tf.ID_Tel_Fijo=ex.Telefono_Fijo_ID_Tel_Fijo"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto"+ 
"            AND ID_Persona="+UsuarioID;
//        String sqles="select Escuela from Escuela where ID_Escuela=7";
        dat = this.rid.queryForList(sql);
//        es=this.rid.queryForList(sqles);
        mav.addObject("da",dat);
//        mav.addObject("es",es);
            mav.setViewName("EditarUsuario");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/EditarUsuario.html", method=RequestMethod.POST)
    public ModelAndView Editar(Usuario u, Persona p, Contacto c, Eventos ev){
        String sqlu="update Usuario set Nombre_U=?, Password_U=? where Persona_ID_Persona="+UsuarioID;
        this.rid.update(sqlu, u.getNombre_U(), u.getPassword_U());
        String sql="update Persona set Nombre=?, Ap_Pat=?, Ap_Mat=?, Tipo_Sexo_ID_Tipo_Sexo=?, CURP=?, Fecha_Nac=?, NSS=?, Municipio_ID_Municipio=?, Municipio_Estados_ID_estado=(select DISTINCT Estados_ID_estado from Municipio where ID_Municipio="+p.getMunicipio()+") where ID_Persona="+UsuarioID;
        this.rid.update(sql, p.getNombre(), p.getAppat(), p.getApmat(), p.getSexo(), p.getCURP(), p.getNacimiento(), p.getNSS(), p.getMunicipio());
        String sqlcon="select ID_contacto from Contacto where Persona_ID_Persona="+UsuarioID;
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
            String sqltex="update Extension set Ext=? where Telefono_Fijo_ID_Tel_Fijo= (select ID_Tel_Fijo from Telefono_Fijo where Contacto_ID_Contacto="+co+")";
            this.rid.update(sqltex, c.getExt());
            
        mav.setViewName("redirect:../Usuarios.html");
        mav.addObject("mjs", "<div style='color: green;'>Se han Actualizado los datos correctamente</div>");
        return mav;
//        ModelAndView mv=new ModelAndView ("redirect:../Usuarios.html");
////        mv.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
//        return mv;
    }
    @RequestMapping(value="DDyFD/ConfirmaUsuario.html", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/Usuarios/BorrarUsuario.html", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
        String sql="select * from Persona p, Usuario u, Contacto c, Email em, Telefono_fijo tf, Extension ex, Telefono_celular tc, Municipio m, Estados es, Tipo_Sexo ts"+
"           WHERE u.Roles_ID_Roles=2"+
"            AND p.ID_Persona = u.Persona_ID_Persona"+
"            AND p.Tipo_Sexo_ID_Tipo_Sexo = ts.ID_Tipo_Sexo"+
"            AND p.Municipio_ID_Municipio = m.ID_Municipio"+
"            AND p.Municipio_Estados_ID_estado = m.Estados_ID_estado"+
"            AND m.Estados_ID_estado = es.ID_estado"+
"            AND p.ID_Persona = c.Persona_ID_Persona"+
"            AND c.ID_Contacto = em.Contacto_ID_Contacto"+
"            AND c.ID_Contacto = tf.Contacto_ID_Contacto"+
"            AND tf.ID_Tel_Fijo=ex.Telefono_Fijo_ID_Tel_Fijo"+
"            AND c.ID_Contacto = tc.Contacto_ID_Contacto"+ 
"            AND ID_Persona="+UsuarioID;
        String sqles="select Escuela from Escuela where ID_Escuela=7";
        dat = this.rid.queryForList(sql);
        es=this.rid.queryForList(sqles);
        mav.addObject("usu",dat);
        mav.addObject("es",es);
        mav.setViewName("BorrarUsuario");
        }else{
        
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="DDyFD/Usuarios/BorrarUsuario.html", method=RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest re, Persona p, Contacto c, Eventos ev){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
//        String sql="update Usuario set Activo=0";
        String sql ="delete from Persona where ID_Persona="+UsuarioID;
        this.rid.update(sql);
        mav.setViewName("redirect:../Usuarios.html");
        mav.addObject("mjs", "<div style='color: green;'>Se ha eliminado un Usuario correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/ConfirmaBorrarUsuario.html")
    public ModelAndView confirma(HttpServletRequest re){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
//        String sql="update Usuario set Activo=0";
        String sql ="delete from Persona where ID_Persona="+UsuarioID;
        this.rid.update(sql);
        mav.setViewName("redirect:../Usuarios.html");
//        mav.addObject("mjs", "<div style='color: green;'>Se ha Eliminado un Usuario correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/DesactivarUsuario.html")
    public ModelAndView desactiva(HttpServletRequest re){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
//        String sql="update Usuario set Activo=0 where Usuario_ID=(select Usuario_Usuario_ID from Persona where ID_Persona="+UsuarioID+")";
        String sql ="select u.Usuario_ID, u.Nombre_U from Usuario u where u.Persona_ID_Persona="+UsuarioID;
        String sqll ="select u.Nombre_U from Usuario u where u.Persona_ID_Persona="+UsuarioID;
        try{
            ct=cn.Connect();
            ps=ct.prepareStatement(sql);
            ps1=ct.prepareStatement(sqll);
            rs=ps.executeQuery();
            rs1=ps1.executeQuery();
            if(rs!=null){
                while(rs.next())
                p =rs.getString("Usuario_ID");
            }
            if(rs!=null){
                while(rs1.next())
                u =rs1.getString("Nombre_U");
            }
        }catch(Exception e){
        }
        String sqlp="update Usuario set Activo=0 where Usuario_ID="+p;
        this.rid.update(sqlp);
//        ModelAndView mv=new ModelAndView ("redirect:../Usuarios.html");
//        return mv;
        mav.setViewName("redirect:../Usuarios.html");
        mav.addObject("mjs", "<div style='color: green;'>El usuario '"+u+"' está INACTIVO</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Usuarios/ActivarUsuario.html")
    public ModelAndView activa(HttpServletRequest re){
        UsuarioID=Integer.parseInt(re.getParameter("UsuarioID"));
//        String sql="update Usuario set Activo=0 where Usuario_ID=(select Usuario_Usuario_ID from Persona where ID_Persona="+UsuarioID+")";
        String sql ="select u.Usuario_ID, u.Nombre_U from Usuario u where u.Persona_ID_Persona="+UsuarioID;
        String sqll ="select u.Nombre_U from Usuario u where u.Persona_ID_Persona="+UsuarioID;
        try{
            ct=cn.Connect();
            ps=ct.prepareStatement(sql);
            ps1=ct.prepareStatement(sql);
            rs=ps.executeQuery();
            rs1=ps1.executeQuery();
            if(rs!=null){
                while(rs.next())
                p =rs.getString("Usuario_ID");
            }
            if(rs!=null){
                while(rs1.next())
                u =rs1.getString("Nombre_U");
            }
        }catch(Exception e){
        }
        String sqlp="update Usuario set Activo=1 where Usuario_ID="+p;
        this.rid.update(sqlp);
        mav.setViewName("redirect:../Usuarios.html");
        mav.addObject("mjs", "<div style='color: green;'>El usuario '"+u+"' está ACTIVO</div>");
        return mav;
    }
}
