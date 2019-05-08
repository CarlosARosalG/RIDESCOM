/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.Entidad;

/**
 *
 * @author spy51
 */
public class Programa_Academico {
    int ID_Prog_Academico;
    String Nivel_ID_Nivel;
    String Area_Conocimiento_ID_Area_Conocimiento;
    String Programa;

    public Programa_Academico() {
    }

    public Programa_Academico(int ID_Prog_Academico, String Nivel_ID_Nivel, String Area_Conocimiento_ID_Area_Conocimiento, String Programa) {
        this.ID_Prog_Academico = ID_Prog_Academico;
        this.Nivel_ID_Nivel = Nivel_ID_Nivel;
        this.Area_Conocimiento_ID_Area_Conocimiento = Area_Conocimiento_ID_Area_Conocimiento;
        this.Programa = Programa;
    }

    public int getID_Prog_Academico() {
        return ID_Prog_Academico;
    }

    public void setID_Prog_Academico(int ID_Prog_Academico) {
        this.ID_Prog_Academico = ID_Prog_Academico;
    }

    public String getNivel_ID_Nivel() {
        return Nivel_ID_Nivel;
    }

    public void setNivel_ID_Nivel(String Nivel_ID_Nivel) {
        this.Nivel_ID_Nivel = Nivel_ID_Nivel;
    }

    public String getArea_Conocimiento_ID_Area_Conocimiento() {
        return Area_Conocimiento_ID_Area_Conocimiento;
    }

    public void setArea_Conocimiento_ID_Area_Conocimiento(String Area_Conocimiento_ID_Area_Conocimiento) {
        this.Area_Conocimiento_ID_Area_Conocimiento = Area_Conocimiento_ID_Area_Conocimiento;
    }

    public String getPrograma() {
        return Programa;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }
    
    
}
