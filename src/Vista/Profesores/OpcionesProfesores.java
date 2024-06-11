package Vista.Profesores;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesProfesores extends JPanel {

    public static JButton gestionarProfesores,buscarTutores;
    BuscarTutores buscarTutoresApartado;
    GestionarTutores gestionarTutoresApartado;
    GridBagConstraints constraints;

    public OpcionesProfesores(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarTutoresApartado = new BuscarTutores();
        gestionarTutoresApartado = new GestionarTutores();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarProfesores = Estilo.botonBonito(lenguaje.getProperty("btnGestionarTutores"));
        gestionarProfesores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarTutoresApartado);
        });
        buscarTutores = Estilo.botonBonito(lenguaje.getProperty("btnBuscarTutores"));
        buscarTutores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarTutoresApartado);

        });
        colocarComponentes();
    }
    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(gestionarProfesores, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (buscarTutores, constraints);

    }

}
