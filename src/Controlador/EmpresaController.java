package Controlador;

import Modelo.ConexionBDD;
import Modelo.Entidades.Empresa;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpresaController {
    static java.sql.Connection con = ConexionBDD.getInstance().getConnection();

    public static ArrayList<Empresa> consultarEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();
        try {
            Statement st = con.createStatement();
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
}
