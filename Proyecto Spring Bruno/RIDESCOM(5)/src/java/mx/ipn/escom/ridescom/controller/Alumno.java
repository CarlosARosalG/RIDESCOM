/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class Alumno {
    ModelAndView mav=new ModelAndView();
    
    @RequestMapping(value="InfoAlumno", method=RequestMethod.GET)
    public ModelAndView Ialu(){   
        mav.setViewName("InfoAlumno");
        return mav;
    }
    @RequestMapping(value="Alumno", method=RequestMethod.GET)
    public ModelAndView Alumno(){   
        mav.setViewName("Alumno");
        return mav;
    }
}
