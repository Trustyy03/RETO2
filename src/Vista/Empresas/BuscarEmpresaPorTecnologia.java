package Vista.Empresas;

import Modelo.Consultas.C7;
import Vista.Estilo;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static Modelo.Consultas.ConsultasSimples.consultarTecnologias;
import static Modelo.Consultas.OperacionesConsultas.consultaSiete;

public class BuscarEmpresaPorTecnologia extends JPanel implements MostrarDatosTablas {

    JComboBox<String> tecnologias;
    JTable empresaPorTecnologia;
    DefaultTableModel modelo;


    public BuscarEmpresaPorTecnologia(){
        tecnologias = Estilo.estiloComboBox();
        for (String tecnologia : consultarTecnologias()){
            tecnologias.addItem(tecnologia);
        }

        String[] nombresCampos = new String[]{"Nombre Empresa", "CIF Empresa"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        empresaPorTecnologia = new JTable(modelo);


        setLayout(new BorderLayout());
        add(tecnologias, BorderLayout.NORTH);

        tecnologias.addActionListener(e -> mostrarTablaDatos());

        add(new JScrollPane(empresaPorTecnologia), BorderLayout.CENTER);
    }

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        for (C7 c7 : consultaSiete((String)tecnologias.getSelectedItem())){
            Object[] fila = new Object[]{c7.getNombreEmpresa(), c7.getCif()};
            modelo.addRow(fila);
        }
    }

}
