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
public class Ciclo {
    int ID_Ciclo;
    String Ciclo;

    public Ciclo() {
    }

    public Ciclo(int ID_Ciclo, String Ciclo) {
        this.ID_Ciclo = ID_Ciclo;
        this.Ciclo = Ciclo;
    }

    public int getID_Ciclo() {
        return ID_Ciclo;
    }

    public void setID_Ciclo(int ID_Ciclo) {
        this.ID_Ciclo = ID_Ciclo;
    }

    public String getCiclo() {
        return Ciclo;
    }

    public void setCiclo(String Ciclo) {
        this.Ciclo = Ciclo;
    }
    
    
    
}
