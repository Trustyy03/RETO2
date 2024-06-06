package Modelo.Consultas;

//C5. Consulta de incidències per curs.
public class C5 {
    private int idIncidencia;
    private String cif;
    private String descripcion;
    private String cursoEscolar;

    public C5(int idIncidencia, String cif, String descripcion, String cursoEscolar) {
        this.idIncidencia = idIncidencia;
        this.cif = cif;
        this.descripcion = descripcion;
        this.cursoEscolar = cursoEscolar;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public String getCif() {
        return cif;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCursoEscolar() {
        return cursoEscolar;
    }
}
