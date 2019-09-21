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
public class Cuenta {
    int ID_Cuenta;
    String Fecha_Inicio;
    String Fecha_Fin;
    String Roles_ID_Roles;
    String Usuario_Usuario_ID;

    public Cuenta() {
    }

    public Cuenta(int ID_Cuenta, String Fecha_Inicio, String Fecha_Fin, String Roles_ID_Roles, String Usuario_Usuario_ID) {
        this.ID_Cuenta = ID_Cuenta;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.Roles_ID_Roles = Roles_ID_Roles;
        this.Usuario_Usuario_ID = Usuario_Usuario_ID;
    }

    public int getID_Cuenta() {
        return ID_Cuenta;
    }

    public void setID_Cuenta(int ID_Cuenta) {
        this.ID_Cuenta = ID_Cuenta;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(String Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public String getRoles_ID_Roles() {
        return Roles_ID_Roles;
    }

    public void setRoles_ID_Roles(String Roles_ID_Roles) {
        this.Roles_ID_Roles = Roles_ID_Roles;
    }

    public String getUsuario_Usuario_ID() {
        return Usuario_Usuario_ID;
    }

    public void setUsuario_Usuario_ID(String Usuario_Usuario_ID) {
        this.Usuario_Usuario_ID = Usuario_Usuario_ID;
    }
    
    
    
}
