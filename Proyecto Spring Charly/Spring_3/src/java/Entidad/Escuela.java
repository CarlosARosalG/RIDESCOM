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
public class Escuela {
    String ID_Escuela;
    String Escuela;

    public Escuela() {
    }

    public Escuela(String ID_Escuela, String Escuela) {
        this.ID_Escuela = ID_Escuela;
        this.Escuela = Escuela;
    }

    public String getID_Escuela() {
        return ID_Escuela;
    }

    public void setID_Escuela(String ID_Escuela) {
        this.ID_Escuela = ID_Escuela;
    }

    public String getEscuela() {
        return Escuela;
    }

    public void setEscuela(String Escuela) {
        this.Escuela = Escuela;
    }
    
    
    
}
