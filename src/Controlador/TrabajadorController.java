package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Trabajador;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrabajadorController {
    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<Trabajador> consultarTrabajadores() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            String consultaTrabajadores = "SELECT * FROM TRABAJADORES_INTERES";
            ResultSet rs = st.executeQuery(consultaTrabajadores);

            while (rs.next()) {
                Trabajador trabajador =  new Trabajador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                trabajadores.add(trabajador);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }

        return trabajadores;
    }
}
