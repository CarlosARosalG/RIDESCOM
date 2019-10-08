/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author spy51
 */
public class ConsultaInscritos {
    ModelAndView mav=new ModelAndView();
    
    @RequestMapping(value="Coordinador/ConsultaInscritos")
    public ModelAndView home(){   
        mav.setViewName("ConsultaInscritos");
        return mav;
    }
}
