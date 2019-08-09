/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.dao;

import java.math.BigDecimal;
import java.util.List;
import mx.ipn.escom.ridescom.model.Alumno;

/**
 *
 * @author Carlos A. Rosales
 */
public interface AlumnoDao extends DaoBase<Alumno, BigDecimal> {
    
    public List<Alumno> Alumno(ID_Alumno a);

    public static class ID_Alumno {

        public ID_Alumno() {
        }
    }
    
}
