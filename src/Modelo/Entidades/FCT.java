package Modelo.Entidades;

public class FCT {
    private String cif;
    private String idGrupo;
    private String cursoEscolar;
    private int numAlumnos;
    public FCT(String cif, String idGrupo, String cursoEscolar, int numAlumnos) {
        this.cif = cif;
        this.idGrupo = idGrupo;
        this.cursoEscolar = cursoEscolar;
        this.numAlumnos = numAlumnos;
    }

    public String getCif() {
        return cif;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public String getCursoEscolar() {
        return cursoEscolar;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }
}
