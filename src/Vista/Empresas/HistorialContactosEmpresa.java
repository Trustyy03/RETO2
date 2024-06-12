package Vista.Empresas;

import Modelo.Consultas.Consulta8;
import Modelo.Entidades.Empresa;
import Vista.Estilo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.consultarNombresEmpresas;
import static Modelo.Consultas.OperacionesConsultas.consultaOcho;

public class HistorialContactosEmpresa extends JPanel {

    public static JComboBox<Empresa> CBListadoEmpresas = new JComboBox<>();
    JTable contactosPorEmpresa;
    DefaultTableModel modelo;

    public HistorialContactosEmpresa(){
        /*
        empresas = Estilo.estiloComboBox();
        for (String empresa : consultarNombresEmpresas()){
            empresas.addItem(empresa);
        }

         */

        String[] nombresCampos = new String[]{"Nombre Empresa", "Nombre Tutor", "Descripción", "Fecha"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        contactosPorEmpresa = new JTable(modelo);

        CBListadoEmpresas.addActionListener(e -> mostrarTablaDatos());

        setLayout(new BorderLayout());
        add(CBListadoEmpresas, BorderLayout.NORTH);

        add(new JScrollPane(contactosPorEmpresa), BorderLayout.CENTER);
    }

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);
        Empresa empresa = (Empresa) CBListadoEmpresas.getSelectedItem();

        for (Consulta8 c8 : consultaOcho(empresa.getNombre())){
            Object[] fila = new Object[]{c8.getNombreEmpresa(), c8.getNombreTutor(), c8.getDescripcion(), c8.getFecha()};
            modelo.addRow(fila);
        }
    }

}
