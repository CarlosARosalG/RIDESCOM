/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.dao.jpa;

/**
 *
 * @author Carlos A. Rosales
 */

import java.util.List;
import mx.ipn.escom.ridescom.dao.AlumnoDao;
import mx.ipn.escom.ridescom.model.Alumno;

public class AlumnoJpaDao extends Alumno {
    
    @Override
    public List<Alumno> Alumno(){
        String consulta = "select a.ID_Alumno, a.Escuela_has_Prog_Academico_Escuela_ID_Escuela\n" 
                + "from Alumno a;";
        List<Alumno> lista = excuteQuery(consulta);
        return lista == null || lista.isEmpty()?null: lista;
    }

    private List<Alumno> excuteQuery(String consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
