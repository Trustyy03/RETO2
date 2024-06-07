package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.FCT;
import Modelo.Entidades.Tutor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FCTController {
    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<FCT> consultarFCT() {
        ArrayList<FCT> fcts = new ArrayList<>();
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

    public static void borrarFCT(FCT fct) {
        try {
            Statement st = con.createStatement();
            String borrarFCT = "DELETE FROM GRUPO_FCT_EMPRESA WHERE CIF = '" + fct.getCif()
                    + "' AND idGrupo = '" + fct.getIdGrupo()
                    + "' AND cursoEscolar = '" + fct.getCursoEscolar() + "';";
            st.execute(borrarFCT);
            st.close();
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente","FCT eliminada",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    public static void modificarFCT(FCT FCTNueva, FCT FCTVieja) {
        try {
            String modificarTutor = "UPDATE GRUPO_FCT_EMPRESA SET CIF = ?, idGrupo = ?, cursoEscolar = ?, " +
                    "numAlumnos = ? WHERE CIF = ? AND idGrupo = ? AND cursoEscolar = ?;";
            PreparedStatement pst = con.prepareStatement(modificarTutor);
            pst.setString(1, FCTNueva.getCif());
            pst.setString(2, FCTNueva.getIdGrupo());
            pst.setString(3, FCTNueva.getCursoEscolar());
            pst.setInt(4, FCTNueva.getNumAlumnos());
            pst.setString(5, FCTVieja.getCif());
            pst.setString(6, FCTVieja.getIdGrupo());
            pst.setString(7, FCTVieja.getCursoEscolar());
            pst.execute(modificarTutor);
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
}
