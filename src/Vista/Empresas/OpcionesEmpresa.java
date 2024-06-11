package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OpcionesEmpresa extends JPanel {

    public static JButton gestionarEmpresa,buscarEmpresa,buscarEmpresaPorPracticas,btnBuscarEmpresaPorTecnologia, btnIncidencias;
    BuscarEmpresa buscarEmpresaApartado;
    BuscarEmpresaPorPractica buscarEmpresaPorPracticaApartado;
    GestionarEmpresas gestionarEmpresasApartado;
    BuscarEmpresaPorTecnologia buscarEmpresaPorTecnologiaApartado;
    IncidenciasCurso incidenciasCursoApartado;

    GridBagConstraints constraints;

    public OpcionesEmpresa(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarEmpresaApartado = new BuscarEmpresa();
        try {
            buscarEmpresaPorPracticaApartado = new BuscarEmpresaPorPractica();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        gestionarEmpresasApartado = new GestionarEmpresas();
        buscarEmpresaPorTecnologiaApartado = new BuscarEmpresaPorTecnologia();
        incidenciasCursoApartado = new IncidenciasCurso();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarEmpresa = Estilo.botonBonito(lenguaje.getProperty("btnGestionarEmpresas"));
        gestionarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarEmpresasApartado);
        });
        buscarEmpresa = Estilo.botonBonito(lenguaje.getProperty("btnBuscarEmpresas"));
        buscarEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaApartado);
        });
        buscarEmpresaPorPracticas = Estilo.botonBonito(lenguaje.getProperty("btnEmpresasPorPracticas"));
        buscarEmpresaPorPracticas.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaPorPracticaApartado);
        });
        btnBuscarEmpresaPorTecnologia = Estilo.botonBonito(lenguaje.getProperty("btnEmpresasPorTecnologia"));
        btnBuscarEmpresaPorTecnologia.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaPorTecnologiaApartado);
        });
        btnIncidencias = Estilo.botonBonito(lenguaje.getProperty("btnIncidencias"));
        btnIncidencias.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(incidenciasCursoApartado);
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

        constraints.gridx = 0;
        constraints.gridy = 3;
        add (btnBuscarEmpresaPorTecnologia, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add (btnIncidencias, constraints);

    }
}
