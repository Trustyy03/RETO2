package Vista.Empresas;

import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static Modelo.Consultas.ConsultasSimples.consultarTecnologias;

public class IncidenciasCurso extends JPanel implements MostrarDatosTablas {

    JComboBox<String> curso;
    JTable incidenciasPorCurso;
    DefaultTableModel modelo;

    public IncidenciasCurso(){
        curso = new JComboBox<>();

        //String[] nombresCampos = new String[]{"Nombre Empresa", "CIF Empresa"};
        modelo = new DefaultTableModel();
        //modelo.setColumnIdentifiers();
        incidenciasPorCurso = new JTable(modelo);


        setLayout(new BorderLayout());
        add(curso, BorderLayout.NORTH);

        curso.addActionListener(e -> mostrarTablaDatos());

        add(new JScrollPane(incidenciasPorCurso), BorderLayout.CENTER);
    }
    @Override
    public void mostrarTablaDatos() {



    }
}
