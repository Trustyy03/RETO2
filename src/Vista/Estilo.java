package Vista;

import javax.swing.*;
import java.awt.*;

public class Estilo {

    public static JButton botonBonito(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180)); // Azul
        button.setForeground(Color.WHITE); // Blanco

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setFocusPainted(false);

        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        return button;
    }

    public static JButton botonBonitoDeLaBarra(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180)); // Azul
        button.setForeground(Color.WHITE); // Blanco
        button.setFont(new Font("Arial", Font.BOLD, 20));

        return button;
    }

    public static JLabel textoBonito(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setBackground(new Color(153, 196, 235, 195));
        label.setForeground(Color.BLACK);

        label.setFont(new Font("Arial", Font.PLAIN, 25));
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

    public static JComboBox<String> comboBoxBonito(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(Color.WHITE); // Blanco
        comboBox.setForeground(Color.BLACK); // Negro
        comboBox.setFont(new Font("Arial", Font.PLAIN, 20));

        comboBox.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Azul

        return comboBox;
    }

    public static JTextField textFieldBonito() {
        JTextField textField = new JTextField();
        textField.setBackground(Color.WHITE); // Blanco
        textField.setForeground(Color.BLACK); // Negro
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        textField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Azul

        return textField;
    }

    public static JList<String> listBonita(String[] items) {
        JList<String> list = new JList<>(items);
        list.setBackground(Color.WHITE); // Blanco
        list.setForeground(Color.BLACK); // Negro
        list.setFont(new Font("Arial", Font.PLAIN, 20));

        list.setSelectionBackground(new Color(70, 130, 180)); // Azul
        list.setSelectionForeground(Color.WHITE); // Blanco

        return list;
    }

    public static JMenu menuBonito(String text) {
        JMenu menu = new JMenu(text);
        menu.setBackground(new Color(70, 130, 180)); // Azul
        menu.setForeground(Color.WHITE); // Blanco
        menu.setFont(new Font("Arial", Font.BOLD, 20));

        return menu;
    }
}
