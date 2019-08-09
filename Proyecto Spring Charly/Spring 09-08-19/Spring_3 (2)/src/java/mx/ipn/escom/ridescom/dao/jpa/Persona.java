/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ridescom.dao.jpa;

/**
 *
 * @author Carlos A. Rosales
 */
public class Persona {
    int ID_Persona;
    String Nombre;
    String Apellido1;
    String Apellido2;
    int Genero;
    String Fecha_nac;
    String CURP;
    String NSS;
    String Mun;
    String Edo;

    public Persona() {
    }

    public Persona(int ID_Persona, String Nombre, String Apellido1, String Apellido2, int Genero, String Fecha_nac, String CURP, String NSS, String Mun, String Edo) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Genero = Genero;
        this.Fecha_nac = Fecha_nac;
        this.CURP = CURP;
        this.NSS = NSS;
        this.Mun = Mun;
        this.Edo = Edo;
    }

    public int getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(int ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getMun() {
        return Mun;
    }

    public void setMun(String Mun) {
        this.Mun = Mun;
    }

    public String getEdo() {
        return Edo;
    }

    public void setEdo(String Edo) {
        this.Edo = Edo;
    }

    public String getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(String Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }
    
}
