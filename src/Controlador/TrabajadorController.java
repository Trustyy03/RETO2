package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.Trabajador;
import Modelo.Entidades.Tutor;
import Vista.Trabajadores.GestionarTrabajadores;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorController {
    private static List<Trabajador> listaTrabajadores = new ArrayList<>();
    public static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static void inicializarTrabajadores() {
        listaTrabajadores = consultarTrabajadores();
        for (Trabajador trabajador : listaTrabajadores) {
            GestionarTrabajadores.CBListadoTrabajadores.addItem(trabajador);
        }
    }
    public static void eliminarTrabajador(Trabajador trabajador) {
        if (borrarTrabajadorSQL(trabajador)) {
            listaTrabajadores.remove(trabajador);
            GestionarTrabajadores.CBListadoTrabajadores.removeItem(trabajador);
        }
    }

    public static void modificarTrabajador(Trabajador trabajadorNuevo, Trabajador trabajadorViejo) {
        if (modificarTrabajadorSQL(trabajadorNuevo, trabajadorViejo)) {
            int indice = listaTrabajadores.indexOf(trabajadorViejo);
            if (indice != -1) {
                listaTrabajadores.set(indice, trabajadorNuevo);
                GestionarTrabajadores.CBListadoTrabajadores.removeItemAt(indice);
                GestionarTrabajadores.CBListadoTrabajadores.insertItemAt(trabajadorNuevo, indice);
                GestionarTrabajadores.CBListadoTrabajadores.setSelectedItem(trabajadorNuevo);
            }
        }
    }

    public static void insertarTrabajador(Trabajador trabajadorNuevo){
        if (insertarTrabajadorSQL(trabajadorNuevo)) {
            listaTrabajadores.add(trabajadorNuevo);
            GestionarTrabajadores.CBListadoTrabajadores.addItem(trabajadorNuevo);
        }
    }

    public static ArrayList<Trabajador> consultarTrabajadores() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return trabajadores;
        }
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

    public static boolean borrarTrabajadorSQL(Trabajador trabajador) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            Statement st = con.createStatement();
            String borrarTrabajador = "DELETE FROM TRABAJADORES_INTERES WHERE idEmpleado = '" + trabajador.getId() + "';";
            st.execute(borrarTrabajador);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","Trabajador eliminado",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static boolean modificarTrabajadorSQL(Trabajador trabajadorNuevo, Trabajador trabajadorViejo) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String modificarTrabajador = "UPDATE TRABAJADORES_INTERES SET idEmpleado = ?, CIF = ?, " +
                    "nombre = ?, apellidos = ?, correo = ?, cargo = ?, telefono = ? WHERE idEmpleado = ?;";
            PreparedStatement pst = con.prepareStatement(modificarTrabajador);
            pst.setInt(1, trabajadorNuevo.getId());
            pst.setString(2, trabajadorNuevo.getCif());
            pst.setString(3, trabajadorNuevo.getNombre());
            pst.setString(4, trabajadorNuevo.getApellidos());
            pst.setString(5, trabajadorNuevo.getCorreo());
            pst.setString(6, trabajadorNuevo.getCargo());
            pst.setString(7, trabajadorNuevo.getTelefono());
            pst.setInt(8, trabajadorViejo.getId());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha modificado correctamente","Trabajador modificado",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static boolean insertarTrabajadorSQL(Trabajador trabajador) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String insertarTrabajador = "INSERT INTO TRABAJADORES_INTERES (idEmpleado, CIF, nombre, apellidos, correo, cargo, telefono) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertarTrabajador);
            pst.setInt(1, trabajador.getId());
            pst.setString(2, trabajador.getCif());
            pst.setString(3, trabajador.getNombre());
            pst.setString(4, trabajador.getApellidos());
            pst.setString(5, trabajador.getCorreo());
            pst.setString(6, trabajador.getCargo());
            pst.setString(7, trabajador.getTelefono());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha añadido correctamente","Trabajador añadido",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

}
