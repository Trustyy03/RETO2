package Vista.FCT;

import Modelo.Entidades.Empresa;
import Modelo.Entidades.FCT;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;

public class BuscarFCT extends JPanel implements ComponentesGridBagLayout {

    JLabel labelCurso;
    JComboBox<String> cursos;
    JLabel labelEmpresa;
    JComboBox<Empresa> empresas;
    JList<FCT> fcts;
    GridBagConstraints constraints;

    public BuscarFCT() {

        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelCurso = new JLabel("CURSO");
        cursos = new JComboBox<>();

        labelEmpresa = new JLabel("EMPRESA");
        empresas = new JComboBox<>();

        fcts = new JList<>();

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
        add(cursos, constraints);

        constraints.gridx = 3;
        add(labelEmpresa, constraints);

        constraints.gridx = 4;
        add(empresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 6; //numero de columnas que ocupara
        constraints.weightx = 1.0; //redimensionamiento
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(fcts), constraints);

    }
}
