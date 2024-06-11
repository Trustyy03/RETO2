package Modelo.Consultas;

//C8. Consulta de l’historial de contactes per empresa
public class Consulta8 {
    private String nombreEmpresa;
    private String nombreTutor;
    private String descripcion;
    private String fecha;

    public Consulta8(String nombreEmpresa, String nombreTutor, String descripcion, String fecha) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTutor = nombreTutor;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return nombreEmpresa + " / " + nombreTutor + " / " + descripcion + " / " + fecha;
    }
}
