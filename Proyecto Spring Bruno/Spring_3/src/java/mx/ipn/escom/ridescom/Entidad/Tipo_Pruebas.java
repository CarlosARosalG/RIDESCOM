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
public class Tipo_Pruebas {
    int ID_Tipo;
    String Tipo;

    public Tipo_Pruebas() {
    }

    public Tipo_Pruebas(int ID_Tipo, String Tipo) {
        this.ID_Tipo = ID_Tipo;
        this.Tipo = Tipo;
    }

    public int getID_Tipo() {
        return ID_Tipo;
    }

    public void setID_Tipo(int ID_Tipo) {
        this.ID_Tipo = ID_Tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
