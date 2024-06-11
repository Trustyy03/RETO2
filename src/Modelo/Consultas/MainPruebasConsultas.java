package Modelo.Consultas;

import java.sql.SQLException;

public class MainPruebasConsultas {
    public static void main(String[] args) throws SQLException {

        //los métodos ya no funcionarán porqué ya no devuelven texto, hay que cambiar las pruebas

        /*try {
            OperacionesConsultas.consultaUno("IT Solutions Group");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaDos("1DAM", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaTres("2CFSF", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        */try {
            OperacionesConsultas.consultaCuatro("B01234567", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
/*
        try {
            OperacionesConsultas.consultaCinco("23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaSeis("Innovatech Solutions", "1ADFI");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaSiete("Blockchain");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaOcho("B01234567");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        /*CCiclosYCursos.consultarCursos();
        CCiclosYCursos.consultarCiclos();*/


    }

}
