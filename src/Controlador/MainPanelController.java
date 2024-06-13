package Controlador;

import javax.swing.*;
import java.util.Stack;

public class MainPanelController {

    private static JPanel panelActivo, panelPadre, panelInicio;
    private static Stack<JPanel> listaPaneles = new Stack<>();

    public MainPanelController(JPanel panelPad, JPanel panelActi) {
        panelPadre = panelPad;
        panelActivo = panelActi;
        panelInicio = panelActivo;
        panelPadre.add(panelActivo);
        if (listaPaneles.isEmpty()) {
            listaPaneles.add(panelActivo);
        }
    }

    public static void nuevoPanelActivo(JPanel nuevoPanel) {
        panelPadre.remove(panelActivo);
        panelPadre.add(nuevoPanel);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = nuevoPanel;
        listaPaneles.add(panelActivo);
    }

    public static void antiguoPanel() {
        if (listaPaneles.size() > 1) {  // Asegurarnos de que siempre quede al menos un panel (panelInicio)
            listaPaneles.pop();
            panelPadre.remove(panelActivo);
            panelActivo = listaPaneles.peek();
            panelPadre.add(panelActivo);
            panelPadre.revalidate();
            panelPadre.repaint();
        }
    }

    public static void volverInicio() {
        panelPadre.remove(panelActivo);
        panelPadre.add(panelInicio);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = panelInicio;
        listaPaneles.clear();
        listaPaneles.add(panelActivo);
    }
}
