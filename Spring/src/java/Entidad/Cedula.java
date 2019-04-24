/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author spy51
 */
public class Cedula {
    int Cedula_ID;
    String Alumno_has_Evento_Alumno_ID_Alumno;
    String Alumno_has_Evento_Evento_Evento_ID;
    String Alumno_has_Evento_Resultado_ID_resultado;

    public Cedula() {
    }

    public Cedula(int Cedula_ID, String Alumno_has_Evento_Alumno_ID_Alumno, String Alumno_has_Evento_Evento_Evento_ID, String Alumno_has_Evento_Resultado_ID_resultado) {
        this.Cedula_ID = Cedula_ID;
        this.Alumno_has_Evento_Alumno_ID_Alumno = Alumno_has_Evento_Alumno_ID_Alumno;
        this.Alumno_has_Evento_Evento_Evento_ID = Alumno_has_Evento_Evento_Evento_ID;
        this.Alumno_has_Evento_Resultado_ID_resultado = Alumno_has_Evento_Resultado_ID_resultado;
    }

    public int getCedula_ID() {
        return Cedula_ID;
    }

    public void setCedula_ID(int Cedula_ID) {
        this.Cedula_ID = Cedula_ID;
    }

    public String getAlumno_has_Evento_Alumno_ID_Alumno() {
        return Alumno_has_Evento_Alumno_ID_Alumno;
    }

    public void setAlumno_has_Evento_Alumno_ID_Alumno(String Alumno_has_Evento_Alumno_ID_Alumno) {
        this.Alumno_has_Evento_Alumno_ID_Alumno = Alumno_has_Evento_Alumno_ID_Alumno;
    }

    public String getAlumno_has_Evento_Evento_Evento_ID() {
        return Alumno_has_Evento_Evento_Evento_ID;
    }

    public void setAlumno_has_Evento_Evento_Evento_ID(String Alumno_has_Evento_Evento_Evento_ID) {
        this.Alumno_has_Evento_Evento_Evento_ID = Alumno_has_Evento_Evento_Evento_ID;
    }

    public String getAlumno_has_Evento_Resultado_ID_resultado() {
        return Alumno_has_Evento_Resultado_ID_resultado;
    }

    public void setAlumno_has_Evento_Resultado_ID_resultado(String Alumno_has_Evento_Resultado_ID_resultado) {
        this.Alumno_has_Evento_Resultado_ID_resultado = Alumno_has_Evento_Resultado_ID_resultado;
    }
    
    
    
}
