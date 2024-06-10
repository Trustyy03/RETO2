package Vista.Empresas;

import Controlador.EmpresaController;
import Controlador.MainPanelController;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuscarEmpresa extends JPanel implements ComponentesGridBagLayout {
    JLabel labelEmpresa,prueba;
    JButton botonEnviar;
    GridBagConstraints constraints;
    ListaDeEmpresas listaDeEmpresasApartado;
    JComboBox<Empresa> cb;

    public BuscarEmpresa() {
        setLayout(new GridBagLayout());
        listaDeEmpresasApartado = new ListaDeEmpresas();

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        labelEmpresa = new JLabel("EMPRESA");
        prueba = new JLabel("asdf");
       // cb = new JComboBox<>();
        cb = EmpresaController.getCBlistadoEmpresas();

        botonEnviar = new JButton("ENVIAR");
        botonEnviar.addActionListener(e -> {
            Empresa empresaSeleccionada = (Empresa) EmpresaController.getCBlistadoEmpresas().getSelectedItem();
            if (empresaSeleccionada != null) {
                MainPanelController.nuevoPanelActivo(listaDeEmpresasApartado);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una empresa.");
            }
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
    }

    @Override
    public void colocarComponentes() {
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(labelEmpresa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        add(cb, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonEnviar, constraints);
    }
}
