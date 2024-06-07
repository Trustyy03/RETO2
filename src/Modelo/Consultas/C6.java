package Modelo.Consultas;

//C6. Consulta que mostre, donada una empresa i un cicle en un curs escolar,
//les dades FCT sol·licitades per l’empresa a eixe cicle (ex. Crownet sol·licita
//15 alumnes de 2DAM)
public class C6 {
    private String nombreEmpresa;
    private int cantidadAlumnos;
    private String idCiclo;

    public C6(String nombreEmpresa, int cantidadAlumnos, String idCiclo) {
        this.nombreEmpresa = nombreEmpresa;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idCiclo = idCiclo;
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
