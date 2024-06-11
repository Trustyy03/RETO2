package Vista.FCT;

import Modelo.Consultas.C4;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.FCT;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.consultarCursos;
import static Modelo.Consultas.ConsultasSimples.consultarNombresEmpresas;
import static Modelo.Consultas.OperacionesConsultas.consultaCuatro;

public class BuscarFCT extends JPanel implements ComponentesGridBagLayout {

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

        labelCurso = new JLabel("CURSO");
        cursos = new JComboBox<>();
        for (String curso : consultarCursos()){
            cursos.addItem(curso);
        }

        labelEmpresa = new JLabel("EMPRESA");
        empresas = new JComboBox<>();
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

    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        try {
            for (C4 c4 : consultaCuatro((String)empresas.getSelectedItem(), (String)cursos.getSelectedItem())){
                Object[] fila = new Object[]{c4.getIdGrupo(), c4.getNumAlumnos()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
}
