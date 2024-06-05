package Vista;

import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class OpcionesPanel extends JPanel {

    public static JButton btnEmpresas,btnFct,btnProfesores,btnTrabajadores;

    InicioSesion inicioSesionn;

    GridBagConstraints constraints;

    public OpcionesPanel(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        inicioSesionn   = new InicioSesion();

        constraints = new GridBagConstraints();

        btnEmpresas = new JButton(lenguaje.getProperty("btnEmpresas"));
        btnFct = new JButton(lenguaje.getProperty("btnFct"));
        btnProfesores = new JButton(lenguaje.getProperty("btnProfesores"));
        btnTrabajadores = new JButton(lenguaje.getProperty("btnTrabajadores"));

        colocarComponentes();





    }

    public void colocarComponentes(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(btnEmpresas, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (btnFct, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add (btnTrabajadores, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add (btnProfesores, constraints);



    }


}
