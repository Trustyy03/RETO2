package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpresaController {
    public static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<Empresa> consultarEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();

        if (con == null){
            System.out.println("Conexión de la base de datos no disponible");
            return empresas;
        }

        try (Statement st = con.createStatement()){
            String consultaEmpresas = "SELECT * FROM EMPRESA";
            ResultSet rs = st.executeQuery(consultaEmpresas);

            while (rs.next()) {
                Empresa empresa =  new Empresa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                empresas.add(empresa);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }

        return empresas;
    }

    public static void borrarEmpresa(Empresa empresa) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return;
        }
        try {
            Statement st = con.createStatement();
            String borrarEmpresa = "DELETE FROM EMPRESA WHERE CIF = '" + empresa.getCif() + "';";
            st.execute(borrarEmpresa);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","Empresa eliminada",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static void modificarEmpresa(Empresa empresaNueva, Empresa empresaVieja) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return;
        }
        try {
            String modificarTrabajador = "UPDATE EMPRESA SET CIF = ?, nombre = ?, " +
                    "telefono = ?, numEmpleados = ?, sector = ?, direccion = ? WHERE CIF = ?;";
            PreparedStatement pst = con.prepareStatement(modificarTrabajador);
            pst.setString(1, empresaNueva.getCif());
            pst.setString(2, empresaNueva.getNombre());
            pst.setString(3, empresaNueva.getTelefono());
            pst.setInt(4, empresaNueva.getNumEmpleados());
            pst.setString(5, empresaNueva.getSector());
            pst.setString(6, empresaNueva.getDireccion());
            pst.setString(7, empresaVieja.getCif());
            pst.executeUpdate(modificarTrabajador);
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}
