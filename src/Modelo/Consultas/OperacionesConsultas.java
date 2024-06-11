package Modelo.Consultas;

import Modelo.ConexionBDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OperacionesConsultas {

    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static C1 consultaUno(String nombreEmpresa) throws SQLException {
        String sql = "SELECT e.nombre, CONCAT(t.nombre, ' ', t.apellidos) as nombre_tutor, CONCAT(ti.nombre, ' ', ti.apellidos) as nombre_trabajador, ti.correo, ti.telefono\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN TUTOR_RESPONSABLE_EMPRESA tre on e.CIF = tre.CIF\n" +
                "INNER JOIN TUTOR_FCT t on tre.idTutor = t.idTutor\n" +
                "INNER JOIN TRABAJADORES_INTERES ti on e.CIF = ti.CIF\n" +
                "WHERE e.nombre = ?;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);

        ResultSet rs = pst.executeQuery();

        C1 consulta1 = null;
        while (rs.next()) {
            consulta1 = new C1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        pst.close();
        rs.close();
        return consulta1;
    }

    public static ArrayList<C2> consultaDos(String ciclo, String cursoEscolar) throws SQLException {
        ArrayList<C2> listaResultados = new ArrayList<>();

        String sql = "SELECT c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre, COUNT(*) AS NumPracticas\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA fct USING (CIF)\n" +
                "INNER JOIN GRUPO g USING (idGrupo)\n" +
                "INNER JOIN CICLO c USING (idCiclo)\n" +
                "WHERE c.idCiclo = ?\n" + // ej. '1DAM' o '2DAM'
                "AND fct.cursoEscolar = ?\n" + // ej. '22-23' o '23-24'
                "GROUP BY c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre;";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, ciclo);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C2 consulta2 = new C2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            listaResultados.add(consulta2);
        }

        pst.close();
        rs.close();
        return listaResultados;

    }

    public static ArrayList<C3> consultaTres(String grupo, String cursoEscolar) throws SQLException {
        ArrayList<C3> listaResultados = new ArrayList<>();

        String sql = "SELECT g.idCiclo, g.idGrupo, CONCAT(t.Nombre, ' ', t.Apellidos) AS nombreTutor, e.Nombre AS nombreEmpresa, COUNT(*) AS NumPracticas\n" +
                "FROM GRUPO g\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA gfe ON g.idGrupo = gfe.idGrupo\n" +
                "INNER JOIN EMPRESA e ON gfe.CIF = e.CIF\n" +
                "INNER JOIN TUTOR_RESPONSABLE_GRUPO trg ON g.idGrupo = trg.idGrupo\n" +
                "INNER JOIN TUTOR_FCT t ON trg.idTutor = t.idTutor\n" +
                "WHERE g.idGrupo = ?\n" +
                "AND gfe.cursoEscolar = ?\n" +
                "GROUP BY g.idCiclo, g.idGrupo, t.Nombre, t.Apellidos, e.Nombre;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, grupo);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();


        while (rs.next()) {
            C3 consulta3 = new C3(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            listaResultados.add(consulta3);
        }

        pst.close();
        rs.close();

        return listaResultados;
    }

    public static ArrayList<C4> consultaCuatro(String nombreEmpresa, String cursoEscolar) throws SQLException {
        ArrayList<C4> listaResultados = new ArrayList<>();

        String sql = "SELECT e.nombre, fct.cursoEscolar, fct.idGrupo, fct.numAlumnos\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA fct using(CIF)\n" +
                "WHERE e.nombre = ?\n" + // IT solutions
                "AND fct.cursoEscolar = ?;"; // 23-24

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C4 consulta4 = new C4(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            listaResultados.add(consulta4);
        }

        pst.close();
        rs.close();

        return listaResultados;
    }

    public static ArrayList<C5> consultaCinco(String cursoEscolar) {
        ArrayList<C5> listaResultados = new ArrayList<>();

        String sql = "SELECT i.idIncidencia, i.CIF, e.nombre, i.descripcion\n" +
                "FROM INCIDENCIA i\n" +
                "JOIN EMPRESA e using(CIF)\n" +
                "WHERE cursoEscolar = ?;"; // ej. '23-24'

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cursoEscolar);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                C5 consulta5 = new C5(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listaResultados.add(consulta5);
            }
            pst.close();
            rs.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return listaResultados;
    }

    public static ArrayList<C6> consultaSeis(String nombreEmpresa, String idCiclo, String cursoEscolar) throws SQLException {
        ArrayList<C6> listaResultados = new ArrayList<>();
        String sql = "SELECT e.CIF, e.nombre as 'nombreEmpresa', enc.cantidadAlumnos, c.idCiclo\n" +
                "FROM CICLO c\n" +
                "INNER JOIN EMPRESA_NECESITA_CICLO enc using(idCiclo)\n" +
                "INNER JOIN EMPRESA e using(CIF)\n" +
                "WHERE e.nombre = ?\n" +
                "AND enc.idCiclo = ?\n" +
                "AND enc.cursoEscolar = ?;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);
        pst.setString(2, idCiclo);
        pst.setString(3, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C6 consulta6 = new C6(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            listaResultados.add(consulta6);
        }

        pst.close();
        rs.close();

        return listaResultados;
    }

    public static ArrayList<C7> consultaSiete(String tecnologia) {
        ArrayList<C7> listaResultados = new ArrayList<>();
        String sql = "SELECT eut.idTecnologia, e.nombre, e.CIF\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN EMPRESA_USA_TECNOLOGIA eut using(CIF)\n" +
                "WHERE eut.idTecnologia = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tecnologia);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                C7 consulta7 = new C7(rs.getString(1), rs.getString(2), rs.getString(3));
                listaResultados.add(consulta7);
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaResultados;
    }

    public static ArrayList<C8> consultaOcho(String nombreEmpresa) {
        ArrayList<C8> listaResultados = new ArrayList<>();

        String sql = "SELECT e.nombre, CONCAT(t.nombre, ' ', t.apellidos) as nombreTutor, c.descripcion, c.fecha\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN TUTOR_CONTACTA_EMPRESA c using(CIF)\n" +
                "INNER JOIN TUTOR_FCT t using(idTutor)\n" +
                "WHERE e.nombre = ?;";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombreEmpresa);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                C8 consulta8 = new C8(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                listaResultados.add(consulta8);
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaResultados;
    }



}
