package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Trabajador;
import Modelo.Entidades.Tutor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TutorController {
    public static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<Tutor> consultarTutores() {
        ArrayList<Tutor> tutores = new ArrayList<>();
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return tutores;
        }
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
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return;
        }
        try {
            Statement st = con.createStatement();
            String borrarTutor = "DELETE FROM TUTOR_FCT WHERE idTutor = '" + tutor.getIdTutor() + "';";
            st.execute(borrarTutor);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","Tutor eliminado",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static void modificarTutor(Tutor tutorNuevo, Tutor tutorViejo) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return;
        }
        try {
            String modificarTutor = "UPDATE TUTOR_FCT SET nombre = ?, apellido = ?, idTutor = ? WHERE idTutor = ?;";
            PreparedStatement pst = con.prepareStatement(modificarTutor);
            pst.setString(1, tutorNuevo.getNombre());
            pst.setString(2, tutorNuevo.getApellidos());
            pst.setInt(3, tutorNuevo.getIdTutor());
            pst.setInt(4, tutorViejo.getIdTutor());
            pst.executeUpdate(modificarTutor);
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static void insertarTutor(Tutor tutor) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return;
        }
        try {
            String insertarTutor = "INSERT INTO TUTOR_FCT (nombre, apellido, idTutor) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertarTutor);
            pst.setString(1, tutor.getNombre());
            pst.setString(2, tutor.getApellidos());
            pst.setInt(3, tutor.getIdTutor());
            pst.executeUpdate(insertarTutor);
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}
