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
public class Sexo {
    int ID_S;
    String Sexo;

    public Sexo() {
    }

    public Sexo(int ID_S, String Sexo) {
        this.ID_S = ID_S;
        this.Sexo = Sexo;
    }

    public int getID_S() {
        return ID_S;
    }

    public void setID_S(int ID_S) {
        this.ID_S = ID_S;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    
}
