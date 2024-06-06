package Vista.FCT;

import Controlador.MainPanelController;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesFCT extends JPanel {

    JButton gestionarFCT,buscarFCT;
    BuscarFCT buscarFCTApartado;
    GestionarFCT gestionarFCTApartado;
    GridBagConstraints constraints;

    public OpcionesFCT(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        buscarFCTApartado = new BuscarFCT();
        gestionarFCTApartado = new GestionarFCT();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        gestionarFCT = Estilo.botonBonito(lenguaje.getProperty("btnGestionarFCT"));
        gestionarFCT.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarFCTApartado);
        });
        buscarFCT = Estilo.botonBonito(lenguaje.getProperty("btnBuscarFCT"));
        buscarFCT.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(buscarFCTApartado);
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

    }

}
