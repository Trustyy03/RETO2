package Modelo.Consultas;

//C6. Consulta de contactes per empresa i curs. -> No hemos contemplado que los contactos pertenezcan a un curso escolar
public class C6 {
    private String nombreEmpresa;
    private String nombreTrabajador;
    private String cargo;
    private String correo;
    private String telefono;

    public C6(String nombreEmpresa, String nombreTrabajador, String cargo, String correo, String telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTrabajador = nombreTrabajador;
        this.cargo = cargo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
}
