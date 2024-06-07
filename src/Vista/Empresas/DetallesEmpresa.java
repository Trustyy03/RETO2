package Vista.Empresas;

import javax.swing.*;
import java.awt.*;

public class DetallesEmpresa extends JPanel {

    public DetallesEmpresa(String nombreEmpresa) {
        setLayout(new BorderLayout());

        JLabel labelEmpresa = new JLabel(nombreEmpresa, JLabel.CENTER);
        labelEmpresa.setFont(new Font("Arial", Font.BOLD, 24));

        add(labelEmpresa, BorderLayout.CENTER);
    }
}
