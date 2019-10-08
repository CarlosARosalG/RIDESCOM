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
public class Sede {
    int ID_S;
    String Sede;
    String Calle;
    String Colonia;
    String Numero;
    String CP;
    String Municipio;
    String Estado;

    public Sede() {
    }

    public Sede(int ID_S, String Sede, String Calle, String Colonia, String Numero, String CP, String Municipio, String Estado) {
        this.ID_S = ID_S;
        this.Sede = Sede;
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Numero = Numero;
        this.CP = CP;
        this.Municipio = Municipio;
        this.Estado = Estado;
    }

    public int getID_S() {
        return ID_S;
    }

    public void setID_S(int ID_S) {
        this.ID_S = ID_S;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
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
