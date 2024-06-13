package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.FCT;
import Modelo.Entidades.Tutor;
import Vista.FCT.GestionarFCT;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FCTController {
    private static List<FCT> listaFCT = new ArrayList<>();
    private static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static void inicializarFCT(){
        listaFCT = consultarFCT();
        consultarFCT().forEach(fct -> GestionarFCT.CBListadoFCT.addItem(fct));
    }

    public static void eliminarFCT(FCT fct){
        if (FCTController.eliminarFCTSQL(fct)){
            listaFCT.remove(fct);
            GestionarFCT.CBListadoFCT.removeItem(fct);
        }
    }

    public static void modificarFTC(FCT fctNueva , FCT fctVieja){
        if (FCTController.modificarFCTSQL(fctNueva,fctVieja)){
            int indice = listaFCT.indexOf(fctVieja);
            if (indice != -1) {
                listaFCT.set(indice, fctNueva);
                GestionarFCT.CBListadoFCT.removeItemAt(indice);
                GestionarFCT.CBListadoFCT.insertItemAt(fctNueva, indice);
                GestionarFCT.CBListadoFCT.setSelectedItem(fctNueva);
            }
        }
    }

    public static void agregarFCT(FCT nuevaFCT){
        if ( FCTController.insertarFCTSQL(nuevaFCT)){
            listaFCT.add(nuevaFCT);
            GestionarFCT.CBListadoFCT.addItem(nuevaFCT);
        }
    }

    public static ArrayList<FCT> consultarFCT() {
        ArrayList<FCT> fcts = new ArrayList<>();
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return fcts;
        }
        try {
            Statement st = con.createStatement();
            String consultaFCT = "SELECT * FROM GRUPO_FCT_EMPRESA";
            ResultSet rs = st.executeQuery(consultaFCT);

            while (rs.next()) {
                FCT fct =  new FCT(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                fcts.add(fct);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }

        return fcts;
    }

    private static boolean eliminarFCTSQL(FCT fct) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            Statement st = con.createStatement();
            String borrarFCT = "DELETE FROM GRUPO_FCT_EMPRESA WHERE CIF = '" + fct.getCif()
                    + "' AND idGrupo = '" + fct.getIdGrupo()
                    + "' AND cursoEscolar = '" + fct.getCursoEscolar() + "';";
            st.execute(borrarFCT);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","FCT eliminada",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private static boolean modificarFCTSQL(FCT FCTNueva, FCT FCTVieja) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String modificarTutor = "UPDATE GRUPO_FCT_EMPRESA SET CIF = ?, idGrupo = ?, cursoEscolar = ?, " +
                    "numAlumnos = ? WHERE CIF = ? AND idGrupo = ? AND cursoEscolar = ?";
            PreparedStatement pst = con.prepareStatement(modificarTutor);
            pst.setString(1, FCTNueva.getCif());
            pst.setString(2, FCTNueva.getIdGrupo());
            pst.setString(3, FCTNueva.getCursoEscolar());
            pst.setInt(4, FCTNueva.getNumAlumnos());
            pst.setString(5, FCTVieja.getCif());
            pst.setString(6, FCTVieja.getIdGrupo());
            pst.setString(7, FCTVieja.getCursoEscolar());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha modificado correctamente","FCT modificada",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private static boolean insertarFCTSQL(FCT fct) {
        if (con == null) {
            System.out.println("Conexión de la base de datos no disponible");
            return false;
        }
        try {
            String insertarFCT = "INSERT INTO GRUPO_FCT_EMPRESA (CIF, idGrupo, cursoEscolar, numAlumnos) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertarFCT);
            pst.setString(1, fct.getCif());
            pst.setString(2, fct.getIdGrupo());
            pst.setString(3, fct.getCursoEscolar());
            pst.setInt(4, fct.getNumAlumnos());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null,"Se ha añadido correctamente","FCT añadida",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

}
