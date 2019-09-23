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
public class Evento {
    int Evento_ID;
    String Nombre_Evento;
    String Fecha_inicio_Registro;
    String Fecha_fin_Registro;
    String Lugar_del_evento;
    String Descripcion;
    String Fecha_Evento;
    String Ciclo_ID_Ciclo;
    String Act_Deportiva_ID_Deporte;

    public Evento() {
    }

    public Evento(int Evento_ID, String Nombre_Evento, String Fecha_inicio_Registro, String Fecha_fin_Registro, String Lugar_del_evento, String Descripcion, String Fecha_Evento, String Ciclo_ID_Ciclo, String Act_Deportiva_ID_Deporte) {
        this.Evento_ID = Evento_ID;
        this.Nombre_Evento = Nombre_Evento;
        this.Fecha_inicio_Registro = Fecha_inicio_Registro;
        this.Fecha_fin_Registro = Fecha_fin_Registro;
        this.Lugar_del_evento = Lugar_del_evento;
        this.Descripcion = Descripcion;
        this.Fecha_Evento = Fecha_Evento;
        this.Ciclo_ID_Ciclo = Ciclo_ID_Ciclo;
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }

    public int getEvento_ID() {
        return Evento_ID;
    }

    public void setEvento_ID(int Evento_ID) {
        this.Evento_ID = Evento_ID;
    }

    public String getNombre_Evento() {
        return Nombre_Evento;
    }

    public void setNombre_Evento(String Nombre_Evento) {
        this.Nombre_Evento = Nombre_Evento;
    }

    public String getFecha_inicio_Registro() {
        return Fecha_inicio_Registro;
    }

    public void setFecha_inicio_Registro(String Fecha_inicio_Registro) {
        this.Fecha_inicio_Registro = Fecha_inicio_Registro;
    }

    public String getFecha_fin_Registro() {
        return Fecha_fin_Registro;
    }

    public void setFecha_fin_Registro(String Fecha_fin_Registro) {
        this.Fecha_fin_Registro = Fecha_fin_Registro;
    }

    public String getLugar_del_evento() {
        return Lugar_del_evento;
    }

    public void setLugar_del_evento(String Lugar_del_evento) {
        this.Lugar_del_evento = Lugar_del_evento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_Evento() {
        return Fecha_Evento;
    }

    public void setFecha_Evento(String Fecha_Evento) {
        this.Fecha_Evento = Fecha_Evento;
    }

    public String getCiclo_ID_Ciclo() {
        return Ciclo_ID_Ciclo;
    }

    public void setCiclo_ID_Ciclo(String Ciclo_ID_Ciclo) {
        this.Ciclo_ID_Ciclo = Ciclo_ID_Ciclo;
    }

    public String getAct_Deportiva_ID_Deporte() {
        return Act_Deportiva_ID_Deporte;
    }

    public void setAct_Deportiva_ID_Deporte(String Act_Deportiva_ID_Deporte) {
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }
    
    
    
}
