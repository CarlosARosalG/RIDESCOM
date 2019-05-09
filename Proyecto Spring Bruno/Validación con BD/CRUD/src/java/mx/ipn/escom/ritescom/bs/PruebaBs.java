/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ritescom.bs;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author spy51
 */
@Service("pruebaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PruebaBs { //Aqui va Codigo Crawler
    public String pruba(){
        return "prueba";
    }
}
