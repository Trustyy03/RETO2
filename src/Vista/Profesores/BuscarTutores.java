package Vista.Profesores;

import Modelo.Consultas.C3;
import Modelo.Consultas.ConsultasSimples;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static Modelo.Consultas.OperacionesConsultas.consultaTres;

public class BuscarTutores extends JPanel implements ComponentesGridBagLayout{

    JLabel grupoLabel, cursoLabel;
    JComboBox<String> grupos;
    JComboBox<String> cursos;
    JList<String> empresasList;
    JLabel tutorLabel;
    JTextField tutorField;
    GridBagConstraints constraints;
    JButton btnBuscar;

    public BuscarTutores() {
        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();

        constraints.insets = new Insets(10, 10, 10, 10);

        grupoLabel = new JLabel("GRUPO:");
        grupos = new JComboBox<>();
        cursoLabel = new JLabel("CURSO:");
        cursos = new JComboBox<>();

        tutorLabel = new JLabel("TUTOR:");
        tutorField = new JTextField();

        btnBuscar = new JButton("BUSCAR");

        empresasList = new JList<>();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
        insertarDatosJComboBoxes();

        try {
            String grupoSeleccionado = (String)grupos.getSelectedItem();
            String cursoSeleccionado = (String)cursos.getSelectedItem();

            ArrayList<C3> c3 = consultaTres(grupoSeleccionado,cursoSeleccionado);

            for (C3 results : c3) {

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        grupos.getSelectedItem();

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
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(tutorLabel,constraints);

        constraints.gridx = 1;
        constraints.weightx = 5;
        add(tutorField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 6; //numero de columnas que ocupara
        constraints.weightx = 1.0; //redimensionamiento
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(empresasList), constraints);
    }
}
