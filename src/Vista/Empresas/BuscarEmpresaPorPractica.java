package Vista.Empresas;

import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;

public class BuscarEmpresaPorPractica extends JPanel implements ComponentesGridBagLayout {

    JLabel labelCurso;
    JTextField textCurso;
    JLabel labelCiclo;
    JTextField textCiclo;
    JButton botonListaEmpresas;
    GridBagConstraints constraints;

    public BuscarEmpresaPorPractica() {

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelCurso = new JLabel("CURSO");
        textCurso = new JTextField(20);

        labelCiclo = new JLabel("CICLO FORMATIVO");
        textCiclo = new JTextField(20);

        botonListaEmpresas = new JButton("LISTA DE EMPRESAS CON PRACTICAS");

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
