package Modelo.Entidades;

public class Empresa {
    private String cif;
    private String nombre;
    private String telefono;
    private int numEmpleados;
    private String sector;
    private String direccion;
    public Empresa(String cif, String nombre, String telefono, int numEmpleados, String sector,String direccion) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.numEmpleados = numEmpleados;
        this.sector = sector;
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public String getSector() {
        return sector;
    }

    public String getDireccion(){return direccion;}
    @Override
    public String toString() {
        return cif + " - " + nombre; // Puedes ajustar esto para mostrar más información si es necesario
    }
}
