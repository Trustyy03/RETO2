package Vista.Trabajadores;

import Controlador.MainPanelController;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static Modelo.Consultas.ConsultasSimples.*;


public class BuscarEmpresaCurso extends JPanel implements ComponentesGridBagLayout {

    JLabel labelEmpresa;
    public static JComboBox<Empresa> CBListadoEmpresas = new JComboBox<>();
    JLabel labelCurso;
    JComboBox<String> cursos;
    JButton botonListaTrabajadores;
    GridBagConstraints constraints;
    ListaDeTrabajadores listaDeTrabajadores;

    public BuscarEmpresaCurso() throws SQLException {

        setLayout(new GridBagLayout());
        listaDeTrabajadores = new ListaDeTrabajadores();

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelEmpresa = new JLabel("EMPRESA");

        labelCurso = new JLabel("CURSO");
        cursos = new JComboBox<>();
        for (String curso : consultarCursos()) {
            cursos.addItem(curso);
        }

        botonListaTrabajadores = new JButton("LISTA DE TRABAJADORES POR EMPRESA / CURSO");
        botonListaTrabajadores.addActionListener(e ->
                MainPanelController.nuevoPanelActivo(listaDeTrabajadores)
        );

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();

    }
    @Override
    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelEmpresa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(CBListadoEmpresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelCurso, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(cursos, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonListaTrabajadores, constraints);

    }

}
