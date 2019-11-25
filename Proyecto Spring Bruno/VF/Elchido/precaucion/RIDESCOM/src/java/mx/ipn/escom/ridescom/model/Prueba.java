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
public class Prueba {
    int ID_Prueba;
    String Prueba;
    int Tipo;
    int Act_Prueba;
    
    public Prueba() {
    }

    public Prueba(int ID_Prueba, String Prueba, int Tipo, int Act_Prueba) {
        this.ID_Prueba = ID_Prueba;
        this.Prueba = Prueba;
        this.Tipo = Tipo;
        this.Act_Prueba = Act_Prueba;
    }

    public int getID_Prueba() {
        return ID_Prueba;
    }

    public void setID_Prueba(int ID_Prueba) {
        this.ID_Prueba = ID_Prueba;
    }

    public String getPrueba() {
        return Prueba;
    }

    public void setPrueba(String Prueba) {
        this.Prueba = Prueba;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public int getAct_Prueba() {
        return Act_Prueba;
    }

    public void setAct_Prueba(int Act_Prueba) {
        this.Act_Prueba = Act_Prueba;
    }
    
}
