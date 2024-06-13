package Vista.Trabajadores;

import Controlador.TrabajadorController;
import Modelo.Entidades.Empresa;
import Modelo.Entidades.Trabajador;
import Vista.Estilo;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class AgregarTrabajador extends JPanel{

    public static JLabel nuevoCifTrabajador, nuevoNombreTrabajador,
            nuevoApellidosTrabajador,nuevoCorreoTrabajador,nuevoCargoTrabajador,nuevoTelefonoTrabajador,cartelInformativo;
    public static JTextField nuevoRellenarNombreTrabajador, nuevoRellenarApellidosTrabajador,
            nuevoRellenarCorreoTrabajador,nuevoRellenarTelefonoTrabajador,nuevoRellenarCargoTrabajador;

    public static JButton btnGuardarTrabajador;

    static Trabajador trabajadorNuevo;

    public static JComboBox<Empresa> CBListadoEmpresas = Estilo.estiloComboBox();

    public AgregarTrabajador(){

        this.setLayout(new BorderLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        JPanel panelNorte = new JPanel();
        cartelInformativo = Estilo.cartelInformativoBonito(lenguaje.getProperty("cartelInformacaionTrabajador"));
        panelNorte.add(cartelInformativo);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        nuevoCifTrabajador = Estilo.textoBonito(lenguaje.getProperty("cif"));
        nuevoNombreTrabajador = Estilo.textoBonito(lenguaje.getProperty("nombreTrabajador"));
        nuevoRellenarNombreTrabajador = Estilo.textFieldBonito(20);
        nuevoApellidosTrabajador = Estilo.textoBonito(lenguaje.getProperty("apellidosTrabajador"));
        nuevoRellenarApellidosTrabajador = Estilo.textFieldBonito(20);
        nuevoCorreoTrabajador = Estilo.textoBonito(lenguaje.getProperty("correoTrabajador"));
        nuevoRellenarCorreoTrabajador = Estilo.textFieldBonito(20);
        nuevoCargoTrabajador = Estilo.textoBonito(lenguaje.getProperty("cargoTrabajador"));
        nuevoRellenarCargoTrabajador = Estilo.textFieldBonito(20);
        nuevoTelefonoTrabajador = Estilo.textoBonito(lenguaje.getProperty("telefonoTrabajador"));
        nuevoRellenarTelefonoTrabajador = Estilo.textFieldBonito(20);

        configurarCoordenadasCB(panelCentral,gbc,nuevoCifTrabajador, CBListadoEmpresas,0);
        configurarCoordenadas(panelCentral, gbc, nuevoNombreTrabajador, nuevoRellenarNombreTrabajador, 1);
        configurarCoordenadas(panelCentral, gbc, nuevoApellidosTrabajador, nuevoRellenarApellidosTrabajador, 2);
        configurarCoordenadas(panelCentral, gbc, nuevoCorreoTrabajador, nuevoRellenarCorreoTrabajador, 3);
        configurarCoordenadas(panelCentral, gbc, nuevoCargoTrabajador, nuevoRellenarCargoTrabajador, 4);
        configurarCoordenadas(panelCentral, gbc, nuevoTelefonoTrabajador, nuevoRellenarTelefonoTrabajador, 5);

        JPanel panelSur = new JPanel();
        btnGuardarTrabajador = Estilo.botonBonito(lenguaje.getProperty("btnGuardar"));
        btnGuardarTrabajador.setFont(new Font("Arial", Font.BOLD, 30));
        panelSur.add(btnGuardarTrabajador);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        btnGuardarTrabajador.addActionListener(e-> {Empresa empresa = (Empresa) CBListadoEmpresas.getSelectedItem(); agregarTrabajador(empresa);vaciarDatos();});

    }
    private void configurarCoordenadas(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private void configurarCoordenadasCB(JPanel panel, GridBagConstraints gbc, JLabel label, JComboBox cb, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(cb, gbc);
    }

    private static void agregarTrabajador(Empresa empresa){
        trabajadorNuevo = new Trabajador(empresa.getCif(),nuevoRellenarNombreTrabajador.getText(),
                nuevoRellenarApellidosTrabajador.getText(), nuevoRellenarCorreoTrabajador.getText(),
                nuevoRellenarCargoTrabajador.getText(),nuevoRellenarTelefonoTrabajador.getText());
        TrabajadorController.insertarTrabajador(trabajadorNuevo);
    }

    private static void vaciarDatos(){
        nuevoRellenarNombreTrabajador.setText("");
        nuevoRellenarApellidosTrabajador.setText("");nuevoRellenarCorreoTrabajador.setText("");nuevoRellenarCargoTrabajador.setText("");
        nuevoRellenarTelefonoTrabajador.setText("");
    }



}
