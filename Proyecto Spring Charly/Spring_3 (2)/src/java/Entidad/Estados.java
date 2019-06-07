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
public class Estados {
    String ID_estado;
    String Homo;
    String Estado;

    public Estados() {
    }

    public Estados(String ID_estado, String Homo, String Estado) {
        this.ID_estado = ID_estado;
        this.Homo = Homo;
        this.Estado = Estado;
    }

    public String getID_estado() {
        return ID_estado;
    }

    public void setID_estado(String ID_estado) {
        this.ID_estado = ID_estado;
    }

    public String getHomo() {
        return Homo;
    }

    public void setHomo(String Homo) {
        this.Homo = Homo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
