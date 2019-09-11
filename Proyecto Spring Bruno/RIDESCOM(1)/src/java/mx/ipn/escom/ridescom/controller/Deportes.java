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
    
    int DeporteID;
    
    List dat;
    
    @RequestMapping(value="DDyFD/Deportes", method=RequestMethod.GET)
    public ModelAndView Prueba(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("Deportes");
        }
        mav.addObject(new Deportes());
        String sql1="select * from Act_Deportiva";
        dat=this.rid.queryForList(sql1);
        mav.addObject("dep",dat);
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes", method=RequestMethod.POST)
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
            return new ModelAndView("redirect:/DDyFD");
            }else {
                return new ModelAndView("redirect:/Coordinador");
            }
        }else{
        ModelAndView mv=new ModelAndView("Login");
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario no existe.</div>");
        return mv;  
        }
        }else{
//             HttpSession session = req.getSession();
//             session.invalidate();
        //return "redirect:/";
            return new ModelAndView("Login");
        }
    }
    
    ////////////////////////////////// Operadores CRUD //////////////////////////////////////////////////////
    //Scripts para Agregar Deportes
    @RequestMapping(value="DDyFD/Deportes/AgregarDeporte", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("AgregarDeporte");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/AgregarDeporte", method=RequestMethod.POST)
    public ModelAndView Agrega(Deporte dep)throws Exception{
            
            String sql="insert into Act_Deportiva(Disciplina) value (?);";
            this.rid.update(sql, dep.getDisciplina());
            return new ModelAndView("redirect:../Deportes/Deportesiguiente");
    }
    @RequestMapping(value="DDyFD/Deportes/Deportesiguiente", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
          HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("Deportenext");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    
    //Scripts para edición de Deportes
    @RequestMapping(value="DDyFD/Deportes/EditarDeporte", method=RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest re)throws SQLException{
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
        String sql="select * from Act_Deportiva where ID_Deporte="+DeporteID;
        dat = this.rid.queryForList(sql);
        mav.addObject("dep",dat);
        mav.setViewName("EditarDeporte");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Deportes/EditarDeporte", method=RequestMethod.POST)
    public ModelAndView Editar(Deporte dep){
        String sql="update Act_Deportiva set Disciplina=? where ID_Deporte="+DeporteID;
        this.rid.update(sql, dep.getDisciplina());
        ModelAndView mv=new ModelAndView ("redirect:../Deportes");
//        mv.addObject("mjs", "<div style='color: green;'>Se han actualizado los datos correctamente</div>");
        return mv;
    }
    @RequestMapping(value="DDyFD/Deportes/ConfirmaDeporte", method=RequestMethod.GET)
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
    @RequestMapping(value="DDyFD/Deportes/BorrarDeporte", method=RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest re){
        HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Error404");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
        String sql="select * from Act_Deportiva where ID_Deporte="+DeporteID;
        dat = this.rid.queryForList(sql);
        mav.addObject("dep",dat);
        mav.setViewName("BorrarDeporte");
        }else{
            mav.setViewName("CoordUA");
        }
        return mav;
    }    
    @RequestMapping(value="DDyFD/Deportes/BorrarDeporte", method=RequestMethod.POST)
    public ModelAndView delete(Deporte dep){
        String sql="update Act_Deportiva set Disciplina=? where ID_Deporte="+DeporteID;
        this.rid.update(sql, dep.getDisciplina());
        ModelAndView mv=new ModelAndView ("redirect:../Deportes");
        return mv;
    }
    @RequestMapping(value="DDyFD/Deportes/ConfirmaBorrar")
    public ModelAndView confirma(HttpServletRequest re){
        DeporteID=Integer.parseInt(re.getParameter("DeporteID"));
        String sql ="delete from Act_Deportiva where ID_Deporte="+DeporteID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:../Deportes");
//        mv.addObject("msjs", "<div style='color: green;'>Se ha eliminado correctamente</div>");
        return mv;
    }


}
