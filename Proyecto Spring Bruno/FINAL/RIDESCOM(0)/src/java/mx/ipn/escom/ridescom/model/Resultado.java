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
public class Resultado {
    int ID_Resultado;
    String Posicion;
    String Marca;
    String Boleta;
    int Ev_ID;

    public Resultado() {
    }

    public Resultado(int ID_Resultado, String Posicion, String Marca, String Boleta, int Ev_ID) {
        this.ID_Resultado = ID_Resultado;
        this.Posicion = Posicion;
        this.Marca = Marca;
        this.Boleta = Boleta;
        this.Ev_ID = Ev_ID;
    }

    public int getID_Resultado() {
        return ID_Resultado;
    }

    public void setID_Resultado(int ID_Resultado) {
        this.ID_Resultado = ID_Resultado;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getBoleta() {
        return Boleta;
    }

    public void setBoleta(String Boleta) {
        this.Boleta = Boleta;
    }

    public int getEv_ID() {
        return Ev_ID;
    }

    public void setEv_ID(int Ev_ID) {
        this.Ev_ID = Ev_ID;
    }
    
    
    
}
