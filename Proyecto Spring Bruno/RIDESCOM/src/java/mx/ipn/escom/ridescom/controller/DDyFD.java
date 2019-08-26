/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.model.Eventos;
import mx.ipn.escom.ridescom.model.Usuario;
import mx.ipn.escom.ridescom.model.UsuarioDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class DDyFD {
    ModelAndView mav=new ModelAndView();
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    
//    @RequestMapping(value="DDyFD")
//    public ModelAndView home(){   
//        mav.setViewName("DDyFD");
//        return mav;
//    }
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
        mav.addObject(new Eventos());
        mav.addObject(new Usuario());
        mav.addObject(new Pruebas());
        mav.setViewName("DDyFD");
        }else{
            mav.setViewName("CoordUA");
        }
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
