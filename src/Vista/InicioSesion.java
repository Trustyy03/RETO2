package Vista;

import Controlador.MainPanelController;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JPanel {

    public static JLabel usuario,contrasenya,ipLabel,puertoLabel;
    public static JTextField rellenarUsuario,rellenarContrasenya,ipTextField,puertoTextField;
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
        ipTextField = Estilo.textFieldBonito(7);

        puertoLabel = Estilo.textoBonito(lenguaje.getProperty("puertoTexto"));
        puertoTextField = Estilo.textFieldBonito(7);

        usuario = Estilo.textoBonito(lenguaje.getProperty("usuarioInicio"));
        rellenarUsuario = Estilo.textFieldBonito(14);

        contrasenya = Estilo.textoBonito(lenguaje.getProperty("contrasenyaInico"));
        rellenarContrasenya = Estilo.textFieldBonito(14);

        entrar = Estilo.botonBonito(lenguaje.getProperty("entrarInicio"));
        colocarComponentes();

        entrar.addActionListener(e->{
            MainPanelController.nuevoPanelActivo(opcionesPanel);
            framePrincipal.setTitle("OPCIONES");
            if (e.getSource() == entrar){
                PanelPrincipal.nombreUsuario.setText(rellenarUsuario.getText());
            }
        });

    }

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
        add(usuario, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        add(rellenarUsuario, constraints);

        // Row 3
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        add(contrasenya, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        add(rellenarContrasenya, constraints);

        // Row 4
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        add(entrar, constraints);
    }
}
