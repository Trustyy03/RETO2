package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.EstiloBoton;
import Vista.FCT.OpcionesFCT;
import Vista.Idioma.Lenguaje;
import Vista.Profesores.OpcionesProfesores;
import Vista.Trabajadores.OpcionesTrabajadores;

import javax.swing.*;
import java.awt.*;

public class OpcionesEmpresa extends JPanel {

    public static JButton gestionarEmpresa,buscarEmpresa,buscarEmpresaPorPracticas,btnBuscarEmpresaPorTecnologia;
    BuscarEmpresa buscarEmpresaApartado;
    BuscarEmpresaPorPractica buscarEmpresaPorPracticaApartado;
    GestionarEmpresas gestionarEmpresasApartado;
    BuscarEmpresaPorTecnologia buscarEmpresaPorTecnologiaApartado;

    GridBagConstraints constraints;

    public OpcionesEmpresa(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarEmpresaApartado = new BuscarEmpresa();
        buscarEmpresaPorPracticaApartado = new BuscarEmpresaPorPractica();
        gestionarEmpresasApartado = new GestionarEmpresas();
        buscarEmpresaPorTecnologiaApartado = new BuscarEmpresaPorTecnologia();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarEmpresa = EstiloBoton.botonBonito(lenguaje.getProperty("btnGestionarEmpresas"));
        gestionarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarEmpresasApartado);
        });
        buscarEmpresa = EstiloBoton.botonBonito(lenguaje.getProperty("btnBuscarEmpresas"));
        buscarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaApartado);
        });
        buscarEmpresaPorPracticas = EstiloBoton.botonBonito(lenguaje.getProperty("btnEmpresasPorPracticas"));
        buscarEmpresaPorPracticas.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaPorPracticaApartado);
        });
        btnBuscarEmpresaPorTecnologia = EstiloBoton.botonBonito(lenguaje.getProperty("btnEmpresasPorTecnologia"));
        btnBuscarEmpresaPorTecnologia.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaPorTecnologiaApartado);
        });

        colocarComponentes();
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
