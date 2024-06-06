package Modelo.Consultas;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            OperacionesConsultas.consultaUno("IT Solutions Group");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
