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
public class Cuenta {
    int C_ID;
    String FI;
    String FF;
    String rol;
    String Deporte;
        
    public Cuenta() {
    }

    public Cuenta(int C_ID, String FI, String FF, String rol, String Deporte) {
        this.C_ID = C_ID;
        this.FI = FI;
        this.FF = FF;
        this.rol = rol;
        this.Deporte = Deporte;
    }

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;
    }

    public String getFI() {
        return FI;
    }

    public void setFI(String FI) {
        this.FI = FI;
    }

    public String getFF() {
        return FF;
    }

    public void setFF(String FF) {
        this.FF = FF;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }
    
    
}
