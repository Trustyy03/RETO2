package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Trabajador;
import Modelo.Entidades.Tutor;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TutorController {
    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<Tutor> consultarTutores() {
        ArrayList<Tutor> tutores = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            String consultaTutores = "SELECT * FROM TUTOR_FCT";
            ResultSet rs = st.executeQuery(consultaTutores);

            while (rs.next()) {
                Tutor tutor =  new Tutor(rs.getInt(1), rs.getString(2), rs.getString(3));
                tutores.add(tutor);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }

        return tutores;
    }

    public static void borrarTutor(Tutor tutor) {
        try {
            Statement st = con.createStatement();
            String borrarTutor = "DELETE FROM TUTOR_FCT WHERE CIF = '" + tutor.getIdTutor() + "';";
            st.execute(borrarTutor);
            st.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}
