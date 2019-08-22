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
public class Evento {
    int ID;
    String Nombre_e;
    String Fecha_i_R;
    String Fecha_f_R;
    String Lugar;
    String Dir;
    String P_ref;
    String Descripción;
    String Fecha_evento;
    String Ciclo;
    String Deporte;

    public Evento() {
    }

    public Evento(int ID, String Nombre_e, String Fecha_i_R, String Fecha_f_R, String Lugar, String Dir, String P_ref, String Descripción, String Fecha_evento, String Ciclo, String Deporte) {
        this.ID = ID;
        this.Nombre_e = Nombre_e;
        this.Fecha_i_R = Fecha_i_R;
        this.Fecha_f_R = Fecha_f_R;
        this.Lugar = Lugar;
        this.Dir = Dir;
        this.P_ref = P_ref;
        this.Descripción = Descripción;
        this.Fecha_evento = Fecha_evento;
        this.Ciclo = Ciclo;
        this.Deporte = Deporte;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_e() {
        return Nombre_e;
    }

    public void setNombre_e(String Nombre_e) {
        this.Nombre_e = Nombre_e;
    }

    public String getFecha_i_R() {
        return Fecha_i_R;
    }

    public void setFecha_i_R(String Fecha_i_R) {
        this.Fecha_i_R = Fecha_i_R;
    }

    public String getFecha_f_R() {
        return Fecha_f_R;
    }

    public void setFecha_f_R(String Fecha_f_R) {
        this.Fecha_f_R = Fecha_f_R;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public String getP_ref() {
        return P_ref;
    }

    public void setP_ref(String P_ref) {
        this.P_ref = P_ref;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String Descripción) {
        this.Descripción = Descripción;
    }

    public String getFecha_evento() {
        return Fecha_evento;
    }

    public void setFecha_evento(String Fecha_evento) {
        this.Fecha_evento = Fecha_evento;
    }

    public String getCiclo() {
        return Ciclo;
    }

    public void setCiclo(String Ciclo) {
        this.Ciclo = Ciclo;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }
    
    
    
}
