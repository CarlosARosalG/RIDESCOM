/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ritescom.entidad;

public class Usuario {
    
    int User_ID;
    String Nombre_user;
    String Psw_user;

    public Usuario() {
    }

    public Usuario(int User_ID, String Nombre_user, String Psw_user) {
        this.User_ID = User_ID;
        this.Nombre_user = Nombre_user;
        this.Psw_user = Psw_user;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getNombre_user() {
        return Nombre_user;
    }

    public void setNombre_user(String Nombre_user) {
        this.Nombre_user = Nombre_user;
    }

    public String getPsw_user() {
        return Psw_user;
    }

    public void setPsw_user(String Psw_user) {
        this.Psw_user = Psw_user;
    }

}
