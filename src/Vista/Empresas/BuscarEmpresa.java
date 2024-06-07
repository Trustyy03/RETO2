package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;

public class BuscarEmpresa extends JPanel implements ComponentesGridBagLayout {

    JButton btnListaEmpresas;
    JTextField textListaEmpresas;
    JLabel labelEmpresa;
    JTextField textEmpresa;
    JButton botonEnviar;
    GridBagConstraints constraints;
    ListaDeEmpresas listaDeEmpresasApartado;
    DetallesEmpresa detallesEmpresaApartado;

    public BuscarEmpresa() {

        setLayout(new GridBagLayout());
        listaDeEmpresasApartado = new ListaDeEmpresas();
        detallesEmpresaApartado = new DetallesEmpresa("");

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        btnListaEmpresas = new JButton("LISTA DE EMPRESAS");
        btnListaEmpresas.addActionListener(e ->
                MainPanelController.nuevoPanelActivo(listaDeEmpresasApartado)
        );

        labelEmpresa = new JLabel("EMPRESA");
        textEmpresa = new JTextField(20);

        botonEnviar = new JButton("ENVIAR");
        //si no la encuentras que te salga un showMessageDialog (comprobar que el nombre de la empresa está en la base de datos)
        //si la encuentras te salta a la de detalles
        botonEnviar.addActionListener(e ->
                MainPanelController.nuevoPanelActivo(detallesEmpresaApartado)
        );

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
    }

    @Override
    public void colocarComponentes() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(btnListaEmpresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelEmpresa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(textEmpresa, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonEnviar, constraints);
    }
}
