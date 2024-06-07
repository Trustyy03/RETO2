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
        System.out.println("--------------C1--------------");
        System.out.printf("%-30s %-30s %-30s %-30s %-15s%n",
                "Nombre Empresa", "Nombre Tutor", "Nombre Trabajador", "Correo Trabajador", "Telefono Tutor");
        while (rs.next()) {
            System.out.printf("%-30s %-30s %-30s %-30s %-15s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), "\n");

        }

        pst.close();
        rs.close();
    }

    /*public static void consultaDos(String idCiclo, ) throws SQLException {
        String sql = "SELECT c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre, COUNT(*) AS NumPracticas\n" +
                "FROM EMPRESA e\n" +
                "INNER JOIN GRUPO_FCT_EMPRESA fct USING (CIF)\n" +
                "INNER JOIN GRUPO g USING (idGrupo)\n" +
                "INNER JOIN CICLO c USING (idCiclo)\n" +
                "WHERE c.idCiclo = '2DAM'\n" +
                "AND fct.cursoEscolar = '23-24'\n" +
                "GROUP BY c.idCiclo, fct.cursoEscolar, e.CIF, e.nombre;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nombreEmpresa);

        ResultSet rs = pst.executeQuery();
        System.out.println("--------------C1--------------");
        System.out.printf("%-30s %-30s %-30s %-30s %-15s%n",
                "Nombre Empresa", "Nombre Tutor", "Nombre Trabajador", "Correo Trabajador", "Telefono Tutor");
        while (rs.next()) {
            System.out.printf("%-30s %-30s %-30s %-30s %-15s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), "\n");

        }

        pst.close();
        rs.close();
    }*/

}
