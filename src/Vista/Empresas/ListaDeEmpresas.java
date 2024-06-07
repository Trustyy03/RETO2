package Vista.Empresas;

import javax.swing.*;
import java.awt.*;

public class ListaDeEmpresas extends JPanel {

    DetallesEmpresa detallesEmpresaApartado;

    public ListaDeEmpresas() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton empresa1 = new JButton("EMPRESA 1");
        JButton empresa2 = new JButton("EMPRESA 2");
        // Añadir más empresas según sea necesario
        empresa1.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Mostrar detalles de EMPRESA 1")
        );
        empresa2.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Mostrar detalles de EMPRESA 2")
        );

        add(empresa1);
        add(empresa2);
    }
}
