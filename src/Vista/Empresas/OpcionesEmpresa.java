package Vista.Empresas;

import Controlador.MainPanelController;
import Vista.FCT.OpcionesFCT;
import Vista.Idioma.Lenguaje;
import Vista.Profesores.OpcionesProfesores;
import Vista.Trabajadores.OpcionesTrabajadores;

import javax.swing.*;
import java.awt.*;

public class OpcionesEmpresa extends JPanel {

    JButton gestionarEmpresa;
    JButton buscarEmpresa;
    JButton buscarEmpresaPorPracticas;
    GridBagConstraints constraints;

    public OpcionesEmpresa(){

        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        opcionesEmpresa = new OpcionesEmpresa();
        opcionesFCT = new OpcionesFCT();
        opcionesProfesores = new OpcionesProfesores();
        opcionesTrabajadores = new OpcionesTrabajadores();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        btnEmpresas = crearBotonBonito(lenguaje.getProperty("btnEmpresas"));
        btnEmpresas.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(opcionesEmpresa);
        });
        btnFct = crearBotonBonito(lenguaje.getProperty("btnFct"));
        btnFct.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(opcionesFCT);
        });
        btnProfesores = crearBotonBonito(lenguaje.getProperty("btnProfesores"));
        btnProfesores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(opcionesProfesores);
        });
        btnTrabajadores = crearBotonBonito(lenguaje.getProperty("btnTrabajadores"));
        btnTrabajadores.addActionListener(e -> {
            MainPanelController.nuevoPanelActivo(opcionesTrabajadores);
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
