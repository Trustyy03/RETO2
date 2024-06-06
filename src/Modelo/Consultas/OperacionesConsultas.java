package Modelo.Consultas;

import Controlador.ConexionBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesConsultas {

    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static void consultaUno() throws SQLException {
        Statement st = con.createStatement();

        String sqlCodigosPais = "SELECT * FROM pais";
        ResultSet rs = st.executeQuery(sqlCodigosPais);
        System.out.println("--------------PAÍSES--------------");
        System.out.print("Código \t");
        System.out.println("Nombre\t");
        while (rs.next()) {
            System.out.printf("%-6d\t%s\n", rs.getInt(1), rs.getString(2));
        }
        st.close();
        rs.close();
    }

}
