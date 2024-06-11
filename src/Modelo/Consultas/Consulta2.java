package Modelo.Consultas;

//C2. Consulta que mostre, donat un cicle formatiu (exemple 2DAM) i un curs
//les empreses que han acollit pràctiques i el nombre de pràctiques acollides.
public class Consulta2 {
    private String idCiclo;
    private String cursoEscolar;
    private String cif;
    private String nombreEmpresa;
    private int numPracticas;

    public Consulta2(String idCiclo, String cursoEscolar, String cif, String nombreEmpresa, int numPracticas) {
        this.idCiclo = idCiclo;
        this.cursoEscolar = cursoEscolar;
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.numPracticas = numPracticas;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getCursoEscolar() {
        return cursoEscolar;
    }

    public void setCursoEscolar(String cursoEscolar) {
        this.cursoEscolar = cursoEscolar;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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
        return idCiclo + " / " + cursoEscolar + " / " + cif + " / " + nombreEmpresa + " / " + numPracticas;
    }
}
