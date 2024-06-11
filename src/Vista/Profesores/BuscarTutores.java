package Vista.Profesores;

import Modelo.Consultas.Consulta3;
import Modelo.Consultas.ConsultasSimples;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;
import Vista.MostrarDatosTablas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.OperacionesConsultas.consultaTres;

public class BuscarTutores extends JPanel implements ComponentesGridBagLayout, MostrarDatosTablas {

    JLabel grupoLabel, cursoLabel;
    JComboBox<String> grupos;
    JComboBox<String> cursos;
    GridBagConstraints constraints;
    JTable empresaPorTecnologia;
    DefaultTableModel modelo;

    public BuscarTutores() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        grupoLabel = Estilo.textoBonitoInicioSesion("GRUPO:");
        cursoLabel = Estilo.textoBonitoInicioSesion("CURSO:");
        grupos = Estilo.estiloComboBox();
        cursos = Estilo.estiloComboBox();
        insertarDatosJComboBoxes();


        String[] nombresCampos = new String[]{"Ciclo", "Grupo", "Nombre Tutor", "Nombre Empresa", "Número Prácticas"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        empresaPorTecnologia = new JTable(modelo);

        grupos.addActionListener(e -> mostrarTablaDatos());
        cursos.addActionListener(e -> mostrarTablaDatos());

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
    }

    private void insertarDatosJComboBoxes() {
        //Inserción de datos JComboBoxes
        for (String grupo : ConsultasSimples.consultarGrupos()) {
            grupos.addItem(grupo);
        }
        for (String curso : ConsultasSimples.consultarCursos()) {
            cursos.addItem(curso);
        }
    }

    @Override
    public void colocarComponentes() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;
        constraints.weighty = 0.0;
        add(grupoLabel,constraints);

        constraints.gridx = 1;
        add(grupos,constraints);

        constraints.gridx = 2;
        add(cursoLabel, constraints);

        constraints.gridx = 4;
        add(cursos, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 6; //numero de columnas que ocupara
        constraints.weightx = 1.0; //redimensionamiento
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(empresaPorTecnologia);
        add(scrollPane, constraints);
    }

    @Override
    public void mostrarTablaDatos() {
        modelo.setRowCount(0);

        try {
            for (Consulta3 consulta3 : consultaTres((String)grupos.getSelectedItem(), (String)cursos.getSelectedItem())) {
                Object[] fila = new Object[]{consulta3.getCiclo(), consulta3.getIdGrupo(), consulta3.getNombreTutor(), consulta3.getNombreEmpresa(), consulta3.getNumPracticas()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
