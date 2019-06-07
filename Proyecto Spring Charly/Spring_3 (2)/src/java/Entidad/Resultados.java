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
public class Resultados {
    int ID_Resultados;
    String Lugar_Obtenido;
    String Marca;
    String Alumno_has_Evento_Alumno_ID_Alumno;
    String Alumno_has_Evento_Evento_ID;

    public Resultados() {
    }

    public Resultados(int ID_Resultados, String Lugar_Obtenido, String Marca, String Alumno_has_Evento_Alumno_ID_Alumno, String Alumno_has_Evento_Evento_ID) {
        this.ID_Resultados = ID_Resultados;
        this.Lugar_Obtenido = Lugar_Obtenido;
        this.Marca = Marca;
        this.Alumno_has_Evento_Alumno_ID_Alumno = Alumno_has_Evento_Alumno_ID_Alumno;
        this.Alumno_has_Evento_Evento_ID = Alumno_has_Evento_Evento_ID;
    }

    public int getID_Resultados() {
        return ID_Resultados;
    }

    public void setID_Resultados(int ID_Resultados) {
        this.ID_Resultados = ID_Resultados;
    }

    public String getLugar_Obtenido() {
        return Lugar_Obtenido;
    }

    public void setLugar_Obtenido(String Lugar_Obtenido) {
        this.Lugar_Obtenido = Lugar_Obtenido;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getAlumno_has_Evento_Alumno_ID_Alumno() {
        return Alumno_has_Evento_Alumno_ID_Alumno;
    }

    public void setAlumno_has_Evento_Alumno_ID_Alumno(String Alumno_has_Evento_Alumno_ID_Alumno) {
        this.Alumno_has_Evento_Alumno_ID_Alumno = Alumno_has_Evento_Alumno_ID_Alumno;
    }

    public String getAlumno_has_Evento_Evento_ID() {
        return Alumno_has_Evento_Evento_ID;
    }

    public void setAlumno_has_Evento_Evento_ID(String Alumno_has_Evento_Evento_ID) {
        this.Alumno_has_Evento_Evento_ID = Alumno_has_Evento_Evento_ID;
    }
    
    
    
}
