package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.Trabajador;
import Modelo.Entidades.Tutor;
import Vista.Profesores.GestionarTutores;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TutorController {
    private static ArrayList<Tutor> listaTutores = new ArrayList<>();
    private static JComboBox<Tutor> CBlistadoTutores = new JComboBox<>();
    public static java.sql.Connection con = ConexionBDD.getInstance().getConnection();


    public static void inicializarTutores() {
        listaTutores = consultarTutores();
        for (Tutor tutor : listaTutores) {
            CBlistadoTutores.addItem(tutor);
        }
    }

    public static void eliminarTutor(Tutor tutor){
        if (borrarTutorSQL(tutor)){
            listaTutores.remove(tutor);
            CBlistadoTutores.removeItem(tutor);
        }
    }

    public static void modificarTutor(Tutor tutorNuevo, Tutor tutorViejo){
        if (modificarTutorSQL(tutorNuevo,tutorViejo)){
            int indice = listaTutores.indexOf(tutorViejo);
            if (indice != -1) {
                listaTutores.set(indice, tutorNuevo);
                CBlistadoTutores.removeItemAt(indice);
                CBlistadoTutores.insertItemAt(tutorNuevo, indice);
                CBlistadoTutores.setSelectedItem(tutorNuevo);
            }
        }
    }

    public static void agregarTutor(Tutor tutorNuevo){
        if (insertarTutorSQL(tutorNuevo)){
            listaTutores.add(tutorNuevo);
            GestionarTutores.CBlistadoTutores.addItem(tutorNuevo);
        }
    }

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

    public static boolean borrarTutorSQL(Tutor tutor) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            Statement st = con.createStatement();
            String borrarTutor = "DELETE FROM TUTOR_FCT WHERE idTutor = '" + tutor.getIdTutor() + "';";
            st.execute(borrarTutor);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","Tutor eliminado",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static boolean modificarTutorSQL(Tutor tutorNuevo, Tutor tutorViejo) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String modificarTutor = "UPDATE TUTOR_FCT SET nombre = ?, apellido = ?, idTutor = ? WHERE idTutor = ?;";
            PreparedStatement pst = con.prepareStatement(modificarTutor);
            pst.setString(1, tutorNuevo.getNombre());
            pst.setString(2, tutorNuevo.getApellidos());
            pst.setInt(3, tutorNuevo.getIdTutor());
            pst.setInt(4, tutorViejo.getIdTutor());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha modificado correctamente","Tutor modificado",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static boolean insertarTutorSQL(Tutor tutor) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String insertarTutor = "INSERT INTO TUTOR_FCT (nombre, apellido, idTutor) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertarTutor);
            pst.setString(1, tutor.getNombre());
            pst.setString(2, tutor.getApellidos());
            pst.setInt(3, tutor.getIdTutor());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha añadido correctamente","Tutor añadido",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }


    public static ArrayList<Tutor> getListaTutores() {return listaTutores;}

    public static JComboBox<Tutor> getCBlistadoTutores() {return CBlistadoTutores;}
}
