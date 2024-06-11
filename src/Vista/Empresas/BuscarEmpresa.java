package Vista.Empresas;

import Controlador.EmpresaController;
import Controlador.MainPanelController;
import Modelo.Consultas.OperacionesConsultas;
import Modelo.Entidades.Empresa;
import Vista.ComponentesGridBagLayout;
import Vista.Estilo;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuscarEmpresa extends JPanel implements ComponentesGridBagLayout {
    JLabel labelEmpresa;
    JButton botonEnviar;
    GridBagConstraints constraints;

    DetallesEmpresa detallesEmpresa;

    static Empresa empresaSeleccionada;

    public static JComboBox<Empresa> CBListadoEmpresaB = Estilo.estiloComboBox();

    public BuscarEmpresa() {

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        labelEmpresa = Estilo.textoBonitoInicioSesion("EMPRESA");

        botonEnviar = Estilo.botonBonito("ENVIAR");
        botonEnviar.addActionListener(e -> {
            empresaSeleccionada = (Empresa) CBListadoEmpresaB.getSelectedItem();
            if (empresaSeleccionada != null) {
                detallesEmpresa = new DetallesEmpresa();
                MainPanelController.nuevoPanelActivo(detallesEmpresa);

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
        add(CBListadoEmpresaB, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        add(botonEnviar, constraints);
    }

    public static Empresa getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }
}
