package Vista.Trabajadores;

import Controlador.MainPanelController;
import Controlador.TrabajadorController;
import Modelo.Entidades.Trabajador;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GestionarTrabajadores extends JPanel {
    public static JLabel idTrabajador, cifTrabajador, nombreTrabajador,
            apellidosTrabajador, correoTrabajador, cargoTrabajador, telefonoTrabajador;
    public static JTextField rellenarId, rellenarCif, rellenarNombreTrabajador, rellenarApellidosTrabajador,
            rellenarCorreoTrabajador, rellenarCargoTrabajador, rellenarTelefonoTrabajador;
    public static JButton btnGuardarTrabajador, btnBorrarTrabajador, btnAgregarTrabajador;
    static Trabajador trabajadorSeleccionado, trabajadorNuevo;

    public static JComboBox<Trabajador> CBListadoTrabajadores = new JComboBox<>();

    public GestionarTrabajadores() {
        this.setLayout(new BorderLayout());

        AgregarTrabajador agregarTrabajadorPanel = new AgregarTrabajador();

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();

        btnBorrarTrabajador = new JButton(lenguaje.getProperty("btnBorrar"));
        btnAgregarTrabajador = new JButton(lenguaje.getProperty("btnAgregar"));
        panelNorte.add(CBListadoTrabajadores);
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
        correoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoTrabajador"));
        rellenarCorreoTrabajador = new JTextField(20);
        cargoTrabajador = Estilo.textoBonito(lenguaje.getProperty("cargoTrabajador"));
        rellenarCargoTrabajador = new JTextField(20);
        telefonoTrabajador = Estilo.textoBonito(lenguaje.getProperty("telefonoTrabajador"));
        rellenarTelefonoTrabajador = new JTextField(20);

        configurarCoordenadas(panelCentral, gbc, idTrabajador, rellenarId, 0);
        configurarCoordenadas(panelCentral, gbc, cifTrabajador, rellenarCif, 1);
        configurarCoordenadas(panelCentral, gbc, nombreTrabajador, rellenarNombreTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, apellidosTrabajador, rellenarApellidosTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, correoTrabajador, rellenarCorreoTrabajador, 4);
        configurarCoordenadas(panelCentral, gbc, cargoTrabajador, rellenarCargoTrabajador, 5);
        configurarCoordenadas(panelCentral, gbc, telefonoTrabajador, rellenarTelefonoTrabajador, 6);

        JPanel panelSur = new JPanel();
        btnGuardarTrabajador = new JButton(lenguaje.getProperty("btnGuardar"));
        panelSur.add(btnGuardarTrabajador);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        CBListadoTrabajadores.addActionListener(e -> {
            trabajadorSeleccionado = (Trabajador) CBListadoTrabajadores.getSelectedItem();
            rellenarDatos(trabajadorSeleccionado);
        });

        btnAgregarTrabajador.addActionListener(e -> MainPanelController.nuevoPanelActivo(agregarTrabajadorPanel));
        btnBorrarTrabajador.addActionListener(e -> {
            trabajadorSeleccionado = (Trabajador) CBListadoTrabajadores.getSelectedItem();
            TrabajadorController.eliminarTrabajador(trabajadorSeleccionado);
        });
        btnGuardarTrabajador.addActionListener(e -> {
            trabajadorSeleccionado = (Trabajador) CBListadoTrabajadores.getSelectedItem();
            guardarDatos();
            TrabajadorController.modificarTrabajador(trabajadorNuevo,trabajadorSeleccionado);
        });
    }

    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static void rellenarDatos(Trabajador trabajador) {
        if (trabajador != null) {
            rellenarId.setText(String.valueOf(trabajador.getId()));
            rellenarCif.setText(trabajador.getCif());
            rellenarNombreTrabajador.setText(trabajador.getNombre());
            rellenarApellidosTrabajador.setText(trabajador.getApellidos());
            rellenarCorreoTrabajador.setText(trabajador.getCorreo());
            rellenarCargoTrabajador.setText(trabajador.getCargo());
            rellenarTelefonoTrabajador.setText(trabajador.getTelefono());
        }
    }

    private static void guardarDatos() {
        trabajadorNuevo = new Trabajador(Integer.parseInt(rellenarId.getText()), rellenarCif.getText(),
                rellenarNombreTrabajador.getText(), rellenarApellidosTrabajador.getText(), rellenarCorreoTrabajador.getText(),
                rellenarCargoTrabajador.getText(), rellenarTelefonoTrabajador.getText()
        );
    }
}
