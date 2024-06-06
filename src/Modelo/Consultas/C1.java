package Modelo.Consultas;


//C1. Consulta que mostre, donada una empresa, les dades d’empresa,
// professor responsable i personal de contacte d’empresa
public class C1 {
    private String nombreEmpresa;
    private String nombreTutor;
    private String nombreTrabajador;
    private String correoTrabajador;
    private String telefonoTrabajador;
    public C1(String nombreEmpresa, String nombreTutor, String nombreTrabajador, String correoTrabajador, String telefonoTrabajador) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTutor = nombreTutor;
        this.nombreTrabajador = nombreTrabajador;
        this.correoTrabajador = correoTrabajador;
        this.telefonoTrabajador = telefonoTrabajador;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getCorreoTrabajador() {
        return correoTrabajador;
    }

    public void setCorreoTrabajador(String correoTrabajador) {
        this.correoTrabajador = correoTrabajador;
    }

    public String getTelefonoTrabajador() {
        return telefonoTrabajador;
    }

    public void setTelefonoTrabajador(String telefonoTrabajador) {
        this.telefonoTrabajador = telefonoTrabajador;
    }
}
