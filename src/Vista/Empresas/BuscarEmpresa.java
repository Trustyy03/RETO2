package Vista.Empresas;

import Controlador.EmpresaController;
import Controlador.MainPanelController;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BuscarEmpresa extends JPanel implements ComponentesGridBagLayout {
    JLabel labelEmpresa;
    JComboBox<Empresa> listadoEmpresas;
    JButton botonEnviar;
    GridBagConstraints constraints;
    ListaDeEmpresas listaDeEmpresasApartado;

    public BuscarEmpresa() {
        setLayout(new GridBagLayout());
        listaDeEmpresasApartado = new ListaDeEmpresas();

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelEmpresa = new JLabel("EMPRESA");

        listadoEmpresas = new JComboBox<>();
        cargarEmpresasEnComboBox();

        botonEnviar = new JButton("ENVIAR");
        botonEnviar.addActionListener(e -> {
            Empresa empresaSeleccionada = (Empresa) listadoEmpresas.getSelectedItem();
            if (empresaSeleccionada != null) {
                MainPanelController.nuevoPanelActivo(listaDeEmpresasApartado);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una empresa.");
            }
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;

        colocarComponentes();
    }

    public void cargarEmpresasEnComboBox() {
        ArrayList<Empresa> listaEmpresas = EmpresaController.consultarEmpresas();
        DefaultComboBoxModel<Empresa> modelo = new DefaultComboBoxModel<>();

        for (Empresa empresa : listaEmpresas) {
            modelo.addElement(empresa);
        }

        listadoEmpresas.setModel(modelo);
    }

    @Override
    public void colocarComponentes() {
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(labelEmpresa, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(listadoEmpresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(botonEnviar, constraints);
    }
}
