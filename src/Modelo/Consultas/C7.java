package Modelo.Consultas;

//C7. Consulta de empreses per tipus de tecnologia.
public class C7 {
    private String idTecnologia;
    private String nombreEmpresa;
    private String cif;

    public C7(String idTecnologia, String nombreEmpresa, String cif) {
        this.idTecnologia = idTecnologia;
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
    }

    public String getIdTecnologia() {
        return idTecnologia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    @Override
    public String toString() {
        return idTecnologia + " / " + nombreEmpresa + " / " + cif;
    }
}
