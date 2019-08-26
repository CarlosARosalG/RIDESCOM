/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Conexion;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
    ModelAndView mav=new ModelAndView();
    Conexion cn=new Conexion();
    Connection con;
    JdbcTemplate rid=new JdbcTemplate(cn.ConectaRID());
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario us=new Usuario();
    UsuarioDAO udao=new UsuarioDAO();
    
    List dat;
//    @RequestMapping(value="Login")
//    public ModelAndView coord(){   
//        mav.setViewName("Login");
//        return mav;
//    }
//    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsri) {
//        if(hsr.getParameter("btn")!= null){
//            HttpSession session=hsr.getSession();
//            String user=hsr.getParameter("Nombre_U");
//            
//            session.setAttribute("Nombre_U", user);
//        }
//        ModelAndView mv=new ModelAndView("Login");
//        return mv;  
//    }
//    @RequestMapping(value="/Logout", method=RequestMethod.GET)
//    public String logut(HttpServletRequest re) throws Exception{
//        HttpSession session = re.getSession();
//        session.invalidate();
//        return "redirect:/";
//    }
    
    @RequestMapping(value="Login", method=RequestMethod.GET)
    public ModelAndView log(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")== null){
            mav.setViewName("Login");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
            mav.setViewName("DDyFD");
        }else if(session.getAttribute("Nombre_U").equals("ESCOM")){
            mav.setViewName("CoordUA");
        }
        return mav;
    }
    @RequestMapping(value="Login", method=RequestMethod.POST)
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
        mv.addObject("mjs", "<div style='color: red;'>ERROR, usuario o contraseña invalido.</div>");
        return mv;  
        }
        }else{
            return new ModelAndView("Login");
        }
/////////////////////////////////Version prueba1///////////////////////////////////////////////
//        String jefe="DDyFD";
//        String coord="ESCOM";
//        String sql="select Nombre_U, Password_U from usuario where Nombre_U=\""+u.getNombre_U()+"\" and Password_U=\""+u.getPassword_U()+"\"";
//        String sqlu="select Nombre_U from usuario where Nombre_U=\""+u.getNombre_U()+"\" and Password_U=\""+u.getPassword_U()+"\"";
//        dt=this.rid.queryForList(sqlu).toString();
//        mav.setViewName("Login");
//        
//        String user= us.getNombre_U();
//        String pass= us.getPassword_U();
//        us=udao.validar(user, pass);
//        if(u.getNombre_U()!= null && u.getPassword_U()!=null){
//            switch (u.getNombre_U()){
//                case "DDyFD":
//                    return new ModelAndView("redirect:/DDyFD");
//                        
//                case "ESCOM":
//                    return new ModelAndView("redirect:/Coordinador");
//                    
//                default:
//                    return new ModelAndView("redirect:/Login");
//            }
////                if(u.getNombre_U().equals(jefe)){
////                    
////                    this.rid.execute(sql);
////                    return new ModelAndView("redirect:/DDyFD");
////                }else {
////                    
////                    this.rid.execute(sql);
////                    return new ModelAndView("redirect:/Coordinador");
////                }
//        }else{
//            return new ModelAndView("redirect:/Login");
//        }
    }
//
//    @RequestMapping(value="LoginAlumno")
//    public ModelAndView alumno(){   
//        mav.setViewName("LoginAlumno");
//        return mav;
//    }
}
