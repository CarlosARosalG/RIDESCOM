/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.model.Deporte;
import mx.ipn.escom.ridescom.model.Prueba;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */

public class Deportes {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    int DeporteID;
    
    List dat;
    
    @RequestMapping(value="DDyFD/Deportes.html", method=RequestMethod.GET)
    public ModelAndView Prueba(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
//         mav.clear();
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
         mav.setViewName("Login");
        }else{
            if(ro.equals("1")){
                mav.addObject(new Deportes());
                String sql1="select * from Act_Deportiva order by Disciplina ASC";
                dat=this.rid.queryForList(sql1);
                mav.addObject("dep",dat);
                mav.setViewName("Deportes");
            }else if(ro.equals("2")){
                mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
                mav.setViewName("redirect:/Alumno.html");    
            }
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes.html", method=RequestMethod.POST)
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        
        String accion=req.getParameter("btn");
        if(accion.equalsIgnoreCase("Entrar")){
        String usuario=req.getParameter("Nombre_U");
        String pass=req.getParameter("Password_U");
        String jefe= "DDyFD";
        
        us=udao.validar(usuario, pass);

        if(us.getNombre_U()!= null){
            if(us.getNombre_U().equals(jefe)){
            
            HttpSession session=req.getSession();
            session.setAttribute("Nombre_U", jefe); //user
            return new ModelAndView("redirect:/DDyFD.html");
            }else {
                return new ModelAndView("redirect:/Coordinador.html");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login.html");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
        return mv;  
        }
        }else{
//             HttpSession session = req.getSession();
//             session.invalidate();
        //return "redirect:/";
            return new ModelAndView("Login.html");
        }
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/Deportes/AgregarDeporte.html", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
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
                mav.addObject(new Deportes());
                mav.setViewName("AgregarDeporte");
            }else if(ro.equals("2")){
                mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
                mav.setViewName("redirect:/Alumno.html");    
            }
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/AgregarDeporte.html", method=RequestMethod.POST)
    public ModelAndView Agrega(Deporte dep)throws Exception{
            
            String sql="insert into Act_Deportiva(Disciplina) value (?);";
            this.rid.update(sql, dep.getDisciplina());
        mav.setViewName("redirect:../Deportes.html");
        mav.addObject("mjs", "<div style='color: green;'>Se ha Agregado un deporte correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/Deportesiguiente.html", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
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
                mav.setViewName("Deportenext");
            }else if(ro.equals("2")){
                mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
                mav.setViewName("redirect:/Alumno.html");    
            }
        }
        return mav;
    }
    
    //Scripts para edición de Deportes
    @RequestMapping(value="DDyFD/Deportes/EditarDeporte.html", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
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
                DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
                String sql="select distinct i.Evento_Evento_ID from Inscripcion i inner join (act_deportiva dep, pruebas pr, evento ev) on (dep.ID_Deporte=pr.Act_Deportiva_ID_Deporte and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas and ev.Evento_ID=i.Evento_Evento_ID) where dep.ID_Deporte="+DeporteID;
                java.sql.Connection ctd;
                ResultSet rsd;
                PreparedStatement psd;
                String de=null;
                try{
                    ctd=cn.Connect();
                    psd=ctd.prepareStatement(sql);
                    rsd=psd.executeQuery();
                    if(rsd!=null ){
                        while(rsd.next() ){
                        de =rsd.getString("Evento_Evento_ID");
                        }
                    }
                }catch(Exception e){
                }
                if(de==null){
                    DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
                        String sqla="select * from Act_Deportiva where ID_Deporte="+DeporteID;    
                        dat = this.rid.queryForList(sqla);
                        mav.addObject("dep",dat);
                        mav.setViewName("EditarDeporte");
                }else{
                        String sqlda="select * from Act_Deportiva where ID_Deporte="+DeporteID;
                        dat = this.rid.queryForList(sqlda);
                        mav.addObject("dep",dat);
                        mav.setViewName("ExisteDep");
                }
            }else if(ro.equals("2")){
                mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
                mav.setViewName("redirect:/Alumno.html");    
            }
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/EditarDeporte.html", method=RequestMethod.POST)
    public ModelAndView Editar(HttpServletRequest re, Deporte dep){
        String sql="update Act_Deportiva set Disciplina=? where ID_Deporte="+DeporteID;
        String dis=re.getParameter("Disciplina");
        this.rid.update(sql, dis);
        mav.setViewName("redirect:../Deportes.html");
        mav.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/ConfirmaDeporte.html", method=RequestMethod.GET)
    public ModelAndView confirm(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
        String sql="select * from Act_Deportiva where ID_Deporte="+DeporteID;
        dat = this.rid.queryForList(sql);
        mav.addObject("dep",dat);
        mav.setViewName("ConfirmaEdiciond");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }

    //Scripts para borrar registros
//    @RequestMapping(value="DDyFD/Deportes/BorrarDeporte.html", method=RequestMethod.GET)
//    public ModelAndView delete(HttpServletRequest re){   
//        HttpSession session = re.getSession();
//        String ur="select Roles_ID_Roles from usuario where Nombre_U='"+session.getAttribute("Nombre_U")+"';";
//         try{
//            ct=cn.Connect();
//            ps=ct.prepareStatement(ur);
//            rs=ps.executeQuery();
//            if(rs!=null ){
//                while(rs.next() ){
//                ro =rs.getString("Roles_ID_Roles");
//                }
//            }
//        }catch(Exception e){
//        }
//        if(session.getAttribute("Nombre_U")== null){
//         mav.setViewName("Login");
//        }else{
//            if(ro.equals("1")){
//                DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
//                String sql="select * from Act_Deportiva where ID_Deporte="+DeporteID;
//                dat = this.rid.queryForList(sql);
//                mav.addObject("dep",dat);
//                mav.setViewName("BorrarDeporte");
//            }else if(ro.equals("2")){
//                mav.setViewName("redirect:/Coordinador.html");
//            }else if(ro.equals("3")){
//                mav.setViewName("redirect:/Alumno.html");    
//            }
//        }
//        return mav;
//    }    
    @RequestMapping(value="DDyFD/Deportes/BorrarDeporte.html")
    public ModelAndView delete(HttpServletRequest re, Deporte dep){
        HttpSession session = re.getSession();
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
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
                String sql="select distinct i.Evento_Evento_ID from Inscripcion i inner join (act_deportiva dep, pruebas pr, evento ev) on (dep.ID_Deporte=pr.Act_Deportiva_ID_Deporte and pr.ID_Pruebas=ev.Pruebas_ID_Pruebas and ev.Evento_ID=i.Evento_Evento_ID) where dep.ID_Deporte="+DeporteID;
                java.sql.Connection ctd;
                ResultSet rsd;
                PreparedStatement psd;
                String de=null;
                try{
                    ctd=cn.Connect();
                    psd=ctd.prepareStatement(sql);
                    rsd=psd.executeQuery();
                    if(rsd!=null ){
                        while(rsd.next() ){
                        de =rsd.getString("Evento_Evento_ID");
                        }
                    }
                }catch(Exception e){
                }
                if(de==null){
                    String sqlde ="delete from Act_Deportiva where ID_Deporte="+DeporteID;
                    this.rid.update(sqlde);
                    mav.addObject("mjs", "<div style='color: green;'>Se ha Eliminado correctamente</div>");
                    mav.setViewName("redirect:../Deportes.html");
                }else{
                        String sqlda="select * from Act_Deportiva where ID_Deporte="+DeporteID;
                        dat = this.rid.queryForList(sqlda);
                        mav.addObject("dep",dat);
                        mav.setViewName("BorrarDeporte");
                }
            }else if(ro.equals("2")){
                mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
                mav.setViewName("redirect:/Alumno.html");    
            }
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/ConfirmaBorrar.html")
    public ModelAndView confirma(HttpServletRequest re){
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
        String sql ="delete from Act_Deportiva where ID_Deporte="+DeporteID;
        this.rid.update(sql);
        mav.setViewName("redirect:../Deportes.html");
//        mav.addObject("mjs", "<div style='color: green;'>Se ha Eliminado correctamente</div>");
        return mav;
    }
}
