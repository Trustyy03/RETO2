package Vista.Empresas;

import javax.swing.*;
import java.awt.*;

public class DetallesEmpresa extends JPanel {

    JLabel labelEmpresa;

    public DetallesEmpresa() {
        setLayout(new BorderLayout());

        labelEmpresa = new JLabel("Información de la empresa", JLabel.CENTER);
        //aqui se pondrá toda la información de la empresa (lo que nos piden poner)
        labelEmpresa.setFont(new Font("Arial", Font.BOLD, 24));

        add(labelEmpresa, BorderLayout.CENTER);
    }
}
