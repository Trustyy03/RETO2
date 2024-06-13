package Vista;

import Controlador.*;
import Modelo.ConexionBDD;
import Vista.Empresas.*;
import Vista.FCT.*;
import Vista.Idioma.Lenguaje;
import Vista.Profesores.AgregarTutor;
import Vista.Profesores.GestionarTutores;
import Vista.Profesores.OpcionesProfesores;
import Vista.Trabajadores.AgregarTrabajador;
import Vista.Trabajadores.GestionarTrabajadores;
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
    setTitle("FCT MANAGER"); //Cuando se realice el inicio de sesión, cambiar el titulo al panel en el que esten (mediante actionsListeners)
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
        //nombreUsuario = new JLabel(lenguaje.getProperty("nombree"));
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
        //northPanel.add(nombreUsuario,BorderLayout.CENTER);
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
        //nombreUsuario.setText(lenguaje.getProperty("nombree"));//+ " "+ InicioSesion.rellenarUsuario.getText());
        OpcionesPanel.btnFct.setText(lenguaje.getProperty("btnFct"));
        OpcionesPanel.btnEmpresas.setText(lenguaje.getProperty("btnEmpresas"));
        OpcionesPanel.btnProfesores.setText(lenguaje.getProperty("btnProfesores"));
        OpcionesPanel.btnTrabajadores.setText(lenguaje.getProperty("btnTrabajadores"));
        //InicioSesion.nombree = lenguaje.getProperty("nombree");
        //InicioSesion.usuario.setText(lenguaje.getProperty("usuarioInicio"));
        //InicioSesion.contrasenya.setText(lenguaje.getProperty("contrasenyaInico"));
        //InicioSesion.entrar.setText(lenguaje.getProperty("entrarInicio"));
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

        BuscarEmpresa.labelEmpresa.setText(lenguaje.getProperty("labelEmpresa"));
        BuscarEmpresa.botonEnviar.setText(lenguaje.getProperty("btnEnviar"));

        try {
            DetallesEmpresa.nombreEmpresa.setText(lenguaje.getProperty("nombreEmpresa"));
            DetallesEmpresa.nombreTutor.setText(lenguaje.getProperty("nombreTutor"));
            DetallesEmpresa.nombreTrabajador.setText(lenguaje.getProperty("nombreTrabajador"));
            DetallesEmpresa.correoTrabajador.setText(lenguaje.getProperty("correoTrabajador"));
            DetallesEmpresa.telefonoTrabajador.setText(lenguaje.getProperty("telefonoTrabajador"));
            DetallesEmpresa.labelEmpresa.setText(lenguaje.getProperty("cartelInfoEmpresa"));
        }catch (NullPointerException e){

        }
        BuscarEmpresaPorPractica.labelCiclo.setText(lenguaje.getProperty("labelCiclo"));
        BuscarEmpresaPorPractica.labelCurso.setText(lenguaje.getProperty("labelCurso"));
        BuscarEmpresaPorPractica.botonListaEmpresas.setText(lenguaje.getProperty("botonListaEmpresas"));

        BuscarEmpresaPorTecnologia.actualizarIdiomaCabecera(newLang);

        ListaDeEmpresasConPracticas.ciclo = lenguaje.getProperty("ciclo");


        GestionarFCT.cif.setText(lenguaje.getProperty("cif"));
        GestionarFCT.idGrupo.setText(lenguaje.getProperty("idGrupoFCT"));
        GestionarFCT.cursoEscolar.setText(lenguaje.getProperty("cursoEscolarFCT"));
        GestionarFCT.numAlumnos.setText(lenguaje.getProperty("numAlumnosFCT"));
        GestionarFCT.btnGuardarFCT.setText(lenguaje.getProperty("btnGuardar"));
        GestionarFCT.btnAgregarFCT.setText(lenguaje.getProperty("btnAgregar"));
        GestionarFCT.btnBorrarFCT.setText(lenguaje.getProperty("btnBorrar"));

        AgregarFCT.nuevoCif.setText(lenguaje.getProperty("cif"));
        AgregarFCT.nuevoIdGrupo.setText(lenguaje.getProperty("idGrupoFCT"));
        AgregarFCT.nuevoCursoEscolar.setText(lenguaje.getProperty("cursoEscolarFCT"));
        AgregarFCT.nuevoNumAlumnos.setText(lenguaje.getProperty("numAlumnosFCT"));
        AgregarFCT.btnGuardarFCT.setText(lenguaje.getProperty("btnGuardar"));
        AgregarFCT.cartelInformacion.setText(lenguaje.getProperty("cartelInformacaionFCT"));

        BuscarFCT.labelCurso.setText(lenguaje.getProperty("labelCurso"));
        BuscarFCT.labelEmpresa.setText(lenguaje.getProperty("labelEmpresa"));

        BuscarEmpresaCurso.labelCurso.setText(lenguaje.getProperty("labelCurso"));
        BuscarEmpresaCurso.labelCiclo.setText(lenguaje.getProperty("labelCiclo"));
        BuscarEmpresaCurso.labelEmpresa.setText(lenguaje.getProperty("labelEmpresa"));
        BuscarEmpresaCurso.botonListaTrabajadores.setText(lenguaje.getProperty("botonListaTrabajadores"));


        GestionarTutores.idTutor.setText(lenguaje.getProperty("idTutor"));
        GestionarTutores.nombre.setText(lenguaje.getProperty("nombreTutor"));
        GestionarTutores.apellidos.setText(lenguaje.getProperty("apellidosTutor"));
        GestionarTutores.btnBorrarTutor.setText(lenguaje.getProperty("btnBorrar"));
        GestionarTutores.btnAgregarTutor.setText(lenguaje.getProperty("btnAgregar"));
        GestionarTutores.btnGuardarTutor.setText(lenguaje.getProperty("btnGuardar"));

        AgregarTutor.nuevoNombre.setText(lenguaje.getProperty("nombreTutor"));
        AgregarTutor.nuevoApellidos.setText(lenguaje.getProperty("apellidosTutor"));
        AgregarTutor.btnGuardarTutor.setText(lenguaje.getProperty("btnGuardar"));
        AgregarTutor.cartelInformativo.setText(lenguaje.getProperty("cartelInformacaionTutor"));


        GestionarTrabajadores.idTrabajador.setText(lenguaje.getProperty("idTrabajador"));
        GestionarTrabajadores.nombreTrabajador.setText(lenguaje.getProperty("nombreTrabajador"));
        GestionarTrabajadores.apellidosTrabajador.setText(lenguaje.getProperty("apellidosTrabajador"));
        GestionarTrabajadores.correoTrabajador.setText(lenguaje.getProperty("correoTrabajador"));
        GestionarTrabajadores.cargoTrabajador.setText(lenguaje.getProperty("cargoTrabajador"));
        GestionarTrabajadores.telefonoTrabajador.setText(lenguaje.getProperty("telefonoTrabajador"));
        GestionarTrabajadores.btnAgregarTrabajador.setText(lenguaje.getProperty("btnAgregar"));
        GestionarTrabajadores.btnGuardarTrabajador.setText(lenguaje.getProperty("btnGuardar"));
        GestionarTrabajadores.btnBorrarTrabajador.setText(lenguaje.getProperty("btnBorrar"));

        AgregarTrabajador.nuevoNombreTrabajador.setText(lenguaje.getProperty("nombreTrabajador"));
        AgregarTrabajador.nuevoApellidosTrabajador.setText(lenguaje.getProperty("apellidosTrabajador"));
        AgregarTrabajador.nuevoCorreoTrabajador.setText(lenguaje.getProperty("correoTrabajador"));
        AgregarTrabajador.nuevoCargoTrabajador.setText(lenguaje.getProperty("cargoTrabajador"));
        AgregarTrabajador.nuevoTelefonoTrabajador.setText(lenguaje.getProperty("telefonoTrabajador"));
        AgregarTrabajador.btnGuardarTrabajador.setText(lenguaje.getProperty("btnGuardar"));
        AgregarTrabajador.cartelInformativo.setText(lenguaje.getProperty("cartelInformacaionTrabajador"));

    }
}

