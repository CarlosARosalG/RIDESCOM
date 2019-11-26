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
public class Deporte {
    int ID_Dep;
    String Disciplina;

    public Deporte() {
    }

    public Deporte(int ID_Dep, String Disciplina) {
        this.ID_Dep = ID_Dep;
        this.Disciplina = Disciplina;
    }

    public int getID_Dep() {
        return ID_Dep;
    }

    public void setID_Dep(int ID_Dep) {
        this.ID_Dep = ID_Dep;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }
    
    
    
}
