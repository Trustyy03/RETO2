package Vista;

import Controlador.MainPanelController;
import Vista.Empresas.OpcionesEmpresa;
import Vista.FCT.OpcionesFCT;
import Vista.Idioma.Lenguaje;
import Vista.Profesores.OpcionesProfesores;
import Vista.Trabajadores.OpcionesTrabajadores;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame{

    public static void main(String[] args) {
        new FramePrincipal();
    }

public FramePrincipal(){ //se inicia el Frame, donde empezará todo

    PanelPrincipal panelPrincipal = new PanelPrincipal(this); //se agrega el panelPrincipal, donde contendrá la información general de la app
    add(panelPrincipal);
    setTitle("INICIO SESIÓN"); //Cuando se realice el inicio de sesión, cambiar el titulo al panel en el que esten (mediante actionsListeners)
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
}


}

class PanelPrincipal extends JPanel {
    JPanel centerPanel = new JPanel(); //es el panel que recibira cambos
    InicioSesion inicioSesionPanel; //el panel donde estará la interfaz de inicio de sesión
    JMenuBar menuBar;
    JButton atras;
    JButton inicio;
    JMenu menuLeng;
    JMenuItem itemEsp, itemEngl;
    MainPanelController mainPanelController; //aqui es donde se controlará la actualización de los paneles

    public PanelPrincipal(FramePrincipal framePrincipal) { //se añade el Framepirncipal para cambiar el titulo cuando se pongan en un panel u otro
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        this.setLayout(new BorderLayout());

        inicioSesionPanel = new InicioSesion(framePrincipal);

        menuBar = new JMenuBar();
        menuLeng = new JMenu(lenguaje.getProperty("menuLeng"));
        itemEsp = new JMenuItem(lenguaje.getProperty("itemEsp"));
        itemEngl = new JMenuItem(lenguaje.getProperty("itemEngl"));
        mainPanelController = new MainPanelController(centerPanel, inicioSesionPanel);
        atras = new JButton("ATRAS");
        inicio = new JButton("INICIO");

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(800, 50));

        // Añadimos el menú
        menuLeng.add(itemEsp);
        menuLeng.add(itemEngl);
        menuBar.add(menuLeng);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(atras);
        buttonPanel.add(inicio);

        northPanel.add(menuBar, BorderLayout.WEST);
        northPanel.add(buttonPanel, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(inicioSesionPanel);

        add(centerPanel, BorderLayout.CENTER);

        itemEsp.addActionListener(e -> cambiarLenguaje(Lenguaje.spanish));
        itemEngl.addActionListener(e -> cambiarLenguaje(Lenguaje.english));
        inicio.addActionListener(e -> {
            MainPanelController.volverInicio();
        });
        atras.addActionListener(e -> MainPanelController.antiguoPanel());
    }

    public void cambiarLenguaje(int newLang) {
        Lenguaje lenguaje = new Lenguaje(newLang);
        menuLeng.setText(lenguaje.getProperty("menuLeng"));
        itemEsp.setText(lenguaje.getProperty("itemEsp"));
        itemEngl.setText(lenguaje.getProperty("itemEngl"));
        OpcionesPanel.btnFct.setText(lenguaje.getProperty("btnFct"));
        OpcionesPanel.btnEmpresas.setText(lenguaje.getProperty("btnEmpresas"));
        OpcionesPanel.btnProfesores.setText(lenguaje.getProperty("btnProfesores"));
        OpcionesPanel.btnTrabajadores.setText(lenguaje.getProperty("btnTrabajadores"));
        InicioSesion.usuario.setText(lenguaje.getProperty("usuarioInicio"));
        InicioSesion.contrasenya.setText(lenguaje.getProperty("contrasenyaInico"));
        InicioSesion.entrar.setText(lenguaje.getProperty("entrarInicio"));
        OpcionesEmpresa.gestionarEmpresa.setText(lenguaje.getProperty("btnGestionarEmpresas"));
        OpcionesEmpresa.buscarEmpresa.setText(lenguaje.getProperty("btnBuscarEmpresas"));
        OpcionesEmpresa.buscarEmpresaPorPracticas.setText(lenguaje.getProperty("btnEmpresasPorPracticas"));
        OpcionesEmpresa.btnBuscarEmpresaPorTecnologia.setText(lenguaje.getProperty("btnEmpresasPorTecnologia"));
        OpcionesFCT.gestionarFCT.setText(lenguaje.getProperty("btnGestionarFCT"));
        OpcionesFCT.buscarFCT.setText(lenguaje.getProperty("btnBuscarFCT"));
        OpcionesProfesores.gestionarProfesores.setText(lenguaje.getProperty("btnGestionarTutores"));
        OpcionesProfesores.buscarTutores.setText(lenguaje.getProperty("btnBuscarTutores"));
        OpcionesTrabajadores.btngestionarTrabajadores.setText(lenguaje.getProperty("btnGestionarTrabajadores"));
        OpcionesTrabajadores.btnbuscarPorEmpresaCurso.setText(lenguaje.getProperty("btnBuscarPorEmpresaCUrso"));
        OpcionesTrabajadores.btnhistorialContactosPorEmpresa.setText(lenguaje.getProperty("btnhistorialContactosPorEmpresa"));

    }
}

