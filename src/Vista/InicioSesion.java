package Vista;

import Controlador.MainPanelController;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JPanel {

    public static JLabel usuario,contrasenya,ipLabel,puertoLabel,nombreBaseDatosLabel;
    public static JTextField rellenarUsuario,rellenarContrasenya,ipTextField,puertoTextField,nombreBaseDatosField;
    public static JButton entrar;

    GridBagConstraints constraints;

    public InicioSesion(FramePrincipal framePrincipal){

        this.setLayout(new GridBagLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        OpcionesPanel opcionesPanel = new OpcionesPanel();

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10,10,10,10);

        ipLabel = Estilo.textoBonito(lenguaje.getProperty("ipTexto"));
        ipTextField = Estilo.textFieldBonito(10);

        puertoLabel = Estilo.textoBonito(lenguaje.getProperty("puertoTexto"));
        puertoTextField = Estilo.textFieldBonito(10);

        nombreBaseDatosLabel = Estilo.textoBonito(lenguaje.getProperty("baseDatosTexto"));
        nombreBaseDatosField = Estilo.textFieldBonito(10);

        usuario = Estilo.textoBonito(lenguaje.getProperty("usuarioInicio"));
        rellenarUsuario = Estilo.textFieldBonito(20);

        contrasenya = Estilo.textoBonito(lenguaje.getProperty("contrasenyaInico"));
        rellenarContrasenya = Estilo.textFieldBonito(20);

        entrar = Estilo.botonBonito(lenguaje.getProperty("entrarInicio"));
        colocarComponentes();

        entrar.addActionListener(e -> {
           // if (camposVacios(ipTextField, puertoTextField, nombreBaseDatosField, rellenarUsuario, rellenarContrasenya)) {
           //     JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            //} else {
                MainPanelController.nuevoPanelActivo(opcionesPanel);
                framePrincipal.setTitle("OPCIONES");
                PanelPrincipal.nombreUsuario.setText("Nombre: " + rellenarUsuario.getText() + "/" + nombreBaseDatosField.getText() + "" +
                        "/" + ipTextField.getText() + "/"+puertoTextField.getText()+"/");
           // }
        });
    }
/*
    private boolean camposVacios(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }*/

    public void colocarComponentes() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        add(ipLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        add(ipTextField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        add(puertoLabel, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        add(puertoTextField, constraints);

        // Row 2
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(nombreBaseDatosLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        add(nombreBaseDatosField, constraints);

        // Row 3
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(usuario, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        add(rellenarUsuario, constraints);

        // Row 4
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        add(contrasenya, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        add(rellenarContrasenya, constraints);

        // Row 5
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        add(entrar, constraints);
    }
}
