/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.ritescom.entidad;

/**
 *
 * @author spy51
 */
public class Evento {
    int ID;
    String Nombre_E;
    String Fecha_in;
    String Fecha_fin;
    String Lugar;
    String Descripcion;
    String Fecha_E;
    String Ciclo_;
    String Act_Deportiva_ID_Deporte;

    public Evento() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_E() {
        return Nombre_E;
    }

    public void setNombre_E(String Nombre_E) {
        this.Nombre_E = Nombre_E;
    }

    public String getFecha_in() {
        return Fecha_in;
    }

    public void setFecha_in(String Fecha_in) {
        this.Fecha_in = Fecha_in;
    }

    public String getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(String Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_E() {
        return Fecha_E;
    }

    public void setFecha_E(String Fecha_E) {
        this.Fecha_E = Fecha_E;
    }

    public String getCiclo_() {
        return Ciclo_;
    }

    public void setCiclo_(String Ciclo_) {
        this.Ciclo_ = Ciclo_;
    }

    public String getAct_Deportiva_ID_Deporte() {
        return Act_Deportiva_ID_Deporte;
    }

    public void setAct_Deportiva_ID_Deporte(String Act_Deportiva_ID_Deporte) {
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }

    public Evento(int ID, String Nombre_E, String Fecha_in, String Fecha_fin, String Lugar, String Descripcion, String Fecha_E, String Ciclo_, String Act_Deportiva_ID_Deporte) {
        this.ID = ID;
        this.Nombre_E = Nombre_E;
        this.Fecha_in = Fecha_in;
        this.Fecha_fin = Fecha_fin;
        this.Lugar = Lugar;
        this.Descripcion = Descripcion;
        this.Fecha_E = Fecha_E;
        this.Ciclo_ = Ciclo_;
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }
    
    
}
