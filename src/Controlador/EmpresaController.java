package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;
import Vista.Empresas.AgregarEmpresa;
import Vista.Empresas.BuscarEmpresa;
import Vista.Empresas.GestionarEmpresas;
import Vista.Empresas.HistorialContactosEmpresa;
import Vista.FCT.BuscarEmpresaCurso;
import Vista.Trabajadores.AgregarTrabajador;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EmpresaController {

    private static ArrayList<Empresa> listaEmpresas = new ArrayList<>();
    private static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static void inicializarEmpresas() {
        Iterator<Empresa> it = consultarEmpresas().iterator();
        while(it.hasNext()) {
            Empresa empresa = it.next();
            GestionarEmpresas.CBListadoEmpresas.addItem(empresa);
            BuscarEmpresa.CBListadoEmpresaB.addItem(empresa);
            BuscarEmpresaCurso.CBListadoEmpresas.addItem(empresa);
            HistorialContactosEmpresa.CBListadoEmpresas.addItem(empresa);
            AgregarTrabajador.CBListadoEmpresas.addItem(empresa);
        }
    }

    public static void eliminarEmpresa(Empresa empresa){

        if (borrarEmpresaSQL(empresa)){
            listaEmpresas.remove(empresa);
            GestionarEmpresas.CBListadoEmpresas.removeItem(empresa);
            BuscarEmpresa.CBListadoEmpresaB.removeItem(empresa);
            BuscarEmpresaCurso.CBListadoEmpresas.removeItem(empresa);
            HistorialContactosEmpresa.CBListadoEmpresas.removeItem(empresa);
            AgregarTrabajador.CBListadoEmpresas.removeItem(empresa);

        }
    }

    public static void modificarEmpresa(Empresa empresaNueva, Empresa empresaVieja){
        if (modificarEmpresaSQL(empresaNueva,empresaVieja)){
            int indice = listaEmpresas.indexOf(empresaVieja);
            if (indice != -1) {
                listaEmpresas.set(indice, empresaNueva);
                GestionarEmpresas.CBListadoEmpresas.removeItemAt(indice);
                GestionarEmpresas.CBListadoEmpresas.insertItemAt(empresaNueva, indice);
                GestionarEmpresas.CBListadoEmpresas.setSelectedItem(empresaNueva);

                BuscarEmpresa.CBListadoEmpresaB.removeItemAt(indice);
                BuscarEmpresa.CBListadoEmpresaB.insertItemAt(empresaNueva, indice);
                BuscarEmpresa.CBListadoEmpresaB.setSelectedItem(empresaNueva);

                BuscarEmpresaCurso.CBListadoEmpresas.removeItemAt(indice);
                BuscarEmpresaCurso.CBListadoEmpresas.insertItemAt(empresaNueva, indice);
                BuscarEmpresaCurso.CBListadoEmpresas.setSelectedItem(empresaNueva);

                HistorialContactosEmpresa.CBListadoEmpresas.removeItemAt(indice);
                HistorialContactosEmpresa.CBListadoEmpresas.insertItemAt(empresaNueva, indice);
                HistorialContactosEmpresa.CBListadoEmpresas.setSelectedItem(empresaNueva);

                AgregarTrabajador.CBListadoEmpresas.removeItemAt(indice);
                AgregarTrabajador.CBListadoEmpresas.insertItemAt(empresaNueva, indice);
                AgregarTrabajador.CBListadoEmpresas.setSelectedItem(empresaNueva);
            }
        }
    }

    public static void agregarEmpresa(Empresa empresaNueva){
        if (EmpresaController.insertarEmpresaSQL(empresaNueva)) {
            listaEmpresas.add(empresaNueva);
            GestionarEmpresas.CBListadoEmpresas.addItem(empresaNueva);
            BuscarEmpresa.CBListadoEmpresaB.addItem(empresaNueva);
            BuscarEmpresaCurso.CBListadoEmpresas.addItem(empresaNueva);
            HistorialContactosEmpresa.CBListadoEmpresas.addItem(empresaNueva);
            AgregarTrabajador.CBListadoEmpresas.addItem(empresaNueva);
        }
    }

    private static ArrayList<Empresa> consultarEmpresas() {
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

    private static boolean borrarEmpresaSQL(Empresa empresa) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            int resp = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

            if(resp == 0){
                Statement st = con.createStatement();
                String borrarEmpresa = "DELETE FROM EMPRESA WHERE CIF = '" + empresa.getCif() + "';";
                st.execute(borrarEmpresa);
                st.close();
                JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","Empresa eliminada",JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private static boolean modificarEmpresaSQL(Empresa empresaNueva, Empresa empresaVieja) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String modificarEmpresa = "UPDATE EMPRESA SET CIF = ?, nombre = ?, " +
                    "telefono = ?, numEmpleados = ?, sector = ?, direccion = ? WHERE CIF = ?";
            PreparedStatement pst = con.prepareStatement(modificarEmpresa);
            pst.setString(1, empresaNueva.getCif());
            pst.setString(2, empresaNueva.getNombre());
            pst.setString(3, empresaNueva.getTelefono());
            pst.setInt(4, empresaNueva.getNumEmpleados());
            pst.setString(5, empresaNueva.getSector());
            pst.setString(6, empresaNueva.getDireccion());
            pst.setString(7, empresaVieja.getCif());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha modificado correctamente","Empresa modificada",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private static boolean insertarEmpresaSQL(Empresa empresa) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String insertarEmpresa = "INSERT INTO EMPRESA (CIF, nombre, telefono, numEmpleados, sector, direccion) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertarEmpresa);
            pst.setString(1, empresa.getCif());
            pst.setString(2, empresa.getNombre());
            pst.setString(3, empresa.getTelefono());
            pst.setInt(4, empresa.getNumEmpleados());
            pst.setString(5, empresa.getSector());
            pst.setString(6, empresa.getDireccion());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha añadido correctamente","Empresa añadida",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
