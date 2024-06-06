package Controlador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class MainPanelController {

    public static JPanel panelActivo, panelPadre;

    static Stack<JPanel> listaPaneles = new Stack<>();

    static int contador = 0;

    public MainPanelController(JPanel panelPad , JPanel panelActi){

        panelPadre = panelPad;
        panelActivo = panelActi;
        panelPadre.add(panelActivo);
        listaPaneles.add(panelActivo);

    }

    public static void nuevoPanelActivo(JPanel nuevoPanel){

        panelPadre.remove(panelActivo);
        panelPadre.add(nuevoPanel);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = nuevoPanel;
        listaPaneles.add(panelActivo);

    }

    public static void antiguoPanel(){

        panelPadre.remove(panelActivo);
        listaPaneles.pop();
        panelPadre.add(listaPaneles.get(listaPaneles.size()-1));
        panelPadre.revalidate();
        panelPadre.repaint();

    }

}
