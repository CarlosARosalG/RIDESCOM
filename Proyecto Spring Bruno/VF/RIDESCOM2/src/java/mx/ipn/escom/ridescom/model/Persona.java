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
public class Persona {
    int ID_Persona;
    String Nombre;
    String Appat;
    String Apmat;
    int Sexo;
    String CURP;
    String Nacimiento;
    String NSS;
    int Usuario;
    String municipio;
    String estado;

    public Persona() {
    }

    public Persona(int ID_Persona, String Nombre, String Appat, String Apmat, int Sexo, String CURP, String Nacimiento, String NSS, int Usuario, String municipio, String estado) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Appat = Appat;
        this.Apmat = Apmat;
        this.Sexo = Sexo;
        this.CURP = CURP;
        this.Nacimiento = Nacimiento;
        this.NSS = NSS;
        this.Usuario = Usuario;
        this.municipio = municipio;
        this.estado = estado;
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

    public String getAppat() {
        return Appat;
    }

    public void setAppat(String Appat) {
        this.Appat = Appat;
    }

    public String getApmat() {
        return Apmat;
    }

    public void setApmat(String Apmat) {
        this.Apmat = Apmat;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(String Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public int getUsuario() {
        return Usuario;
    }

    public void setUsuario(int Usuario) {
        this.Usuario = Usuario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
