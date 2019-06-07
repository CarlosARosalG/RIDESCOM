/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author spy51
 */
public class Pruebas {
    int ID_Pruebas;
    String Prueba;
    String Tipo_Prueba_ID_Prueba;
    String Act_Deportiva_ID_Deporte;

    public Pruebas() {
    }

    public Pruebas(int ID_Pruebas, String Prueba, String Tipo_Prueba_ID_Prueba, String Act_Deportiva_ID_Deporte) {
        this.ID_Pruebas = ID_Pruebas;
        this.Prueba = Prueba;
        this.Tipo_Prueba_ID_Prueba = Tipo_Prueba_ID_Prueba;
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }

    public int getID_Pruebas() {
        return ID_Pruebas;
    }

    public void setID_Pruebas(int ID_Pruebas) {
        this.ID_Pruebas = ID_Pruebas;
    }

    public String getPrueba() {
        return Prueba;
    }

    public void setPrueba(String Prueba) {
        this.Prueba = Prueba;
    }

    public String getTipo_Prueba_ID_Prueba() {
        return Tipo_Prueba_ID_Prueba;
    }

    public void setTipo_Prueba_ID_Prueba(String Tipo_Prueba_ID_Prueba) {
        this.Tipo_Prueba_ID_Prueba = Tipo_Prueba_ID_Prueba;
    }

    public String getAct_Deportiva_ID_Deporte() {
        return Act_Deportiva_ID_Deporte;
    }

    public void setAct_Deportiva_ID_Deporte(String Act_Deportiva_ID_Deporte) {
        this.Act_Deportiva_ID_Deporte = Act_Deportiva_ID_Deporte;
    }
    
    
    
}
