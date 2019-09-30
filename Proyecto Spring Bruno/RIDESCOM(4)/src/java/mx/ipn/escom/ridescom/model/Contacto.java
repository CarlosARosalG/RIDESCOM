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
public class Contacto {
    int ID_Contacto;
    String Correo;
    String Tel_fijo;
    String Tel_cel;

    public Contacto() {
    }

    public Contacto(int ID_Contacto, String Correo, String Tel_fijo, String Tel_cel) {
        this.ID_Contacto = ID_Contacto;
        this.Correo = Correo;
        this.Tel_fijo = Tel_fijo;
        this.Tel_cel = Tel_cel;
    }

    public int getID_Contacto() {
        return ID_Contacto;
    }

    public void setID_Contacto(int ID_Contacto) {
        this.ID_Contacto = ID_Contacto;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTel_fijo() {
        return Tel_fijo;
    }

    public void setTel_fijo(String Tel_fijo) {
        this.Tel_fijo = Tel_fijo;
    }

    public String getTel_cel() {
        return Tel_cel;
    }

    public void setTel_cel(String Tel_cel) {
        this.Tel_cel = Tel_cel;
    }
    
    
}
