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
import mx.ipn.escom.ridescom.model.Prueba;
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
public class Pruebas {
    Conexion con=new Conexion();
    ModelAndView mav=new ModelAndView();
    UsuarioDAO udao=new UsuarioDAO();
    Usuario us=new Usuario();
    Prueba pr=new Prueba();
    int PruebaID;
    
    JdbcTemplate rid=new JdbcTemplate(con.ConectaRID());
    
    List dat;
    
    @RequestMapping(value="DDyFD/Pruebas", method=RequestMethod.GET)
    public ModelAndView Prueba(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.addObject(new Eventos());
        mav.addObject(new Usuario());
        mav.addObject(new Pruebas());
        mav.setViewName("Pruebas");
        }
        String sql1="select ID_Pruebas, Prueba, Tipo_Pruebas_ID_Prueba, Act_Deportiva_ID_Deporte, Tipo_Pruebas.Tipo, Act_Deportiva.Disciplina from Pruebas "
                + "inner join (Tipo_Pruebas,Act_Deportiva) on (Pruebas.Tipo_Pruebas_ID_Prueba=Tipo_Pruebas.ID_Tipo AND Pruebas.Act_Deportiva_ID_Deporte=Act_Deportiva.ID_Deporte)";
//        String sql2="select ID_Pruebas, Prueba, if(Tipo_Pruebas_ID_Prueba='1','Individual','Por Equipos')as Tipo_Pruebas_ID_Prueba, Act_Deportiva_ID_Deporte from Pruebas";
        dat=this.rid.queryForList(sql1);
        mav.addObject("prue",dat);
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas", method=RequestMethod.POST)
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
    
    @RequestMapping(value="DDyFD/Pruebas/AgregarPrueba", method=RequestMethod.GET)
    public ModelAndView Agrega(HttpServletRequest re)throws SQLException{
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("AgregarPrueba");
        }
        return mav;
    }
    @RequestMapping(value="DDyFD/Pruebas/AgregarPrueba", method=RequestMethod.POST)
    public ModelAndView Agrega(Prueba pru){
        
        return new ModelAndView("redirect:/DDyFD/Pruebas/Pruebasiguiente");
    }
    @RequestMapping(value="BorrarPrueba")
    public ModelAndView delete(HttpServletRequest request){
        PruebaID=Integer.parseInt(request.getParameter("PruebaID"));
        String sql ="delete from Pruebas where ID_Pruebas="+PruebaID;
        this.rid.update(sql);
        ModelAndView mv=new ModelAndView ("redirect:Pruebas");

        return mv;
    }
    
    @RequestMapping(value="DDyFD/Pruebas/Pruebasiguiente", method=RequestMethod.GET)
    public ModelAndView sig(HttpServletRequest re){
         HttpSession session = re.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else{
        mav.setViewName("Pruebanext");
        }
        return mav;
    }
}
