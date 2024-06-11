package Vista.FCT;

import Modelo.Consultas.Consulta4;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.consultarCursos;
import static Modelo.Consultas.ConsultasSimples.consultarNombresEmpresas;
import static Modelo.Consultas.OperacionesConsultas.consultaCuatro;

public class BuscarFCT extends JPanel implements ComponentesGridBagLayout, MostrarDatosTablas {

    JLabel labelCurso;
    JComboBox<String> cursos;
    JLabel labelEmpresa;
    JComboBox<String> empresas;
    JTable fctPorEmpresaYCurso;
    DefaultTableModel modelo;
    GridBagConstraints constraints;


    public BuscarFCT() {

        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelCurso = Estilo.textoBonitoInicioSesion("CURSO");
        cursos = Estilo.estiloComboBox();
        for (String curso : consultarCursos()){
            cursos.addItem(curso);
        }

        labelEmpresa = Estilo.textoBonitoInicioSesion("EMPRESA");
        empresas = Estilo.estiloComboBox();
        for (String empresa : consultarNombresEmpresas()){
            empresas.addItem(empresa);
        }

        String[] nombresCampos = new String[]{"idGrupo", "numeroAlumnos"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        fctPorEmpresaYCurso = new JTable(modelo);

        cursos.addActionListener(e -> mostrarTablaDatos());
        empresas.addActionListener(e -> mostrarTablaDatos());

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
    }


    @Override
    public void colocarComponentes() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.0;
        add(labelCurso, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(cursos, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(labelEmpresa, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(empresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 6; //numero de columnas que ocupara
        constraints.weightx = 1.0; //redimensionamiento
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(fctPorEmpresaYCurso);
        add(scrollPane, constraints);

    }


    public void mostrarTablaDatos() {
        modelo.setRowCount(0);
        try {
            for (Consulta4 consulta4 : consultaCuatro((String)empresas.getSelectedItem(), (String)cursos.getSelectedItem())){
                Object[] fila = new Object[]{consulta4.getIdGrupo(), consulta4.getNumAlumnos()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
