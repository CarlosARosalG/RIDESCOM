/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import javax.servlet.http.HttpServletRequest;
import mx.ipn.escom.ridescom.config.Craw;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
    ModelAndView mav=new ModelAndView();
    Craw cw=new Craw();
    
    @RequestMapping(value="Home.html", method=RequestMethod.GET)
    public ModelAndView home(){   
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping(value="Home.html", method=RequestMethod.POST)
    public ModelAndView golog(HttpServletRequest req) throws Exception{   
        String accion=req.getParameter("alumno");
        String accion1=req.getParameter("coordinador");
        if(accion.equalsIgnoreCase("alu")){
//            cw.downloadCaptcha();
            mav.setViewName("redirect:/LoginAlumno.html");
        }else{
            mav.setViewName("Home.html");
        }
        return mav;
    }
}
