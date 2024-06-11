package Modelo.Consultas;

//C3. Consulta que mostre, donat un grup (2DAM-2CFSF) i un curs, les dades
//del professor tutor del grup i les empreses amb FCT’s i el nombre d’estes.

//Aqui hay problemilla, dice grupo y curso pero para nosotros es ciclo-grupo y curso.

public class C3 {
    private String idGrupo;
    private String nombreTutor;
    private String nombreEmpresa;
    private int numPracticas;

    public C3(String idGrupo, String nombreTutor, String nombreEmpresa, int numPracticas) {
        this.idGrupo = idGrupo;
        this.nombreTutor = nombreTutor;
        this.nombreEmpresa = nombreEmpresa;
        this.numPracticas = numPracticas;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNumPracticas() {
        return numPracticas;
    }

    public void setNumPracticas(int numPracticas) {
        this.numPracticas = numPracticas;
    }

    @Override
    public String toString() {
        return idGrupo + " / " + nombreTutor + " / " + nombreEmpresa + " / " + numPracticas;
    }
}
