package Modelo.Consultas;

//C4. Consulta que mostre donada una empresa i un curs les dades d’FCT
//(grups, alumnes ..)
public class C4 {
    private String nombreEmpresa;
    private String cursoEscolar;
    private String idGrupo;
    private int numAlumnos;

    public C4(String nombreEmpresa, String cursoEscolar, String idGrupo, int numAlumnos) {
        this.nombreEmpresa = nombreEmpresa;
        this.cursoEscolar = cursoEscolar;
        this.idGrupo = idGrupo;
        this.numAlumnos = numAlumnos;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCursoEscolar() {
        return cursoEscolar;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }
}
