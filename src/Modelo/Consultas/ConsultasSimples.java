package Modelo.Consultas;

import Modelo.ConexionBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultasSimples {

    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();
    public static ArrayList<String> cursosEscolares;
    public static ArrayList<String> ciclos;
    public static ArrayList<String> grupos;
    public static ArrayList<String> empresas;
    public static ArrayList<String> tecnologias;

    public static ArrayList<String> consultarCursos() {
        String sql = "SELECT cursoEscolar FROM TUTOR_RESPONSABLE_GRUPO GROUP BY cursoEscolar;";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cursosEscolares = new ArrayList<>();

            while (rs.next()) {
                cursosEscolares.add(rs.getString(1));
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cursosEscolares;
    }

    public static ArrayList<String> consultarCiclos() {
        String sql = "SELECT idCiclo FROM GRUPO GROUP BY idCiclo;";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ciclos = new ArrayList<>();

            while (rs.next()) {
                ciclos.add(rs.getString(1));
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ciclos;
    }

    public static ArrayList<String> consultarGrupos() {
        String sql = "SELECT idGrupo FROM GRUPO;";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            grupos = new ArrayList<>();

            while (rs.next()) {
                grupos.add(rs.getString(1));
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return grupos;
    }

    public static ArrayList<String> consultarNombresEmpresas() {
        String sql = "SELECT nombre FROM EMPRESA;";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            empresas = new ArrayList<>();

            while (rs.next()) {
                empresas.add(rs.getString(1));
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return empresas;
    }

    public static ArrayList<String> consultarTecnologias() {
        String sql = "SELECT idTecnologia FROM TECNOLOGIA;";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tecnologias = new ArrayList<>();

            while (rs.next()) {
                tecnologias.add(rs.getString(1));
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tecnologias;
    }



}
