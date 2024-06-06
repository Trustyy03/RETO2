package Modelo.Entidades;

public class Empresa {
    private String cif;
    private String nombre;
    private String telefono;
    private int numEmpleados;
    private String sector;
    public Empresa(String cif, String nombre, String telefono, int numEmpleados, String sector) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.numEmpleados = numEmpleados;
        this.sector = sector;
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

    @Override
    public String toString() {
        return nombre; // Puedes ajustar esto para mostrar más información si es necesario
    }
}
