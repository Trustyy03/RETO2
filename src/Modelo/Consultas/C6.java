package Modelo.Consultas;

//C6. Consulta que mostre, donada una empresa i un cicle en un curs escolar,
//les dades FCT sol·licitades per l’empresa a eixe cicle (ex. Crownet sol·licita
//15 alumnes de 2DAM)
public class C6 {
    private String cifEmpresa;
    private String nombreEmpresa;
    private int cantidadAlumnos;
    private String idCiclo;

    public C6(String cifEmpresa, String nombreEmpresa, int cantidadAlumnos, String idCiclo) {
        this.cifEmpresa = cifEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idCiclo = idCiclo;
    }

    public String getCifEmpresa() {
        return cifEmpresa;
    }

    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    @Override
    public String toString() {
        return nombreEmpresa + " / " + cantidadAlumnos + " / " + idCiclo;
    }
}
