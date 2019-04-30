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
public class Tipo_Genero {
    int ID_Tipo_Genero;
    String Genero;

    public Tipo_Genero() {
    }

    public Tipo_Genero(int ID_Tipo_Genero, String Genero) {
        this.ID_Tipo_Genero = ID_Tipo_Genero;
        this.Genero = Genero;
    }

    public int getID_Tipo_Genero() {
        return ID_Tipo_Genero;
    }

    public void setID_Tipo_Genero(int ID_Tipo_Genero) {
        this.ID_Tipo_Genero = ID_Tipo_Genero;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
    
    
}
