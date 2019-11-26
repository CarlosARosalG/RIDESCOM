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
public class Inscribir {
    String Boleta;
    int Evento;

    public Inscribir() {
    }

    public Inscribir(String Boleta, int Evento) {
        this.Boleta = Boleta;
        this.Evento = Evento;
    }

    public String getBoleta() {
        return Boleta;
    }

    public void setBoleta(String Boleta) {
        this.Boleta = Boleta;
    }

    public int getEvento() {
        return Evento;
    }

    public void setEvento(int Evento) {
        this.Evento = Evento;
    }
    
}
