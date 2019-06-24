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
public class Deporte {
    int ID_Deporte;
    String Disciplina;

    public Deporte() {
    }

    public int getID_Deporte() {
        return ID_Deporte;
    }

    public void setID_Deporte(int ID_Deporte) {
        this.ID_Deporte = ID_Deporte;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }

    public Deporte(int ID_Deporte, String Disciplina) {
        this.ID_Deporte = ID_Deporte;
        this.Disciplina = Disciplina;
    }
    
    
}
