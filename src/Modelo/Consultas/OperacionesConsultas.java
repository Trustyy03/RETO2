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

}
