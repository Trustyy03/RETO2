package Vista;

import Controlador.MainPanelController;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame{

    public static void main(String[] args) {
        new FramePrincipal();
    }

public FramePrincipal(){

    PanelPrincipal panelPrincipal = new PanelPrincipal();

    add(panelPrincipal);
    setTitle("INICIO SESIÓN"); //Cuando se realice el inicio de sesión, cambiar el titulo al panel en el que esten
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
}


}

class PanelPrincipal extends JPanel {

    MainPanelController mainPanelController;
    JMenuBar menuBar;
    JMenu menuLeng;
    JMenuItem itemEsp, itemEngl;
    InicioSesion inicioSesionPanel;

    public PanelPrincipal() {
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        menuLeng = new JMenu(lenguaje.getProperty("menuLeng"));
        itemEsp = new JMenuItem(lenguaje.getProperty("itemEsp"));
        itemEngl = new JMenuItem(lenguaje.getProperty("itemEngl"));

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(800, 50));

        menuLeng.add(itemEsp);
        menuLeng.add(itemEngl);
        menuBar.add(menuLeng);

        northPanel.add(menuBar);

        add(northPanel, BorderLayout.NORTH);

        inicioSesionPanel = new InicioSesion();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(inicioSesionPanel);

        add(centerPanel, BorderLayout.CENTER);

        mainPanelController = new MainPanelController(centerPanel,inicioSesionPanel);

        itemEsp.addActionListener(e -> cambiarLenguaje(Lenguaje.spanish));
        itemEngl.addActionListener(e -> cambiarLenguaje(Lenguaje.english));
    }

    public void cambiarLenguaje(int newLang) {
        Lenguaje lenguaje = new Lenguaje(newLang);
        menuLeng.setText(lenguaje.getProperty("menuLeng"));
        itemEsp.setText(lenguaje.getProperty("itemEsp"));
        itemEngl.setText(lenguaje.getProperty("itemEngl"));
        InicioSesion.usuario.setText(lenguaje.getProperty("usuarioInicio"));
        InicioSesion.contrasenya.setText(lenguaje.getProperty("contrasenyaInico"));
        InicioSesion.entrar.setText(lenguaje.getProperty("entrarInicio"));
    }
}

