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

        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        return button;
    }

    public static JLabel textoBonito(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setBackground(new Color(70, 130, 180));
        label.setForeground(Color.WHITE);

        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setVisible(true);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        return label;
    }

    public static JLabel cartelInformativoBonito(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setVisible(true);
        return label;
    }

}
