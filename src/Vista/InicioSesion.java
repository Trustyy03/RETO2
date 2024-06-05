package Vista;

import Vista.Idioma.Lenguaje;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JPanel {

    JLabel usuario;
    JLabel contrasenya;
    JTextField rellenarUsuario;
    JTextField rellenarContrasenya;
    JButton entrar;
    GridBagConstraints constraints;

    public InicioSesion(){
        this.setLayout(new GridBagLayout());

        Lenguaje lenguaje = new Lenguaje(Lenguaje.spanish);

        constraints = new GridBagConstraints();

        usuario = new JLabel(lenguaje.getProperty("usuarioInicio"));
        rellenarUsuario = new JTextField(15);

        contrasenya = new JLabel(lenguaje.getProperty("contrasenyaInico"));
        rellenarContrasenya = new JTextField(15);

        entrar = new JButton(lenguaje.getProperty("entrarInicio"));
        colocarComponentes();

    }

    public void colocarComponentes() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1;
        add(usuario, constraints);

        constraints.gridx = 1;
        add(rellenarUsuario, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(contrasenya, constraints);

        constraints.gridx = 1;
        add(rellenarContrasenya, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(entrar, constraints);
    }
}
