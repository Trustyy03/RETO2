package Vista.FCT;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;
import Vista.Trabajadores.BuscarEmpresaCurso;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OpcionesFCT extends JPanel {

    public static JButton gestionarFCT,buscarFCT,btnbuscarPorEmpresaCurso;
    BuscarFCT buscarFCTApartado;
    GestionarFCT gestionarFCTApartado;
    GridBagConstraints constraints;

    BuscarEmpresaCurso buscarEmpresaCursoApartado;

    public OpcionesFCT(){

        this.setLayout(new GridBagLayout());

        try {
            buscarEmpresaCursoApartado = new BuscarEmpresaCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarFCTApartado = new BuscarFCT();
        gestionarFCTApartado = new GestionarFCT();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarFCT = Estilo.botonBonito(lenguaje.getProperty("btnGestionarFCT"));
        gestionarFCT.addActionListener(e -> MainPanelController.nuevoPanelActivo(gestionarFCTApartado));
        buscarFCT = Estilo.botonBonito(lenguaje.getProperty("btnBuscarFCT"));
        buscarFCT.addActionListener(e -> MainPanelController.nuevoPanelActivo(buscarFCTApartado));

        btnbuscarPorEmpresaCurso = Estilo.botonBonito(lenguaje.getProperty("btnBuscarPorEmpresaCUrso"));
        btnbuscarPorEmpresaCurso.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarEmpresaCursoApartado);
        });
        colocarComponentes();
    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(gestionarFCT, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (buscarFCT, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add (btnbuscarPorEmpresaCurso, constraints);

    }

}
