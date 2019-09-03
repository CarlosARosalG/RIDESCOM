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
import mx.ipn.escom.ridescom.model.Eventos;
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
//        if(req.getParameter("btn")!= null){
        if(us.getNombre_U()!= null){
            if(us.getNombre_U().equals(jefe)){
            
            HttpSession session=req.getSession();
//            String user=req.getParameter("Nombre_U");
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
    
    @RequestMapping(value="BorrarDeporte")
    public ModelAndView delete(HttpServletRequest request){
        DeporteID=Integer.parseInt(request.getParameter("DeporteID"));
        String sql ="delete from Act_Deportiva where ID_Deporte="+DeporteID;
        this.rid.update(sql);
        return new ModelAndView("redirect:../Deportes");
    }

}
