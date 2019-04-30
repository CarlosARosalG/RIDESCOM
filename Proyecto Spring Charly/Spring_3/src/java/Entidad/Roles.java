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
public class Roles {
    int ID_Roles;
    String Rol;

    public Roles() {
    }

    public Roles(int ID_Roles, String Rol) {
        this.ID_Roles = ID_Roles;
        this.Rol = Rol;
    }

    public int getID_Roles() {
        return ID_Roles;
    }

    public void setID_Roles(int ID_Roles) {
        this.ID_Roles = ID_Roles;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    
}
