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
public class Usuario {
    int ID;
    String Nombre_U;
    String Password_U;
    String activo;

    public Usuario() {
    }

    public Usuario(int ID, String Nombre_U, String Password_U, String activo) {
        this.ID = ID;
        this.Nombre_U = Nombre_U;
        this.Password_U = Password_U;
        this.activo = activo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_U() {
        return Nombre_U;
    }

    public void setNombre_U(String Nombre_U) {
        this.Nombre_U = Nombre_U;
    }

    public String getPassword_U() {
        return Password_U;
    }

    public void setPassword_U(String Password_U) {
        this.Password_U = Password_U;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    
    
}
