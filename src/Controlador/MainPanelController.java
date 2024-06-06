package Controlador;

import javax.swing.*;

public class MainPanelController {

    public static JPanel panelActivo, panelPadre;

    public MainPanelController(JPanel panelPad , JPanel panelActi){

        panelPadre = panelPad;
        panelActivo = panelActi;
        panelPadre.add(panelActivo);

    }

    public static void nuevoPanelActivo(JPanel nuevoPanel){

        panelPadre.remove(panelActivo);
        panelPadre.add(nuevoPanel);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = nuevoPanel;

    }

}
