package Vista;

import javax.swing.*;
import java.awt.*;

public class EstiloBoton {

    public static JButton botonBonito(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setFocusPainted(false);

        return button;
    }

}
