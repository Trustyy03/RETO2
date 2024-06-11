package Vista.Trabajadores;

import Controlador.MainPanelController;
import Vista.Estilo;

import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OpcionesTrabajadores extends JPanel {

    public static JButton btngestionarTrabajadores;

    GestionarTrabajadores gestionarTrabajadoresApartado;
    GridBagConstraints constraints;

    public OpcionesTrabajadores(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);


        gestionarTrabajadoresApartado = new GestionarTrabajadores();


        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        btngestionarTrabajadores = Estilo.botonBonito(lenguaje.getProperty("btnGestionarTrabajadores"));
        btngestionarTrabajadores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(gestionarTrabajadoresApartado);
        });




        colocarComponentes();
    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(btngestionarTrabajadores, constraints);

    }

}
