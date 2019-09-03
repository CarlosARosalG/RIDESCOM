/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Entrenadores {
    
    ModelAndView mav=new ModelAndView();
    
    @RequestMapping(value="Entrenadores")
    public ModelAndView listar(){   
        mav.setViewName("Entrenadores");
        return mav;
    }
    
}
