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
    String Ap_Pat;
    String Ap_Mat;
    String Tipo_Sexo_ID;
    String CURP;
    String Fecha_Nac;
    String NSS;
    int Usuario_Usuario_ID;
    String Municipio_ID_Municipio;
    String Municipio_Estados_ID_estado;
    
    public Persona() {
        }

    public Persona(int ID_Persona, String Nombre, String Ap_Pat, String Ap_Mat, String Tipo_Sexo_ID, String CURP, String Fecha_Nac, String NSS, int Usuario_Usuario_ID, String Municipio_ID_Municipio, String Municipio_Estados_ID_estado) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Ap_Pat = Ap_Pat;
        this.Ap_Mat = Ap_Mat;
        this.Tipo_Sexo_ID = Tipo_Sexo_ID;
        this.CURP = CURP;
        this.Fecha_Nac = Fecha_Nac;
        this.NSS = NSS;
        this.Usuario_Usuario_ID = Usuario_Usuario_ID;
        this.Municipio_ID_Municipio = Municipio_ID_Municipio;
        this.Municipio_Estados_ID_estado = Municipio_Estados_ID_estado;
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

    public String getAp_Pat() {
        return Ap_Pat;
    }

    public void setAp_Pat(String Ap_Pat) {
        this.Ap_Pat = Ap_Pat;
    }

    public String getAp_Mat() {
        return Ap_Mat;
    }

    public void setAp_Mat(String Ap_Mat) {
        this.Ap_Mat = Ap_Mat;
    }

    public String getTipo_Sexo_ID() {
        return Tipo_Sexo_ID;
    }

    public void setTipo_Sexo_ID(String Tipo_Sexo_ID) {
        this.Tipo_Sexo_ID = Tipo_Sexo_ID;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getFecha_Nac() {
        return Fecha_Nac;
    }

    public void setFecha_Nac(String Fecha_Nac) {
        this.Fecha_Nac = Fecha_Nac;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public int getUsuario_Usuario_ID() {
        return Usuario_Usuario_ID;
    }

    public void setUsuario_Usuario_ID(int Usuario_Usuario_ID) {
        this.Usuario_Usuario_ID = Usuario_Usuario_ID;
    }

    public String getMunicipio_ID_Municipio() {
        return Municipio_ID_Municipio;
    }

    public void setMunicipio_ID_Municipio(String Municipio_ID_Municipio) {
        this.Municipio_ID_Municipio = Municipio_ID_Municipio;
    }

    public String getMunicipio_Estados_ID_estado() {
        return Municipio_Estados_ID_estado;
    }

    public void setMunicipio_Estados_ID_estado(String Municipio_Estados_ID_estado) {
        this.Municipio_Estados_ID_estado = Municipio_Estados_ID_estado;
    }
    
    
}
