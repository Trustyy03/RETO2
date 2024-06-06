package Modelo.Entidades;

public class Tutor {

    int idTutor;
    String nombre;
    String apellidos;


    public Tutor(int idTutor, String nombre, String apellidos) {
        this.idTutor = idTutor;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
