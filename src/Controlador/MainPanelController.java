package Controlador;

import javax.swing.*;

public class MainPanelController {

    public static JPanel panelActivo, panelPadre, panelAntiguo;

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
        panelAntiguo = panelActivo;
        panelActivo = nuevoPanel;

    }

    public static void antiguoPanel(){

        panelPadre.remove(panelActivo);
        panelPadre.add(panelAntiguo);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = panelAntiguo;

    }

}
