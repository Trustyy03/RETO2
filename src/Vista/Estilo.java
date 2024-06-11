package Vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Estilo {

    public static JButton botonBonito(String text) {
        JButton button = new JButton(text);

        // Colores personalizados
        Color defaultBackgroundColor = new Color(70, 130, 180); // Azul
        Color hoverBackgroundColor = new Color(0, 79, 219);  // Azul claro
        Color defaultForegroundColor = Color.WHITE;            // Blanco
        Color hoverForegroundColor = Color.WHITE;             // Amarillo

        // Configuración del botón
        button.setBackground(defaultBackgroundColor);
        button.setForeground(defaultForegroundColor);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        // Añadir MouseAdapter para cambiar el color cuando el ratón pasa por encima
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverBackgroundColor);
                button.setForeground(hoverForegroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultBackgroundColor);
                button.setForeground(defaultForegroundColor);
            }
        });

        return button;
    }

    public static JButton botonBonitoDeLaBarra(String text){
        JButton button = new JButton(text);

        button.setBackground(new Color(70, 130, 180)); // Azul
        button.setForeground(Color.WHITE); // Blanco
        button.setFont(new Font("Arial", Font.BOLD, 20));

        return button;
    }

    public static JLabel textoBonitoInicioSesion(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setForeground(Color.BLACK);

        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setVisible(true);

        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        return label;
    }

    public static JLabel textoBonito(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        label.setBackground(new Color(118, 179, 231));

        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setVisible(true);

        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        return label;
    }

    public static JLabel textoBonitoInfo(String text){
        JLabel label = new JLabel(text);

        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        menuBar.setBackground(new Color(70, 130, 180));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return menuBar;
    }

    public static JMenu menuBonito(String text) {
        JMenu menu = new JMenu(text);
        menu.setForeground(Color.WHITE);
        menu.setFont(new Font("Arial", Font.BOLD, 16));
        menu.setOpaque(true);
        menu.setBackground(new Color(70, 130, 180));
        menu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return menu;
    }

    public static JMenuItem menuItemBonito(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem.setOpaque(true);
        menuItem.setBackground(Color.WHITE);
        menuItem.setForeground(Color.BLACK);
        menuItem.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 1));
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

    public static JComboBox<String> estiloComboBox(String[] items){
        JComboBox<String> comboBox = new JComboBox<>(items);

        // Set foreground and background colors
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(Color.BLUE);
        comboBox.setOpaque(true);

        // Customize the combo box renderer
        comboBox.setRenderer(new CustomComboBoxRenderer());

        return comboBox;
    }

    public static <T> JComboBox<T> estiloComboBox(){
        JComboBox<T> comboBox = new JComboBox<>();

        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(Color.WHITE);
        comboBox.setSize(50,50);
        comboBox.setOpaque(true);

        comboBox.setRenderer(new CustomComboBoxRenderer());

        return comboBox;
    }

    static class CustomComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            label.setFont(new Font("Arial", Font.BOLD, 14));

            if (isSelected) {
                label.setBackground(Color.BLACK);
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(new Color(118, 179, 231));
                label.setForeground(Color.BLACK);
            }

            label.setOpaque(true);
            label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.WHITE, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));

            return label;
        }
    }



}
