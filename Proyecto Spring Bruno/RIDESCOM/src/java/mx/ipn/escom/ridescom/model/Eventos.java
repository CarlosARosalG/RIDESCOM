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
public class Eventos {
    
    int E_ID;
    String Nombre_E;
    String FIR;
    String FFR;
    String Lugar;
    String Dir;
    String P_Ref;
    String Desc;
    String FE;
    String ciclo;
    String deporte;
    
    public Eventos() {
    }

    public Eventos(int E_ID, String Nombre_E, String FIR, String FFR, String Lugar, String Dir, String P_Ref, String Desc, String FE, String ciclo, String deporte) {
        this.E_ID = E_ID;
        this.Nombre_E = Nombre_E;
        this.FIR = FIR;
        this.FFR = FFR;
        this.Lugar = Lugar;
        this.Dir = Dir;
        this.P_Ref = P_Ref;
        this.Desc = Desc;
        this.FE = FE;
        this.ciclo = ciclo;
        this.deporte = deporte;
    }

    public int getE_ID() {
        return E_ID;
    }

    public void setE_ID(int E_ID) {
        this.E_ID = E_ID;
    }

    public String getNombre_E() {
        return Nombre_E;
    }

    public void setNombre_E(String Nombre_E) {
        this.Nombre_E = Nombre_E;
    }

    public String getFIR() {
        return FIR;
    }

    public void setFIR(String FIR) {
        this.FIR = FIR;
    }

    public String getFFR() {
        return FFR;
    }

    public void setFFR(String FFR) {
        this.FFR = FFR;
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

    public String getP_Ref() {
        return P_Ref;
    }

    public void setP_Ref(String P_Ref) {
        this.P_Ref = P_Ref;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getFE() {
        return FE;
    }

    public void setFE(String FE) {
        this.FE = FE;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    
    
}
