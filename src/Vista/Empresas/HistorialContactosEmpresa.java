package Vista.Empresas;

import Modelo.Consultas.C8;
import Vista.Estilo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.consultarNombresEmpresas;
import static Modelo.Consultas.OperacionesConsultas.consultaOcho;

public class HistorialContactosEmpresa extends JPanel {

    JComboBox<String> empresas;
    JTable contactosPorEmpresa;
    DefaultTableModel modelo;

    public HistorialContactosEmpresa(){
        empresas = Estilo.estiloComboBox();
        for (String empresa : consultarNombresEmpresas()){
            empresas.addItem(empresa);
        }

        String[] nombresCampos = new String[]{"Nombre Empresa", "Nombre Tutor", "Descripción", "Fecha"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        contactosPorEmpresa = new JTable(modelo);

        empresas.addActionListener(e -> mostrarTablaDatos());

        setLayout(new BorderLayout());
        add(empresas, BorderLayout.NORTH);

        add(new JScrollPane(contactosPorEmpresa), BorderLayout.CENTER);
    }

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        for (C8 c8 : consultaOcho((String)empresas.getSelectedItem())){
            Object[] fila = new Object[]{c8.getNombreEmpresa(), c8.getNombreTutor(), c8.getDescripcion(), c8.getFecha()};
            modelo.addRow(fila);
        }
    }

}