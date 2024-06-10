package Modelo.Consultas;

import Modelo.ConexionBDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionesConsultas {

    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static void consultaUno(String nombreEmpresa) throws SQLException {
        String sql = "SELECT e.nombre, CONCAT(t.nombre, ' ', t.apellidos) as nombre_tutor, CONCAT(ti.nombre, ' ', ti.apellidos) as nombre_trabajador, ti.correo, ti.telefono\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN TUTOR_RESPONSABLE_EMPRESA tre on e.CIF = tre.CIF\n" +
                "INNER JOIN TUTOR_FCT t on tre.idTutor = t.idTutor\n" +
                "INNER JOIN TRABAJADORES_INTERES ti on e.CIF = ti.CIF\n" +
                "WHERE e.nombre = ?;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C1 consulta1 = new C1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            System.out.println(consulta1.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaDos(String cicloFormativo, String cursoEscolar) throws SQLException {
        String sql = "SELECT c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre, COUNT(*) AS NumPracticas\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA fct USING (CIF)\n" +
                "INNER JOIN GRUPO g USING (idGrupo)\n" +
                "INNER JOIN CICLO c USING (idCiclo)\n" +
                "WHERE c.idCiclo = ?\n" + // ej. '1DAM' o '2DAM'
                "AND fct.cursoEscolar = ?\n" + // ej. '22-23' o '23-24'
                "GROUP BY c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cicloFormativo);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C2 consulta2 = new C2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            System.out.println(consulta2.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaTres(String grupo, String cursoEscolar) throws SQLException {
        String sql = "SELECT g.idGrupo, CONCAT(t.Nombre, ' ', t.Apellidos) AS nombreTutor, e.Nombre AS nombreEmpresa, COUNT(*) AS NumPracticas\n" +
                "FROM GRUPO g\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA gfe ON g.idGrupo = gfe.idGrupo\n" +
                "INNER JOIN EMPRESA e ON gfe.CIF = e.CIF\n" +
                "INNER JOIN TUTOR_RESPONSABLE_GRUPO trg ON g.idGrupo = trg.idGrupo\n" +
                "INNER JOIN TUTOR_FCT t ON trg.idTutor = t.idTutor\n" +
                "WHERE g.idGrupo = ?\n" + // ej. 2CFSF
                "AND gfe.cursoEscolar = ?\n" + // ej. 23-24
                "GROUP BY g.idGrupo, t.Nombre, t.Apellidos, e.Nombre;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, grupo);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C3 consulta3 = new C3(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            System.out.println(consulta3.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaCuatro(String cifEmpresa, String cursoEscolar) throws SQLException {
        String sql = "SELECT e.nombre, fct.cursoEscolar, fct.idGrupo, fct.numAlumnos\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA fct using(CIF)\n" +
                "WHERE e.CIF = ?\n" + // B01234567
                "AND fct.cursoEscolar = ?;"; // 23-24

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cifEmpresa);
        pst.setString(2, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C4 consulta4 = new C4(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            System.out.println(consulta4.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaCinco(String cursoEscolar) throws SQLException {
        String sql = "SELECT *\n" +
                "FROM INCIDENCIA\n" +
                "WHERE cursoEscolar = ?;"; // ej. '23-24'

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cursoEscolar);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C5 consulta5 = new C5(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            System.out.println(consulta5.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaSeis(String nombreEmpresa, String idCiclo) throws SQLException {
        String sql = "SELECT e.nombre as 'nombreEmpresa', enc.cantidadAlumnos, c.idCiclo \n" +
                "FROM CICLO c \n" +
                "INNER JOIN EMPRESA_NECESITA_CICLO enc using(idCiclo)\n" +
                "INNER JOIN EMPRESA e using(CIF)\n" +
                "WHERE e.nombre = ?\n" + // ej. 'IT Solutions Group'
                "AND enc.idCiclo = ?\n" + // ej. '1ADFI'
                "AND enc.cursoEscolar = '23-24';";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);
        pst.setString(2, idCiclo);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C6 consulta6 = new C6(rs.getString(1), rs.getInt(2), rs.getString(3));
            System.out.println(consulta6.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaSiete(String tecnologia) throws SQLException {
        String sql = "SELECT eut.idTecnologia, e.nombre, e.CIF\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN EMPRESA_USA_TECNOLOGIA eut using(CIF)\n" +
                "WHERE eut.idTecnologia = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tecnologia);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C7 consulta7 = new C7(rs.getString(1), rs.getString(2), rs.getString(3));
            System.out.println(consulta7.toString());
        }

        pst.close();
        rs.close();
    }

    public static void consultaOcho(String cifEmpresa) throws SQLException {
        String sql = "SELECT e.nombre, CONCAT(t.nombre, ' ', t.apellidos) as nombreTutor, c.descripcion, c.fecha\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN TUTOR_CONTACTA_EMPRESA c using(CIF)\n" +
                "INNER JOIN TUTOR_FCT t using(idTutor)\n" +
                "WHERE e.CIF = ?;"; // ej. B01234567

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, cifEmpresa);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            C8 consulta8 = new C8(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            System.out.println(consulta8.toString());
        }

        pst.close();
        rs.close();
    }



}
