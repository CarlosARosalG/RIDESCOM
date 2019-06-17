/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.model;

/**
 *
 * @author spy51
 */
public class Nivel {
    int ID_Escuela;
    String Escuela;

    public Nivel() {
    }

    public Nivel(int ID_Escuela, String Escuela) {
        this.ID_Escuela = ID_Escuela;
        this.Escuela = Escuela;
    }

    public int getID_Escuela() {
        return ID_Escuela;
    }

    public void setID_Escuela(int ID_Escuela) {
        this.ID_Escuela = ID_Escuela;
    }

    public String getEscuela() {
        return Escuela;
    }

    public void setEscuela(String Escuela) {
        this.Escuela = Escuela;
    }
    
    
    
}
