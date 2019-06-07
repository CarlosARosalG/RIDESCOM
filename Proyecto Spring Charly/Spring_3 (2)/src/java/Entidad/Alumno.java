
package Entidad;

public class Alumno {
    int ID_Alumno;
    String Numero_Boleta;
    String Persona_ID_Persona;
    String Escuela_has_Prog_Academico_Escuela_ID_Escuela;
    String Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico;

    public Alumno() {
    }

    public Alumno(int ID_Alumno, String Numero_Boleta, String Persona_ID_Persona, String Escuela_has_Prog_Academico_Escuela_ID_Escuela, String Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) {
        this.ID_Alumno = ID_Alumno;
        this.Numero_Boleta = Numero_Boleta;
        this.Persona_ID_Persona = Persona_ID_Persona;
        this.Escuela_has_Prog_Academico_Escuela_ID_Escuela = Escuela_has_Prog_Academico_Escuela_ID_Escuela;
        this.Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico = Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico;
    }

    public int getID_Alumno() {
        return ID_Alumno;
    }

    public void setID_Alumno(int ID_Alumno) {
        this.ID_Alumno = ID_Alumno;
    }

    public String getNumero_Boleta() {
        return Numero_Boleta;
    }

    public void setNumero_Boleta(String Numero_Boleta) {
        this.Numero_Boleta = Numero_Boleta;
    }

    public String getPersona_ID_Persona() {
        return Persona_ID_Persona;
    }

    public void setPersona_ID_Persona(String Persona_ID_Persona) {
        this.Persona_ID_Persona = Persona_ID_Persona;
    }

    public String getEscuela_has_Prog_Academico_Escuela_ID_Escuela() {
        return Escuela_has_Prog_Academico_Escuela_ID_Escuela;
    }

    public void setEscuela_has_Prog_Academico_Escuela_ID_Escuela(String Escuela_has_Prog_Academico_Escuela_ID_Escuela) {
        this.Escuela_has_Prog_Academico_Escuela_ID_Escuela = Escuela_has_Prog_Academico_Escuela_ID_Escuela;
    }

    public String getEscuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico() {
        return Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico;
    }

    public void setEscuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico(String Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico) {
        this.Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico = Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico;
    }

    
}       

