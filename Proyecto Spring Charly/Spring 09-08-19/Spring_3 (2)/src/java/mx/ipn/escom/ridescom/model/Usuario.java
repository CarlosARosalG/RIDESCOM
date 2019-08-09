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
    int ID_Usuario;
    String Nombre_U;
    String Password_U;
    int activo = 1;

    public Usuario(int ID_Usuario, String Nombre_U, String Password_U, int activo) {
        this.ID_Usuario = ID_Usuario;
        this.Nombre_U = Nombre_U;
        this.Password_U = Password_U;
        this.activo = activo;
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

    public Usuario() {
    }

}
