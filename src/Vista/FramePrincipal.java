package Vista;

import Controlador.*;
import Modelo.ConexionBDD;
import Vista.Empresas.*;
import Vista.FCT.OpcionesFCT;
import Vista.Idioma.Lenguaje;
import Vista.Profesores.OpcionesProfesores;
import Vista.Trabajadores.OpcionesTrabajadores;

import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame{

    public static void main(String[] args) {
        ConexionBDD.ConfigurarConnection();
        EmpresaController.inicializarEmpresas();
        FCTController.inicializarFCT();
        TrabajadorController.inicializarTrabajadores();
        TutorController.inicializarTutores();
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
    JPanel centerPanel = new JPanel(); //es el panel que recibira cambios
    OpcionesPanel opcionesPanel;
    JMenuBar menuBar;
    JButton btnAtras;
    static JLabel nombreUsuario;
    JButton btnInicio;
    JMenu menuLeng;
    JMenuItem itemEsp, itemEngl;
    MainPanelController mainPanelController; //aqui es donde se controlará la actualización de los paneles

    public PanelPrincipal(FramePrincipal framePrincipal) { //se añade el Framepirncipal para cambiar el titulo cuando se pongan en un panel u otro
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);
        this.setLayout(new BorderLayout());

        opcionesPanel = new OpcionesPanel();

        btnAtras = Estilo.botonBonitoDeLaBarra(lenguaje.getProperty("btnAtras"));
        btnInicio = Estilo.botonBonitoDeLaBarra(lenguaje.getProperty("btnInicio"));
        menuBar = Estilo.menuBarBonito();
        nombreUsuario = new JLabel(lenguaje.getProperty("nombree"));
        menuLeng = Estilo.menuBonito(lenguaje.getProperty("menuLeng"));
        itemEsp = Estilo.menuItemBonito(lenguaje.getProperty("itemEsp"));
        itemEngl = Estilo.menuItemBonito(lenguaje.getProperty("itemEngl"));
        mainPanelController = new MainPanelController(centerPanel, opcionesPanel);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(800, 50));

        // Añadimos el menú
        menuLeng.add(itemEsp);
        menuLeng.add(itemEngl);
        menuBar.add(menuLeng);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAtras);
        buttonPanel.add(btnInicio);

        northPanel.add(menuBar, BorderLayout.WEST);
        northPanel.add(nombreUsuario,BorderLayout.CENTER);
        northPanel.add(buttonPanel, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(opcionesPanel);

        add(centerPanel, BorderLayout.CENTER);

        itemEsp.addActionListener(e -> cambiarLenguaje(Lenguaje.spanish));
        itemEngl.addActionListener(e -> cambiarLenguaje(Lenguaje.english));
        btnInicio.addActionListener(e -> {
            MainPanelController.volverInicio();
            nombreUsuario.setText("I");
        });
        btnAtras.addActionListener(e ->{ MainPanelController.antiguoPanel();});
    }

    public void cambiarLenguaje(int newLang) {
        Lenguaje lenguaje = new Lenguaje(newLang);

        btnAtras.setText(lenguaje.getProperty("btnAtras"));
        btnInicio.setText(lenguaje.getProperty("btnInicio"));
        menuLeng.setText(lenguaje.getProperty("menuLeng"));
        itemEsp.setText(lenguaje.getProperty("itemEsp"));
        itemEngl.setText(lenguaje.getProperty("itemEngl"));
        nombreUsuario.setText(lenguaje.getProperty("nombree")+ " "+ InicioSesion.rellenarUsuario.getText());
        OpcionesPanel.btnFct.setText(lenguaje.getProperty("btnFct"));
        OpcionesPanel.btnEmpresas.setText(lenguaje.getProperty("btnEmpresas"));
        OpcionesPanel.btnProfesores.setText(lenguaje.getProperty("btnProfesores"));
        OpcionesPanel.btnTrabajadores.setText(lenguaje.getProperty("btnTrabajadores"));
        InicioSesion.nombree = lenguaje.getProperty("nombree");
        InicioSesion.usuario.setText(lenguaje.getProperty("usuarioInicio"));
        InicioSesion.contrasenya.setText(lenguaje.getProperty("contrasenyaInico"));
        InicioSesion.entrar.setText(lenguaje.getProperty("entrarInicio"));
        OpcionesEmpresa.gestionarEmpresa.setText(lenguaje.getProperty("btnGestionarEmpresas"));
        OpcionesEmpresa.buscarEmpresa.setText(lenguaje.getProperty("btnBuscarEmpresas"));
        OpcionesEmpresa.buscarEmpresaPorPracticas.setText(lenguaje.getProperty("btnEmpresasPorPracticas"));
        OpcionesEmpresa.btnBuscarEmpresaPorTecnologia.setText(lenguaje.getProperty("btnEmpresasPorTecnologia"));
        OpcionesEmpresa.btnIncidencias.setText(lenguaje.getProperty("btnIncidencias"));
        OpcionesFCT.gestionarFCT.setText(lenguaje.getProperty("btnGestionarFCT"));
        OpcionesFCT.buscarFCT.setText(lenguaje.getProperty("btnBuscarFCT"));
        OpcionesProfesores.gestionarProfesores.setText(lenguaje.getProperty("btnGestionarTutores"));
        OpcionesProfesores.buscarTutores.setText(lenguaje.getProperty("btnBuscarTutores"));
        OpcionesTrabajadores.btngestionarTrabajadores.setText(lenguaje.getProperty("btnGestionarTrabajadores"));
        OpcionesFCT.btnbuscarPorEmpresaCurso.setText(lenguaje.getProperty("btnBuscarPorEmpresaCUrso"));
        OpcionesEmpresa.btnhistorialContactosPorEmpresa.setText(lenguaje.getProperty("btnhistorialContactosPorEmpresa"));

        GestionarEmpresas.btnBorrarEmpresa.setText(lenguaje.getProperty("btnBorrar"));
        GestionarEmpresas.btnGuardarEmpresa.setText(lenguaje.getProperty("btnGuardar"));
        GestionarEmpresas.btnAgregarEmpresa.setText(lenguaje.getProperty("btnAgregar"));
        GestionarEmpresas.cif.setText(lenguaje.getProperty("cif"));
        GestionarEmpresas.nombre.setText(lenguaje.getProperty("nombreEmpresa"));
        GestionarEmpresas.telefono.setText(lenguaje.getProperty("telefonoEmpresa"));
        GestionarEmpresas.numEmpleados.setText(lenguaje.getProperty("numEmpleadoEmpresa"));
        GestionarEmpresas.sector.setText(lenguaje.getProperty("sectorEmpresa"));
        GestionarEmpresas.direccion.setText(lenguaje.getProperty("direccionEmpresa"));

        AgregarEmpresa.btnGuardarEmpresa.setText(lenguaje.getProperty("btnGuardar"));
        AgregarEmpresa.nuevoCif.setText(lenguaje.getProperty("cif"));
        AgregarEmpresa.nuevoNombre.setText(lenguaje.getProperty("nombreEmpresa"));
        AgregarEmpresa.nuevoTelefono.setText(lenguaje.getProperty("telefonoEmpresa"));
        AgregarEmpresa.nuevoNumEmpleados.setText(lenguaje.getProperty("numEmpleadoEmpresa"));
        AgregarEmpresa.nuevoSector.setText(lenguaje.getProperty("sectorEmpresa"));
        AgregarEmpresa.nuevoDireccion.setText(lenguaje.getProperty("direccionEmpresa"));
        AgregarEmpresa.cartelInformacion.setText(lenguaje.getProperty("cartelInformacaionEmpresa"));
        ListaDeEmpresasConPracticas.ciclo = lenguaje.getProperty("ciclo");

    }
}

