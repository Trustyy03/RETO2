package Vista.Trabajadores;

import Controlador.MainPanelController;
import Vista.Empresas.BuscarEmpresa;
import Vista.Empresas.BuscarEmpresaPorPractica;
import Vista.Empresas.GestionarEmpresas;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesTrabajadores extends JPanel {

    JButton gestionarEmpresa,buscarEmpresa,buscarEmpresaPorPracticas;
    BuscarEmpresa buscarEmpresaApartado;
    BuscarEmpresaPorPractica buscarEmpresaPorPracticaApartado;
    GestionarEmpresas gestionarEmpresasApartado;

    GridBagConstraints constraints;

    public OpcionesTrabajadores(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarEmpresaApartado = new BuscarEmpresa();
        buscarEmpresaPorPracticaApartado = new BuscarEmpresaPorPractica();
        gestionarEmpresasApartado = new GestionarEmpresas();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarEmpresa = crearBotonBonito(lenguaje.getProperty("btnGestionarEmpresas"));
        gestionarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarEmpresasApartado);
        });
        buscarEmpresa = crearBotonBonito(lenguaje.getProperty("btnBuscarEmpresas"));
        buscarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaApartado);
        });
        buscarEmpresaPorPracticas = crearBotonBonito(lenguaje.getProperty("btnEmpresasPorPracticas"));
        buscarEmpresaPorPracticas.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaPorPracticaApartado);
        });

        colocarComponentes();
    }

    private static JButton crearBotonBonito(String text) { //modifica la interfaz de los botones
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setFocusPainted(false);

        return button;
    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(gestionarEmpresa, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (buscarEmpresa, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add (buscarEmpresaPorPracticas, constraints);

    }

}
