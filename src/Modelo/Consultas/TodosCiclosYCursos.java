package Modelo.Consultas;

import Modelo.ConexionBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TodosCiclosYCursos {

    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();
    public static ArrayList<String> cursosEscolares;
    public static ArrayList<String> ciclos;

    public static ArrayList<String> consultarCursos() throws SQLException {
        String sql = "SELECT cursoEscolar FROM TUTOR_RESPONSABLE_GRUPO GROUP BY cursoEscolar;";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);

        cursosEscolares = new ArrayList<>();

        while (rs.next()) {
            cursosEscolares.add(rs.getString(1));
        }
        //System.out.println(cursosEscolares);


        st.close();
        rs.close();
        return cursosEscolares;
    }

    public static ArrayList<String> consultarCiclos() throws SQLException {
        String sql = "SELECT idCiclo FROM GRUPO GROUP BY idCiclo;";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);

        ciclos = new ArrayList<>();

        while (rs.next()) {
            ciclos.add(rs.getString(1));
        }

        st.close();
        rs.close();
        return ciclos;
    }

}
