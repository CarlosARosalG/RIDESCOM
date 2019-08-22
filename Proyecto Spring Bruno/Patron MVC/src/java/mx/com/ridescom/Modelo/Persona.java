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
public class Persona {
    int ID;
    String Nombre;
    String Appat;
    String Apmat;
    String Sexo;
    String CURP;
    String F_nac;
    String NSS;
    String IDU;
    String Municipio;
    String Estado;

    public Persona() {
    }

    public Persona(int ID, String Nombre, String Appat, String Apmat, String Sexo, String CURP, String F_nac, String NSS, String IDU, String Municipio, String Estado) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Appat = Appat;
        this.Apmat = Apmat;
        this.Sexo = Sexo;
        this.CURP = CURP;
        this.F_nac = F_nac;
        this.NSS = NSS;
        this.IDU = IDU;
        this.Municipio = Municipio;
        this.Estado = Estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getF_nac() {
        return F_nac;
    }

    public void setF_nac(String F_nac) {
        this.F_nac = F_nac;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getIDU() {
        return IDU;
    }

    public void setIDU(String IDU) {
        this.IDU = IDU;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
