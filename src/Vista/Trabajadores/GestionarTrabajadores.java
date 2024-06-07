package Vista.Trabajadores;

import Modelo.Entidades.Trabajador;
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
        apellidosTrabajador = Estilo.textoBonito(lenguaje.getProperty("ape"));
        rellenarApellidosTrabajador = new JTextField(20);
        correoTrabajador = Estilo.textoBonito(lenguaje.getProperty("numEmpleadoEmpresa"));
        rellenarCorreoTrabajador = new JTextField(20);


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



    }

}
