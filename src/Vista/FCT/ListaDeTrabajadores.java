package Vista.FCT;

import Vista.ComponentesGridBagLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaDeTrabajadores extends JPanel implements ComponentesGridBagLayout {

    GridBagConstraints constraints;
    JTable datosFCT;
    public static DefaultTableModel modelo;


    public ListaDeTrabajadores() {

        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        String[] nombresCampos = new String[]{"CIF Empresa", "Nombre Empresa", "Alumnos Pedidos", "Ciclo"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        datosFCT = new JTable(modelo);
        colocarComponentes();
    }

    @Override
    public void colocarComponentes() {
        JScrollPane scrollPane = new JScrollPane();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        scrollPane.add(datosFCT);
        add(scrollPane, constraints);
    }
}
