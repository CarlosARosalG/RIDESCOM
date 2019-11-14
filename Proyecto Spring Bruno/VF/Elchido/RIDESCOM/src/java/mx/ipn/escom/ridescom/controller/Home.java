/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.ipn.escom.ridescom.config.Connect;
import mx.ipn.escom.ridescom.config.Craw;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
    ModelAndView mav=new ModelAndView();
//    Craw cw=new Craw();
    
    Connect cn=new Connect();
    java.sql.Connection ct;
    ResultSet rs;
    PreparedStatement ps;
    String ro;
    
    @RequestMapping(value="Home.html", method=RequestMethod.GET)
    public ModelAndView home(HttpServletRequest req){  
        HttpSession session = req.getSession();
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
         
        if(session.getAttribute("Nombre_U")!= null){
            if(ro.equals("1")){
            mav.setViewName("redirect:/DDyFD.html");
            }else if(ro.equals("2")){
            mav.setViewName("redirect:/Coordinador.html");
            }else if(ro.equals("3")){
            mav.setViewName("redirect:/Alumno.html");    
            }
        }else{
            mav.setViewName("index");
        }
        return mav;
    }
    @RequestMapping(value="Home.html", method=RequestMethod.POST)
    public ModelAndView golog(HttpServletRequest req) throws Exception{   
        String accion=req.getParameter("alumno");
        if(accion.equalsIgnoreCase("alu")){
//            cw.downloadCaptcha();
            mav.setViewName("redirect:/LoginAlumno.html");
        }else{
            mav.setViewName("Home.html");
        }
        return mav;
    }
}
