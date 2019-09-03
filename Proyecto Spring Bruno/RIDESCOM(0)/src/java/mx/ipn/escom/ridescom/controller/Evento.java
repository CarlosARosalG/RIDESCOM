/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import mx.ipn.escom.ridescom.model.Eventos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Evento {
    ModelAndView mav=new ModelAndView();

    
//    @RequestMapping(value="Eventos")
//    public ModelAndView home(){   
//        mav.setViewName("Evento");
//        return mav;
//    }
    @RequestMapping(value="Eventos", method=RequestMethod.GET)
    public ModelAndView Ev(){
        mav.addObject(new Eventos());
        mav.setViewName("Evento");
        return mav;
    }
}
