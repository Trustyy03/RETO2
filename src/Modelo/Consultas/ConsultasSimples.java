package Modelo.Consultas;

import Modelo.ConexionBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultasSimples {

    private static java.sql.Connection con = ConexionBDD.getInstance().getConnection();
    private static ArrayList<String> cursosEscolares;
    private static ArrayList<String> ciclos;
    private static ArrayList<String> grupos;
    private static ArrayList<String> empresas;
    private static ArrayList<String> tecnologias;

    public static ArrayList<String> consultarCursos() {
        String sql = "SELECT cursoEscolar FROM TUTOR_RESPONSABLE_GRUPO GROUP BY cursoEscolar;";

        if(con != null){
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
        } else {
            cursosEscolares = new ArrayList<>();
            System.out.println("Conexión no disponible en consultar Cursos");
        }


        return cursosEscolares;
    }

    public static ArrayList<String> consultarCiclos() {
        String sql = "SELECT idCiclo FROM GRUPO GROUP BY idCiclo;";
        if(con != null){
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
        } else {
            ciclos = new ArrayList<>();
            System.out.println("Conexión no disponible en consultar Ciclos");
        }


        return ciclos;
    }

    public static ArrayList<String> consultarGrupos() {
        String sql = "SELECT idGrupo FROM GRUPO;";
        if(con != null){
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
        } else {
            grupos = new ArrayList<>();
            System.out.println("Conexión no disponible en consultar Grupos");
        }
        return grupos;
    }

    public static ArrayList<String> consultarNombresEmpresas() {
        String sql = "SELECT nombre FROM EMPRESA;";
        if(con != null){
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
        } else {
            empresas = new ArrayList<>();
            System.out.println("Conexión no disponible en consultar Nombre Empresas");
        }
        return empresas;
    }

    public static ArrayList<String> consultarTecnologias() {
        String sql = "SELECT idTecnologia FROM TECNOLOGIA;";
        if(con != null){
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
        } else {
            tecnologias = new ArrayList<>();
            System.out.println("Conexión no disponible en consultar Tecnologias");
        }
        return tecnologias;
    }
}
