package Controlador;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class MainPanelController {

    public static JPanel panelActivo, panelPadre, panelInicio;

    static Stack<JPanel> listaPaneles = new Stack<>();

    public MainPanelController(JPanel panelPad , JPanel panelActi){

        panelPadre = panelPad;
        panelActivo = panelActi;
        panelInicio = panelActivo;
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

        if (!listaPaneles.isEmpty()){

            listaPaneles.pop();

            if (!listaPaneles.isEmpty()) {
                panelPadre.remove(panelActivo);
                panelActivo = listaPaneles.peek();
                panelPadre.add(panelActivo);
                panelPadre.revalidate();
                panelPadre.repaint();
            }else {
                panelPadre.remove(panelActivo);
                panelPadre.add(panelInicio);
                panelPadre.revalidate();
                panelPadre.repaint();
            }
        }


    }

    public static void volverInicio(){

        panelPadre.remove(panelActivo);
        panelPadre.add(panelInicio);
        panelPadre.revalidate();
        panelPadre.repaint();
        panelActivo = panelInicio;
        listaPaneles.removeAllElements();
        listaPaneles.add(panelActivo);

    }

}
