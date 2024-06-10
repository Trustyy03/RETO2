package Vista.Trabajadores;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OpcionesTrabajadores extends JPanel {

    public static JButton btngestionarTrabajadores,btnbuscarPorEmpresaCurso,btnhistorialContactosPorEmpresa;
    BuscarEmpresaCurso buscarEmpresaCursoApartado;
    GestionarTrabajadores gestionarTrabajadoresApartado;
    HistorialContactosEmpresa historialContactosEmpresaApartado;

    GridBagConstraints constraints;

    public OpcionesTrabajadores(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        try {
            buscarEmpresaCursoApartado = new BuscarEmpresaCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        gestionarTrabajadoresApartado = new GestionarTrabajadores();
        historialContactosEmpresaApartado = new HistorialContactosEmpresa();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        btngestionarTrabajadores = Estilo.botonBonito(lenguaje.getProperty("btnGestionarTrabajadores"));
        btngestionarTrabajadores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarTrabajadoresApartado);
        });
        btnbuscarPorEmpresaCurso = Estilo.botonBonito(lenguaje.getProperty("btnBuscarPorEmpresaCUrso"));
        btnbuscarPorEmpresaCurso.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaCursoApartado);
        });
        btnhistorialContactosPorEmpresa = Estilo.botonBonito(lenguaje.getProperty("btnhistorialContactosPorEmpresa"));
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
