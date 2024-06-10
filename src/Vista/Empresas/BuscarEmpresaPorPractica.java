package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;

public class BuscarEmpresaPorPractica extends JPanel implements ComponentesGridBagLayout {

    JLabel labelCurso;
    static JTextField textCurso;
    JLabel labelCiclo;
    static JTextField textCiclo;
    JButton botonListaEmpresas;
    GridBagConstraints constraints;
    ListaDeEmpresasConPracticas listaDeEmpresasConPracticasApartado;

    public BuscarEmpresaPorPractica() {

        setLayout(new GridBagLayout());
        listaDeEmpresasConPracticasApartado = new ListaDeEmpresasConPracticas();

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelCurso = new JLabel("CURSO");
        textCurso = new JTextField(20);

        labelCiclo = new JLabel("CICLO FORMATIVO");
        textCiclo = new JTextField(20);

        botonListaEmpresas = new JButton("LISTA DE EMPRESAS CON PRACTICAS");
        botonListaEmpresas.addActionListener( e ->
            MainPanelController.nuevoPanelActivo(listaDeEmpresasConPracticasApartado)
        );

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();

    }
    @Override
    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelCurso, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(textCurso, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelCiclo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(textCiclo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonListaEmpresas, constraints);

    }

}
