package Vista;

import Controlador.MainPanelController;
import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JPanel {

    public static JLabel usuario,contrasenya;
    public static JTextField rellenarUsuario,rellenarContrasenya;
    public static JButton entrar;

    GridBagConstraints constraints;

    public InicioSesion(){

        this.setLayout(new GridBagLayout());
        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        OpcionesPanel opcionesPanel = new OpcionesPanel();

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10,10,10,10);

        usuario = new JLabel(lenguaje.getProperty("usuarioInicio"));
        rellenarUsuario = new JTextField(15);

        contrasenya = new JLabel(lenguaje.getProperty("contrasenyaInico"));
        rellenarContrasenya = new JTextField(15);

        entrar = new JButton(lenguaje.getProperty("entrarInicio"));
        colocarComponentes();

        entrar.addActionListener(e-> MainPanelController.nuevoPanelActivo(opcionesPanel));

    }

    public void colocarComponentes() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        add (usuario, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add (rellenarUsuario, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add (contrasenya, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        add (rellenarContrasenya, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        add (entrar, constraints);
    }
}
