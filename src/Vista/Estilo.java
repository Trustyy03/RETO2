package Vista;

import javax.swing.*;
import java.awt.*;

public class Estilo {

    public static JButton botonBonito(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setFocusPainted(false);

        return button;
    }

    public static JLabel textoBonito(String text){
        JLabel label = new JLabel(text);

        label.setBackground(new Color(70, 130, 180));
        label.setForeground(Color.WHITE);

        label.setFont(new Font("Arial", Font.BOLD, 30));

        return label;
    }

}
