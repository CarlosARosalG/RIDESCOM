/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.ridescom.Modelo;

/**
 *
 * @author spy51
 */
public class Usuario {
    int ID;
    String usuario;
    String pass;

    public Usuario() {
    }

    public Usuario(int ID,String usuario, String pass) {
        this.ID=ID;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
