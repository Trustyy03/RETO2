package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.FCT;

import javax.swing.*;
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
}