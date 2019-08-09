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
public class Contacto {
    int ID_Contacto;
    int Persona_ID_Persona;
    int Tipo_Contacto_ID_Contacto;
    String Valor;
    String Tel;

    public Contacto() {
    }

    public Contacto(int ID_Contacto, int Persona_ID_Persona, int Tipo_Contacto_ID_Contacto, String Valor) {
        this.ID_Contacto = ID_Contacto;
        this.Persona_ID_Persona = Persona_ID_Persona;
        this.Tipo_Contacto_ID_Contacto = Tipo_Contacto_ID_Contacto;
        this.Valor = Valor;
        this.Tel = Tel;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public int getID_Contacto() {
        return ID_Contacto;
    }

    public void setID_Contacto(int ID_Contacto) {
        this.ID_Contacto = ID_Contacto;
    }

    public int getPersona_ID_Persona() {
        return Persona_ID_Persona;
    }

    public void setPersona_ID_Persona(int Persona_ID_Persona) {
        this.Persona_ID_Persona = Persona_ID_Persona;
    }

    public int getTipo_Contacto_ID_Contacto() {
        return Tipo_Contacto_ID_Contacto;
    }

    public void setTipo_Contacto_ID_Contacto(int Tipo_Contacto_ID_Contacto) {
        this.Tipo_Contacto_ID_Contacto = Tipo_Contacto_ID_Contacto;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    
}
