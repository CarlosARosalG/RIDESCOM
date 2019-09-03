/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class CoordUA {
    ModelAndView mav=new ModelAndView();
    
    @RequestMapping(value="/Logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest re) throws Exception{
        HttpSession session = re.getSession();
        session.invalidate();
        return "redirect:/Login";
    }
    
    @RequestMapping(value="Coordinador")
    public ModelAndView coord(HttpServletRequest req){   
        HttpSession session = req.getSession();
        if(session.getAttribute("Nombre_U")== null){
         mav.setViewName("Login");
        }else if(session.getAttribute("Nombre_U").equals("DDyFD")){
        mav.setViewName("DDyFD");
        }
        mav.setViewName("CoordUA");
        return mav;
    }
}
