package Modelo.Consultas;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            OperacionesConsultas.consultaUno("IT Solutions Group");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*try {
            OperacionesConsultas.consultaDos("2DAM", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaTres("2CFSF", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            OperacionesConsultas.consultaCuatro("B01234567", "23-24");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        }*/

    }

}
