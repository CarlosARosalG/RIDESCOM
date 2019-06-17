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
public class Municipio {
    String ID_Municipio;
    String Estados_ID_estado;
    String Municipio;

    public Municipio() {
    }

    public Municipio(String ID_Municipio, String Estados_ID_estado, String Municipio) {
        this.ID_Municipio = ID_Municipio;
        this.Estados_ID_estado = Estados_ID_estado;
        this.Municipio = Municipio;
    }

    public String getID_Municipio() {
        return ID_Municipio;
    }

    public void setID_Municipio(String ID_Municipio) {
        this.ID_Municipio = ID_Municipio;
    }

    public String getEstados_ID_estado() {
        return Estados_ID_estado;
    }

    public void setEstados_ID_estado(String Estados_ID_estado) {
        this.Estados_ID_estado = Estados_ID_estado;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }
    
    
    
}
