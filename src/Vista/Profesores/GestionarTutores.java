package Vista.Profesores;

import Controlador.MainPanelController;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.Tutor;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestionarTutores extends JPanel {

    public static ArrayList<Tutor> listaTutores;
    public static JLabel idTutor, nombre, apellidos;
    public static JTextField rellenarIdTutor, rellenarNombre, rellenarApellidos;

    public static JButton btnGuardarTutor, btnBorrarTutor, btnAgregarTutor;

    public static JComboBox<Empresa> CBlistadoTutores;

    static Tutor tutorSeleccionada;

    public GestionarTutores() {

        this.setLayout(new BorderLayout());

        AgregarTutor agregarTutor = new AgregarTutor();

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        CBlistadoTutores = new JComboBox<>();
        agregarEmpresas();

        btnBorrarTutor = new JButton(lenguaje.getProperty("btnBorrar"));
        btnAgregarTutor = new JButton(lenguaje.getProperty("btnAgregar"));
        panelNorte.add(CBlistadoTutores);
        panelNorte.add(btnBorrarTutor);
        panelNorte.add(btnAgregarTutor);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        idTutor = Estilo.textoBonito(lenguaje.getProperty("idTutor"));
        rellenarIdTutor = new JTextField(20);
        nombre = Estilo.textoBonito(lenguaje.getProperty("nombreTutor"));
        rellenarNombre = new JTextField(20);
        apellidos = Estilo.textoBonito(lenguaje.getProperty("apellidosTutor"));
        rellenarApellidos = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, idTutor, rellenarIdTutor, 0);
        configurarCoordenadas(panelCentral, gbc, nombre, rellenarNombre, 1);
        configurarCoordenadas(panelCentral, gbc, apellidos, rellenarApellidos, 2);

        JPanel panelSur = new JPanel();
        btnGuardarTutor = new JButton(lenguaje.getProperty("btnGuardar"));
        panelSur.add(btnGuardarTutor);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        CBlistadoTutores.addActionListener(e-> {tutorSeleccionada =(Tutor) CBlistadoTutores.getSelectedItem();
            rellenarDatos(tutorSeleccionada);});

        btnAgregarTutor.addActionListener(e-> MainPanelController.nuevoPanelActivo(agregarTutor));



    }
    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void rellenarDatos(Tutor tutor){

        rellenarIdTutor.setText(String.valueOf(tutor.getIdTutor()));
        rellenarNombre.setText(tutor.getNombre());
        rellenarApellidos.setText(tutor.getApellidos());
    }

    private static void agregarEmpresas(){
    /*    listaTutores = OperacionesEntidades.consultarEmpresas();
        //  listaEmpresas = EmrpesasMentira.getListaEmpresas();

        for (Tutor tutor : listaTutores) {
            CBlistadoTutores.addItem(tutor);
        }

     */
    }

}
