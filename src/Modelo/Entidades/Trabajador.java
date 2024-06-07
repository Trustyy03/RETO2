package Modelo.Entidades;

public class Trabajador {
    private int id;
    private String cif;
    private String nombre;
    private String apellidos;
    private String correo;
    private String cargo;
    private String telefono;

    public Trabajador(int id, String cif, String nombre, String apellidos, String correo, String cargo, String telefono) {
        this.id = id;
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cargo = cargo;
        this.telefono = telefono;
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

    public String toString(){
        return id + " " + nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefono() {
        return telefono;
    }
}
