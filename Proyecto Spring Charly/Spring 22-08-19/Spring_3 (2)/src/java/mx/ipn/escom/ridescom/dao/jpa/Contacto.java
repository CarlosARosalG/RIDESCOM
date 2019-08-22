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
public class Contacto {
    int ID_Contact;
    int ID_tipo;
    String Valor;

    public Contacto() {
    }

    public Contacto(int ID_Contact, int ID_tipo, String Valor) {
        this.ID_Contact = ID_Contact;
        this.ID_tipo = ID_tipo;
        this.Valor = Valor;
    }

    public int getID_Contact() {
        return ID_Contact;
    }

    public void setID_Contact(int ID_Contact) {
        this.ID_Contact = ID_Contact;
    }

    public int getID_tipo() {
        return ID_tipo;
    }

    public void setID_tipo(int ID_tipo) {
        this.ID_tipo = ID_tipo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    
}
