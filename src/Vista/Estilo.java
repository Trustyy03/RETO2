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
        label.setForeground(Color.BLACK);

        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setVisible(true);

        label.setHorizontalAlignment(SwingConstants.LEFT);
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

    public static JMenuBar menuBarBonito() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(70, 130, 180)); // Azul
        menuBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Borde blanco
        return menuBar;
    }

    public static JMenu menuBonito(String text) {
        JMenu menu = new JMenu(text);
        menu.setForeground(Color.WHITE); // Texto blanco
        menu.setFont(new Font("Arial", Font.BOLD, 16));
        menu.setOpaque(true);
        menu.setBackground(new Color(70, 130, 180)); // Azul
        menu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return menu;
    }

    public static JMenuItem menuItemBonito(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem.setOpaque(true);
        menuItem.setBackground(Color.WHITE); // Blanco
        menuItem.setForeground(Color.BLACK); // Negro
        menuItem.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1)); // Borde azul
        return menuItem;
    }

    public static JTextField textFieldBonito(int columnas) {
        JTextField textField = new JTextField(columnas);
        textField.setBackground(Color.WHITE); // Blanco
        textField.setForeground(Color.BLACK); // Negro
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        textField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Azul

        return textField;
    }





}
