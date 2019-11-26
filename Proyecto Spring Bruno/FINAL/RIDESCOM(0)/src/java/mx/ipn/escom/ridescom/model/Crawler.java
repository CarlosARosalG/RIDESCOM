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
public class Crawler {
    String User;
    String Password;
    String Captcha;
    String Nombre;
    String Grupo;

    public Crawler() {
    }

    public Crawler(String User, String Password, String Captcha, String Nombre, String Grupo) {
        this.User = User;
        this.Password = Password;
        this.Captcha = Captcha;
        this.Nombre = Nombre;
        this.Grupo = Grupo;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCaptcha() {
        return Captcha;
    }

    public void setCaptcha(String Captcha) {
        this.Captcha = Captcha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }
    
}
