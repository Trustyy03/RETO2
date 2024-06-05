package Vista;

import javax.swing.*;
import java.awt.*;

public class InicioSesion extends JFrame {


    public InicioSesion(){

        inicioSesionPanel inicioSesionPanel = new inicioSesionPanel();
        add(inicioSesionPanel);
        setTitle("INICIO SESIÓN"); //Cuando se realice el inicio de sesión, cambiar el titulo al panel en el que esten
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InicioSesion();
    }


}

class inicioSesionPanel extends JPanel{

    boolean idiomaBotonPresionado = true;
    JLabel usuario;
    JLabel contrasenya;
    JTextField rellenarUsuario;
    JTextField rellenarContrasenya;
    JPanel posicionCampos;
    JButton entrar;
    JButton idioma;
    JPanel posicionIdioma;

    public inicioSesionPanel(){

        this.setLayout(new GridBagLayout());

        posicionCampos = new JPanel(new GridLayout(3,2));
        posicionIdioma = new JPanel();
        add(posicionCampos, BorderLayout.CENTER);

        usuario = new JLabel("Usuario: ");
        rellenarUsuario = new JTextField();
        contrasenya = new JLabel("Contraseña: ");
        rellenarContrasenya = new JTextField();
        entrar = new JButton("ENTRAR");

        posicionCampos.add(usuario);
        posicionCampos.add(rellenarUsuario);
        posicionCampos.add(contrasenya);
        posicionCampos.add(rellenarContrasenya);
        posicionCampos.add(entrar);

        add(posicionIdioma,BorderLayout.NORTH);

        idioma = new JButton("ENGLISH");
        idioma.addActionListener(a -> { //actionListener Visual
            if (a.getSource() == idioma){
                if (idiomaBotonPresionado) {
                    idioma.setText("ESPAÑOL");
                } else {
                    idioma.setText("ENGLISH");
                }
                idiomaBotonPresionado = !idiomaBotonPresionado;
            }
        });

        posicionIdioma.add(idioma);

    }

}
