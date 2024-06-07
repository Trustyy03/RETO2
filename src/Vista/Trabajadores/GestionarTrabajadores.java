package Vista.Trabajadores;

import Modelo.Entidades.Empresa;
import Modelo.Entidades.Trabajador;
import Modelo.Pruebas.TrabajadoresMentira;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.List;

public class GestionarTrabajadores extends JPanel {

    public static List<Trabajador> listaTrabajadores;
    public static JLabel idTrabajador,cifTrabajador, nombreTrabajador,apellidosTrabajador, correoTrabajador;
    public static JTextField rellenarId,rellenarCif, rellenarNombreTrabajador, rellenarApellidosTrabajador,
            rellenarCorreoTrabajador;
    public static JButton btnGuardarTrabajador,btnBorrarTrabajador,btnAgregarTrabajador;

    public static JComboBox<Trabajador> CBlistadoTrabajadores;
    static Trabajador trabajadorSeleccionado;

    public GestionarTrabajadores(){

        TrabajadoresMentira trabajadoresMentira = new TrabajadoresMentira();

        this.setLayout(new BorderLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        CBlistadoTrabajadores = new JComboBox<>();
        agregarTrabajadores();


        btnBorrarTrabajador = new JButton(lenguaje.getProperty("btnBorrar"));
        btnAgregarTrabajador = new JButton(lenguaje.getProperty("btnAgregar"));
        panelNorte.add(CBlistadoTrabajadores);
        panelNorte.add(btnBorrarTrabajador);
        panelNorte.add(btnAgregarTrabajador);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        idTrabajador = Estilo.textoBonito(lenguaje.getProperty("idTrabajador"));
        rellenarId = new JTextField(20);
        cifTrabajador = Estilo.textoBonito(lenguaje.getProperty("cif"));
        rellenarCif = new JTextField(20);
        nombreTrabajador = Estilo.textoBonito(lenguaje.getProperty("nombreTrabajador"));
        rellenarNombreTrabajador = new JTextField(20);
        apellidosTrabajador = Estilo.textoBonito(lenguaje.getProperty("apellidosTrabajador"));
        rellenarApellidosTrabajador = new JTextField(20);
        correoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoEmpleado"));
        rellenarCorreoTrabajador = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, idTrabajador, rellenarId, 0);
        configurarCoordenadas(panelCentral, gbc, cifTrabajador, rellenarCif, 1);
        configurarCoordenadas(panelCentral, gbc, nombreTrabajador, rellenarNombreTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, apellidosTrabajador, rellenarApellidosTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, correoTrabajador, rellenarCorreoTrabajador, 4);

        JPanel panelSur = new JPanel();
        btnGuardarTrabajador = new JButton(lenguaje.getProperty("btnGuardar"));
        panelSur.add(btnGuardarTrabajador);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        CBlistadoTrabajadores.addActionListener(e-> {trabajadorSeleccionado =(Trabajador) CBlistadoTrabajadores.getSelectedItem();
            rellenarDatos(trabajadorSeleccionado);});

    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void rellenarDatos(Trabajador trabajador){

        rellenarId.setText(String.valueOf(trabajador.getId()));
        rellenarCif.setText(trabajador.getCif());
        rellenarNombreTrabajador.setText(trabajador.getNombre());
        rellenarApellidosTrabajador.setText(trabajador.getApellidos());
        rellenarCorreoTrabajador.setText(trabajador.getCorreo());
    }


    private static void agregarTrabajadores(){
        listaTrabajadores = TrabajadoresMentira.getListaTrabajadores();

        for (Trabajador trabajador : listaTrabajadores){
            CBlistadoTrabajadores.addItem(trabajador);
        }


    }

}
