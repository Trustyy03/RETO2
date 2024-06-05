package Vista;

import javax.swing.*;
import java.awt.*;

public class BarraPrincipal extends JPanel {

    JLabel nombreUsuario;
    JButton inicio;
    JButton atras;

    public BarraPrincipal(JPanel panel){

        setSize(800,100);
        setBackground(new Color(160, 47, 47));
        inicio = new JButton("INICIO");
        inicio.addActionListener( a -> {
            if (a.getSource() == inicio){

                //panel = new InicioSesion();
                //Arrancar el panel con el que este el inicio sesión
                //


            }
        });
    }


}
