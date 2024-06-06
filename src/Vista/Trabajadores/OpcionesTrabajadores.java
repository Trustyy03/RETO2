package Vista.Trabajadores;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesTrabajadores extends JPanel {

    JButton btngestionarTrabajadores,btnbuscarPorEmpresaCurso,btnhistorialContactosPorEmpresa;
    BuscarEmpresaCurso buscarEmpresaCursoApartado;
    GestionarTrabajadores gestionarTrabajadoresApartado;
    HistorialContactosEmpresa historialContactosEmpresaApartado;

    GridBagConstraints constraints;

    public OpcionesTrabajadores(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarEmpresaCursoApartado = new BuscarEmpresaCurso();
        gestionarTrabajadoresApartado = new GestionarTrabajadores();
        historialContactosEmpresaApartado = new HistorialContactosEmpresa();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        btngestionarTrabajadores = Estilo.botonBonito(lenguaje.getProperty(""));
        btngestionarTrabajadores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarTrabajadoresApartado);
        });
        btnbuscarPorEmpresaCurso = Estilo.botonBonito(lenguaje.getProperty(""));
        btnbuscarPorEmpresaCurso.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaCursoApartado);
        });
        btnhistorialContactosPorEmpresa = Estilo.botonBonito(lenguaje.getProperty(""));
        btnhistorialContactosPorEmpresa.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(historialContactosEmpresaApartado);
        });

        colocarComponentes();
    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(btngestionarTrabajadores, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (btnbuscarPorEmpresaCurso, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add (btnhistorialContactosPorEmpresa, constraints);

    }

}
