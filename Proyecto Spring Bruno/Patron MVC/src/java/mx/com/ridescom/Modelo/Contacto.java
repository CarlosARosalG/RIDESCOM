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
public class Contacto {
    int ID;
    String Pers;
    String Tipo;
    String Valor;

    public Contacto() {
    }

    public Contacto(int ID, String Pers, String Tipo, String Valor) {
        this.ID = ID;
        this.Pers = Pers;
        this.Tipo = Tipo;
        this.Valor = Valor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPers() {
        return Pers;
    }

    public void setPers(String Pers) {
        this.Pers = Pers;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    
}
