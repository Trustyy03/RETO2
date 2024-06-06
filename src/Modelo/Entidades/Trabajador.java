package Modelo.Entidades;

public class Trabajador {
    private int id;
    private String cif;
    private String nombre;
    private String apellidos;
    private String correo;
    public Trabajador(int id, String cif, String nombre, String apellidos, String correo) {
        this.id = id;
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }
}
