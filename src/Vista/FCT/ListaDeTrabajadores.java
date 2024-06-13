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

        String[] nombresCampos = new String[]{"Cif Empresa", "Nombre empresa", "Alumnos Pedidos", "Ciclo preferido"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombresCampos);
        datosFCT = new JTable(modelo);
        colocarComponentes();
    }

    @Override
    public void colocarComponentes() {
        JScrollPane scrollPane = new JScrollPane(datosFCT);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPane, constraints);
    }
}
