package Vista.Empresas;

import Modelo.Consultas.Consulta7;
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

        for (Consulta7 consulta7 : consultaSiete((String)tecnologias.getSelectedItem())){
            Object[] fila = new Object[]{consulta7.getNombreEmpresa(), consulta7.getCif()};
            modelo.addRow(fila);
        }
    }

}
